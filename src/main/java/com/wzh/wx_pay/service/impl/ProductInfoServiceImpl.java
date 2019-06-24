package com.wzh.wx_pay.service.impl;

import com.wzh.wx_pay.common.ResultEnums;
import com.wzh.wx_pay.common.ResultResponse;
import com.wzh.wx_pay.dao.ProductInfoRepository;
import com.wzh.wx_pay.dto.ProductCategoryDto;
import com.wzh.wx_pay.dto.ProductInfoDto;
import com.wzh.wx_pay.entity.ProductInfo;
import com.wzh.wx_pay.service.ProductCategoryService;
import com.wzh.wx_pay.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Deviler
 * @date 2019/6/24 -12:36
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public ResultResponse queryList() {
        ResultResponse<List<ProductCategoryDto>> categoryServiceResult = productCategoryService.findAll();
        List<ProductCategoryDto> categorydtoList = categoryServiceResult.getData();
        if(CollectionUtils.isEmpty(categorydtoList)){
            return categoryServiceResult;//如果分类列表为空 直接返回了
        }
        //获得类目编号集合
        List<Integer> categoryTypeList = categorydtoList.stream().map(categorydto -> categorydto.getCategoryType()).collect(Collectors.toList());
        //查询商品列表  这里商品上下架可以用枚举 方便扩展
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatusAndCategoryTypeIn(ResultEnums.PRODUCT_UP.getCode(), categoryTypeList);
        //多线程遍历 取出每个商品类目编号对应的 商品列表 设置进入类目中
        List<ProductCategoryDto> finalResultList = categorydtoList.parallelStream().map(categorydto -> {
            categorydto.setProductInfoDtoList(productInfoList.stream().
                    filter(productInfo -> productInfo.getCategoryType() == categorydto.getCategoryType()).map(productInfo ->
                    ProductInfoDto.build(productInfo)).collect(Collectors.toList()));
            return categorydto;
        }).collect(Collectors.toList());
        return ResultResponse.success(finalResultList);
    }
}


package com.wzh.wx_pay.service.impl;

import com.wzh.wx_pay.common.ResultResponse;
import com.wzh.wx_pay.dto.ProductCategoryDto;
import com.wzh.wx_pay.entity.ProductCategory;
import com.wzh.wx_pay.repository.ProductCategoryRepository;
import com.wzh.wx_pay.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Deviler
 * @date 2019/6/24 -10:01
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ResultResponse<List<ProductCategoryDto>> findAll() {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll();
        //利用流转换为dto集合
        return ResultResponse.success(productCategoryList.stream().map(productCategory ->
                ProductCategoryDto.build(productCategory)
        ).collect(Collectors.toList()));

    }
    }

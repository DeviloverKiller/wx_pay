package com.wzh.wx_pay.controller;

import com.wzh.wx_pay.common.ResultResponse;
import com.wzh.wx_pay.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deviler
 * @date 2019/6/24 -9:51
 */
@RestController
@RequestMapping("buyer/product")
@Api(description = "商品信息接口")//使用swagger2的注解对类描述
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("list")
    @ApiOperation(value = "查询商品列表")//使用swagger2的注解对方法接口描述
    public ResultResponse list(){
        return productInfoService.queryList();
    }
}


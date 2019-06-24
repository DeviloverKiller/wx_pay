package com.wzh.wx_pay.service;

import com.wzh.wx_pay.common.ResultResponse;
import com.wzh.wx_pay.dto.ProductCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Deviler
 * @date 2019/6/24 -9:57
 */
public interface ProductCategoryService {

    ResultResponse<List<ProductCategoryDto>> findAll();
}

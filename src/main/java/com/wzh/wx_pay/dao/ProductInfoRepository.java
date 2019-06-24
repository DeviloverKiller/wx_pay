package com.wzh.wx_pay.dao;

import com.wzh.wx_pay.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Deviler
 * @date 2019/6/24 -10:41
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    //根据类目编号 查询正常上架的商品
    List<ProductInfo> findByProductStatusAndCategoryTypeIn(Integer status, List<Integer> categoryList);
}


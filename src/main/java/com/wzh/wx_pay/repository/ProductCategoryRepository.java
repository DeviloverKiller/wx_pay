package com.wzh.wx_pay.repository;

import com.wzh.wx_pay.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Deviler
 * @date 2019/6/20 -17:38
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    //根据类型列表查询 集合
    List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList);
}

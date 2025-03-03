package com.wzh.wx_pay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wzh.wx_pay.entity.ProductCategory;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author Deviler
 * @date 2019/6/24 -9:58
 */
@Data
public class ProductCategoryDto {

    /** 类目名字. */
    @JsonProperty("name")
    private String categoryName;

    /** 类目编号. */
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
//防止为null时被忽略
    public List<ProductInfoDto> productInfoDtoList;

    //转换成Dto
    public static ProductCategoryDto build(ProductCategory productCategory){
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        BeanUtils.copyProperties(productCategory,productCategoryDto);
        return productCategoryDto;
    }

}

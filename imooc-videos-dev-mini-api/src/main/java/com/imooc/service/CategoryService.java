package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    /**
     *
     * @param categoryId
     * @return ProductCategory 实体
     */
    ProductCategory findOne(Integer categoryId);

    /**
     *
     * @return 实体类的List
     */
    List<ProductCategory> findAll();

    /**
     *
     * @param categoryTypeList
     * @return 实体类的List
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     *
     * @param productCategory
     * @return 实体类对象
     */
    ProductCategory save(ProductCategory productCategory);
}

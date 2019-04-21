package com.imooc.service.impl;

import com.imooc.mapper.ProductCategoryMapper;
import com.imooc.pojo.ProductCategory;

import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryMapper repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
    	ProductCategory result = repository.selectByPrimaryKey(categoryId);
        
        
        return result;
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.selectAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}

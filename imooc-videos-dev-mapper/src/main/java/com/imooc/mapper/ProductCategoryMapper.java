package com.imooc.mapper;

import com.imooc.pojo.ProductCategory;
import com.imooc.pojo.ProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryMapper {
    int countByExample(ProductCategoryExample example);

    int deleteByExample(ProductCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExample(ProductCategoryExample example);
    List<ProductCategory> selectAll();
    ProductCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByExample(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}
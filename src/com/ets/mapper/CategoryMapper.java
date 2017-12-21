package com.ets.mapper;

import java.util.List;

import com.ets.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    List<Category> selectCategoryChildrenByParentId(Integer parentId);
    
    List<Category> selectCategory();
    
    int batchDeleteById(List<Category> list);
}
package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    List<Category> selectAll();

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}

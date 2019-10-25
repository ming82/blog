package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Category;
import com.sf.blogserver.bean.CategoryExample;
import java.util.List;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
package com.sf.blogserver.service;

import com.sf.blogserver.bean.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    int insertCategory(Category category);

    int deleteCategoryByPrimaryKey(Integer categoryId);

    int update(Category category);
}

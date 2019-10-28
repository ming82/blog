package com.sf.blogserver.service;

import com.sf.blogserver.bean.Category;

import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.service
 * @create 2019/10/28 8:45
 * @Version: 1.0
 */
public interface CategoryService {

    List<Category> getAllCategory();

    int insertCategory(Category category);

    int deleteCategoryByPrimaryKey(Integer categoryId);

}

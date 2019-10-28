package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Category;
import com.sf.blogserver.mapper.CategoryMapper;
import com.sf.blogserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.service.impl
 * @create 2019/10/28 8:50
 * @Version: 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectAll();
    }

    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategoryByPrimaryKey(Integer categoryId) {
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }
}

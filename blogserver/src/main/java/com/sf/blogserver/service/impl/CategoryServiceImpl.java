package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Category;
import com.sf.blogserver.mapper.ArticleMapper;
import com.sf.blogserver.mapper.CategoryMapper;
import com.sf.blogserver.mapper.IssueMapper;
import com.sf.blogserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    IssueMapper issueMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectAll();
    }

    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insertSelective(category);
    }

    @Override
    public int deleteCategoryByPrimaryKey(Integer categoryId) {
        if(articleMapper.selectByCategoryId(categoryId).size() > 0 || issueMapper.selectByCategoryId(categoryId).size() > 0){
            return -1;
        }
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }
}

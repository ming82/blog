package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Category;
import com.sf.blogserver.service.CategoryService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/28 8:54
 * @Version: 1.0
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping("/insertCategory")
    public ResponceUtil insertCategory(Category category){
        Integer result = categoryService.insertCategory(category);
        if (result == 1) {
            return ResponceUtil.success("分类添加成功",null);
        } else {
            return ResponceUtil.fail("分类添加失败");
        }
    }

    @PostMapping("/deleteCategoryByPrimaryKey")
    public ResponceUtil deleteCategoryByPrimaryKey(Integer categoryId){
        Integer result = categoryService.deleteCategoryByPrimaryKey(categoryId);
        if (result == 1) {
            return ResponceUtil.success("分类删除成功",null);
        } else {
            return ResponceUtil.fail("分类删除失败");
        }
    }

}

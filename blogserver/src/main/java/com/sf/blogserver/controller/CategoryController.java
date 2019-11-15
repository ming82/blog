package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Category;
import com.sf.blogserver.service.CategoryService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Discription
 * @author Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/28 8:54
 * @Version: 1.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseUtil getAllCategory(){
        return ResponseUtil.success("查询成功",categoryService.getAllCategory());
    }

    @PostMapping("/")
    public ResponseUtil insertCategory(Category category){
        Integer result = categoryService.insertCategory(category);
        if (result == 1) {
            return ResponseUtil.success("分类添加成功",null);
        } else {
            return ResponseUtil.fail("分类添加失败");
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseUtil deleteCategoryByPrimaryKey(@PathVariable Integer categoryId){
        Integer result = categoryService.deleteCategoryByPrimaryKey(categoryId);
        if (result == 1) {
            return ResponseUtil.success("分类删除成功",null);
        } else {
            return ResponseUtil.fail("分类删除失败");
        }
    }

}

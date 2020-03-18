package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Category;
import com.sf.blogserver.service.CategoryService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseUtil getAllCategory() {
        return ResponseUtil.success("查询成功", categoryService.getAllCategory());
    }

    @PostMapping("/")
    public ResponseUtil insertCategory(@RequestBody Category category) {
        Integer result = categoryService.insertCategory(category);
        if (result == 1) {
            return ResponseUtil.success("栏目添加成功", null);
        } else {
            return ResponseUtil.fail("栏目添加失败");
        }
    }

    @PutMapping("/")
    public ResponseUtil updateCategory(@RequestBody Category category) {
        int result = categoryService.update(category);
        if (result == 1) {
            return ResponseUtil.success("栏目编辑成功");
        } else {
            return ResponseUtil.fail("栏目编辑失败");
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseUtil deleteCategoryByPrimaryKey(@PathVariable Integer categoryId) {
        Integer result = categoryService.deleteCategoryByPrimaryKey(categoryId);
        if (result == 1) {
            return ResponseUtil.success("栏目删除成功", null);
        } else if (result == -1) {
            return ResponseUtil.fail("栏目有所属文章或提问，无法删除");
        } else {
            return ResponseUtil.fail("栏目删除失败");
        }
    }

}

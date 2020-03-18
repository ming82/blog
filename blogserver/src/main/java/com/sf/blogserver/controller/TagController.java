package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.service.TagService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/getAll")
    public ResponseUtil getAllTag() {
        return ResponseUtil.success("查询成功", tagService.getAllTag());
    }

    @DeleteMapping("/{tagId}")
    public ResponseUtil delete(@PathVariable Integer tagId) {
        int result = tagService.deleteTag(tagId);
        if (result == 1) {
            return ResponseUtil.success("文章删除成功");
        } else if (result == -1) {
            return ResponseUtil.fail("已有文章关联此标签，无法删除");
        } else {
            return ResponseUtil.fail("文章删除失败");
        }
    }

    @PutMapping("/")
    public ResponseUtil editTag(@RequestBody Tag tag) {
        if (tagService.update(tag) == 1) {
            return ResponseUtil.success("编辑成功");
        } else {
            return ResponseUtil.fail("编辑失败");
        }
    }

    @PostMapping("/")
    public ResponseUtil addTag(@RequestBody Tag tag) {
        if (tagService.insertTag(tag) == 1) {
            return ResponseUtil.success("添加成功");
        } else {
            return ResponseUtil.fail("添加失败");
        }
    }
}

package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.service.TagService;
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
 * @create 2019/10/27 19:28
 * @Version: 1.0
 */
@RestController
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/getAllTag")
    public List<Tag> getAllTag(){
        return tagService.getAllTag();
    }

    @GetMapping("/getTagByArticleId")
    public List<Tag> getTag(Integer articleId){
        return tagService.getTagByArticleId(articleId);
    }

    @PostMapping("/deleteTag")
    public ResponceUtil deleteTag(Integer tagId){
        Integer result=tagService.deleteTag(tagId);
        if (result == 1) {
            return ResponceUtil.success("标签删除成功",null);
        } else {
            return ResponceUtil.fail("标签删除失败");
        }
    }

    @PostMapping("/insertTag")
    public ResponceUtil insertTag(Tag tag){
        Integer result=tagService.insertTag(tag);
        if (result == 1) {
            return ResponceUtil.success("标签添加成功",null);
        } else {
            return ResponceUtil.fail("标签添加失败");
        }
    }
}

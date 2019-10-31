package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.service.TagService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Discription
 * @author Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/27 19:28
 * @Version: 1.0
 */
@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/getAll")
    public ResponceUtil getAllTag(){
        return ResponceUtil.success("查询成功",tagService.getAllTag());
    }
}

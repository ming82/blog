package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.service.CommentService;
import com.sf.blogserver.vo.ArticleVo;
import com.sf.blogserver.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    @GetMapping("/test")
    public List<CommentVo> test(){
        return commentService.getCommentByArticleId(1);

    }
}

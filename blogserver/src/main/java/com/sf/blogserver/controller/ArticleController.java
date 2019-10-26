package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/test")
    public List<ArticleVo> test(){
        return articleService.selectAllArticle();

    }
}

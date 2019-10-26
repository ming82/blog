package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ArticleController {

    @GetMapping("/test")
    public Article test(){
        Article article = new Article();
        article.setArticleLikes(4);
        article.setPublishdate(new Date());
        article.setArticleSummary("sdfhdklsjlfsjl");

        return article;
    }
}

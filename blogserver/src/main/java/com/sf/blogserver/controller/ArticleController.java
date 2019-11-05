package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 92802
 * @date 2019/10/31
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/getAll")
    public ResponceUtil getAllArticles(){
        return ResponceUtil.success("查询成功",articleService.getAllArticle());
    }

    @GetMapping("/getHots")
    public ResponceUtil getHotArticles(){
        return ResponceUtil.success("查询成功",articleService.getHotArticles());
    }

    @GetMapping("/getNews")
    public ResponceUtil getNewArticles(){
        return ResponceUtil.success("查询成功",articleService.getNewArticles());
    }

    @GetMapping("/getByCategoryId")
    public ResponceUtil getArticlesByCategoryId(Integer categoryId){
        return ResponceUtil.success("查询成功",articleService.getArticlesByCategoryId(categoryId));
    }

    @PostMapping("/like")
    public ResponceUtil likeArticle(Integer articleId){
        return ResponceUtil.success("已点赞",articleService.likeArticle(articleId));
    }

    @GetMapping("/getByUserId")
    public ResponceUtil getArticlesByUserId(Integer userId){
        return ResponceUtil.success("查询成功",articleService.getArticlesByUserId(userId));
    }

    @GetMapping("/{articleId}")
    public ResponceUtil getArticleById(@PathVariable Integer articleId){
        return ResponceUtil.success("查询成功", articleService.getArticleById(articleId));
    }

    @PostMapping("/")
    public ResponceUtil addNewArticle(Article article, List<Tag> oldTags,List<String> newTags){
        int result = articleService.addNewArticle(article,oldTags,newTags);
        if (result == 1) {
            return ResponceUtil.success("文章发表成功");
        } else {
            return ResponceUtil.fail("文章发表失败");
        }
    }

    @PutMapping("/")
    public ResponceUtil editArticle(Article article){
        int result = articleService.updateArticle(article);
        if (result == 1) {
            return ResponceUtil.success("文章更新成功");
        } else {
            return ResponceUtil.fail("文章更新失败");
        }
    }

    @DeleteMapping("/{articleId}")
    public ResponceUtil deleteArticle(@PathVariable Integer articleId){
        int result = articleService.deleteArticle(articleId);
        if (result == 1) {
            return ResponceUtil.success("文章删除成功");
        } else {
            return ResponceUtil.fail("文章删除失败");
        }
    }
}

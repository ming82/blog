package com.sf.blogserver.controller;

import com.sf.blogserver.query.ArticleQuery;
import com.sf.blogserver.service.ArticleService;
import com.sf.blogserver.util.ResponseUtil;
import com.sf.blogserver.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章控制层
 * @author SM
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 分页查询文章列表
     * @param query 查询实体
     * @return
     */
    @GetMapping("/common/getList")
    public ResponseUtil getArticlesList(ArticleQuery query){
        return ResponseUtil.success("查询完成",articleService.getArticles(query));
    }

    /**
     * 获取热门文章
     * @return
     */
    @GetMapping("/common/getHots")
    public ResponseUtil getHotArticles(){
        return ResponseUtil.success("查询完成",articleService.getHotArticles());
    }

    /**
     * 获取最新文章
     * @return
     */
    @GetMapping("/common/getNews")
    public ResponseUtil getNewArticles(){
        return ResponseUtil.success("查询完成",articleService.getNewArticles());
    }

    /**
     * 点赞
     * @param articleId 文章ID
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/like")
    public ResponseUtil likeArticle(Integer articleId, Integer userId){
        return ResponseUtil.success("已点赞",articleService.likeArticle(articleId,userId));
    }

    /**
     * 获取用户草稿
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/getDrafts")
    public ResponseUtil getDrafts(Integer userId){
        return ResponseUtil.success("查询完成",articleService.getDraft(userId));
    }

    /**
     * 根据ID获取文章
     * @param articleId 文章ID
     * @return
     */
    @GetMapping("/common/{articleId}")
    public ResponseUtil getArticleById(@PathVariable Integer articleId){
        return ResponseUtil.success("查询完成", articleService.getArticleById(articleId));
    }

    /**
     * 发表文章
     * @param article 文章实体
     * @return
     */
    @PostMapping("/")
    public ResponseUtil addNewArticle(@RequestBody ArticleVo article){
        int result = articleService.addNewArticle(article);
        if (result == 1) {
            return ResponseUtil.success("文章发表成功");
        } else {
            return ResponseUtil.fail("文章发表失败");
        }
    }

    /**
     * 修改文章
     * @param article 文章实体
     * @return
     */
    @PutMapping("/")
    public ResponseUtil editArticle(@RequestBody ArticleVo article){
        int result = articleService.updateArticle(article);
        if (result == 1) {
            return ResponseUtil.success("文章更新成功");
        } else {
            return ResponseUtil.fail("文章更新失败");
        }
    }

    /**
     * 删除文章
     * @param articleId 文章ID
     * @return
     */
    @DeleteMapping("/{articleId}")
    public ResponseUtil deleteArticle(@PathVariable Integer articleId){
        int result = articleService.deleteArticle(articleId);
        if (result == 1) {
            return ResponseUtil.success("文章删除成功");
        } else {
            return ResponseUtil.fail("文章删除失败");
        }
    }
}

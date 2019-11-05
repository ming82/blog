package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Comment;
import com.sf.blogserver.service.CommentService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Discription
 * @author Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/27 17:02
 * @Version: 1.0
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/getByArticleId")
    public ResponceUtil getCommentByArticleId(Integer articleId){
        return ResponceUtil.success("查询成功",commentService.getCommentByArticleId(articleId));
    }

    @GetMapping("/getByAnswerId")
    public ResponceUtil getCommentByAnswerId(Integer answerId){
        return ResponceUtil.success("查询成功",commentService.getCommentByAnswerId(answerId));
    }

    @DeleteMapping("/{commentId}")
    public ResponceUtil deleteComment(@PathVariable Integer commentId){
        int result = commentService.deleteComment(commentId);
        if (result == 1) {
            return ResponceUtil.success("评论删除成功");
        } else {
            return ResponceUtil.fail("评论删除失败");
        }
    }

    @PostMapping("/")
    public ResponceUtil addNewComment(Comment comment){
        int result = commentService.addNewComment(comment);
        if (result == 1) {
            return ResponceUtil.success("评论成功",null);
        } else {
            return ResponceUtil.fail("评论失败");
        }
    }
}

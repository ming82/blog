package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Comment;
import com.sf.blogserver.service.CommentService;
import com.sf.blogserver.util.ResponceUtil;
import com.sf.blogserver.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/27 17:02
 * @Version: 1.0
 */
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/getComment")
    public List<CommentVo> getComment(Integer articleId){
        return commentService.getCommentByArticleId(articleId);
    }

    @PostMapping("/deleteComment")
    public ResponceUtil deleteComment(Comment comment){
        int result = commentService.deleteComment(comment);
        if (result == 1) {
            return ResponceUtil.success("评论删除成功",null);
        } else {
            return ResponceUtil.fail("评论删除失败");
        }
    }

    @PostMapping("/addNewComment")
    public ResponceUtil addNewComment(Comment comment){
        int result = commentService.addNewComment(comment);
        if (result == 1) {
            return ResponceUtil.success("发表评论成功",null);
        } else {
            return ResponceUtil.fail("发表评论失败");
        }
    }
}

package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * @author 92802
 * @date 2019/10/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVo {
    private Integer articleId;

    private String articleTitle;

    private String mdcontent;

    private String htmlcontent;

    private String articleSummary;

    private Integer userId;

    private Date publishdate;

    private Date edittime;

    private Integer articlePageviews;

    private Integer articleLikes;

    private Integer articleComments;

    private String userNickname;

    private List<String> tags;
}

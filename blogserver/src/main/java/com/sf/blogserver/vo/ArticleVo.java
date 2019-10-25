package com.sf.blogserver.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArticleVo {
    private Integer articleId;

    private String articleTitle;

    private String articleSummary;

    private Date publishdate;

    private Integer articlePageviews;

    private Integer articleLikes;

    private Integer articleComments;

    private Integer userId;

    private String userName;

    private List<String> tags;
}

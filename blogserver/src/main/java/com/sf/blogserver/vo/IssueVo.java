package com.sf.blogserver.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class IssueVo {
    private Integer issueId;

    private String issueTitle;

    private String userName;

    private Date publishdate;

    private Integer issuePageview;

    private Integer issueAnswers;
}

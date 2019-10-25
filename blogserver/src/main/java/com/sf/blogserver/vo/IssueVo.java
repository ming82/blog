package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueVo {
    private Integer issueId;

    private String issueTitle;

    private Integer userId;

    private String userNickname;

    private Date publishdate;

    private Integer issueAnswers;
}

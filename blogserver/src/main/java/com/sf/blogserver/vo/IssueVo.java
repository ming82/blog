package com.sf.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 92802
 * @date 2019/10/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueVo {
    private Integer issueId;

    private String issueTitle;

    private String mdcontent;

    private String htmlcontent;

    private Integer userId;

    private Date publishdate;

    private Integer issueStatus;

    private Integer issueAnswers;

    private String userNickname;
}

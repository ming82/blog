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

    private Integer userId;

    private String userNickname;

    private Date publishdate;

    private Integer issueAnswers;
}

package com.sf.blogserver.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleQuery {
    Integer pageNum;

    Integer pageSize;

    Integer categoryId;

    Integer userId;

    String keyword;

    String userNickname;
}

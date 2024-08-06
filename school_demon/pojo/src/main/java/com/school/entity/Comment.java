package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    //标识id
    private long id;
    //评论内容
    private String comment;
    //用于关联的逻辑外键
    private long commentId;
    //评论者id标识也是关联的逻辑外键
    private int userIdMark;
    //评论者id
    private String userId;
    //创建时间
    private LocalDate createTime;
}

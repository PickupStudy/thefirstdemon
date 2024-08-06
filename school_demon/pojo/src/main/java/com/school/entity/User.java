package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    //用户id
    private String userId;
    //用户密码
    private String userPassword;
    //用户关注度
    private int loveNumber;
    //用户粉丝
    private int fansNumber;
    //用户所写文章
    private Paper userPaper;
    //用户状态
    private int status;
    //与评论的逻辑外键
    private int userCommentId;
}

package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paper implements Serializable {
    //文章标识
    private int paperId;
    //文章标题
    private String paperTitle;
    //文章内容
    private String paperContext;
    //文章评论数
    private int paperCommandNumber;
    //文章点赞数
    private int paperCommandLove;
    //文章状态
    private int paperStatus;

}

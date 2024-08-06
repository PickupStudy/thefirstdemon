package com.school.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaperVO implements Serializable {
    //文章标题
    private String paperTitle;
    //文章内容
    private String paperContext;
    //文章状态
    private int paperStatus;
}


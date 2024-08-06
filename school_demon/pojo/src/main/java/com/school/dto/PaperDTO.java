package com.school.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaperDTO implements Serializable {
    //文章标题
    private String paperTitle;
    //文章内容
    private String paperContext;
}

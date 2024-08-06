package com.school.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO implements Serializable {
    //评论的内容
    private String comment;
    //评论者id
    private String userId;
    //创建时间
    private LocalDate createTime;
}

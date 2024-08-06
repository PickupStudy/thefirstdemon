package com.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {
    //文章id
    private long id;
    //具体评论内容
    private String comment;
    //用户id标识
    private long userIdMark;
    //用户id
    private String userId;
}

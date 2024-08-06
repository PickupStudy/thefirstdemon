package com.school.service;

import com.school.dto.CommentDTO;

public interface CommentService {
    /**
     * 保存评论
     * @param commentDTO
     */
    void saveComment(CommentDTO commentDTO);
}

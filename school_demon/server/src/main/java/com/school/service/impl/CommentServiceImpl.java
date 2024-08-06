package com.school.service.impl;

import com.school.dto.CommentDTO;
import com.school.entity.Comment;
import com.school.mapper.CommentMapper;
import com.school.mapper.UserMapper;
import com.school.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Autowired
    private UserMapper userMapper;
    /**
     * 保存评论
     * @param commentDTO
     */
    @Override
    public void saveComment(CommentDTO commentDTO) {
        Comment comment=new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        comment.setCreateTime(LocalDate.ofEpochDay(System.currentTimeMillis()));
        comment.setUserIdMark(userMapper.seeInformation(commentDTO.getUserId()).getUserCommentId());
        commentMapper.saveComment(comment);

    }
}

package com.school.mapper;

import com.school.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentMapper {
    /**
     * 保存评论
     * @param comment
     */
    @Insert("insert into school_demon.comment (comment, commentId, userIdMark, userId, createTime) VALUES (#{comment},#{commentId},#{userIdMark},#{userId},#{createTime})")
    void saveComment(Comment comment);
}

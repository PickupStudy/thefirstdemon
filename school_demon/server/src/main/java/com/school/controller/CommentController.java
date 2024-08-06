package com.school.controller;

import com.school.dto.CommentDTO;
import com.school.result.Result;
import com.school.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "评论")
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 保存评论
     * @param commentDTO
     * @return
     */
    @PostMapping("/saveComment")
    @ApiOperation("保存评论")
    public Result saveComment(@RequestBody CommentDTO commentDTO){
        commentService.saveComment(commentDTO);
        return Result.success();
    }
}

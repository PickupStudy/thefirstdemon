package com.school.controller;

import com.school.dto.PaperDTO;
import com.school.service.PaperService;
import com.school.vo.PaperVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.result.Result;

@RestController
@RequestMapping("/paper")
@Api(tags="文章接口")
@Slf4j
public class PaperController {
    private final PaperService paperService;

    public PaperController(PaperService paperService, AdminController adminController) {
        this.paperService = paperService;

    }

    //保存文章
    @GetMapping("/save")
    @ApiOperation("保存文章")
    public Result save(PaperDTO paperDTO){
        log.info("保存文章{}",paperDTO);
        paperService.save(paperDTO);
        return Result.success();
    }

    //查看文章
    @GetMapping("/show")
    @ApiOperation("查看文章")
    public Result show(){
        log.info("查看文章{}");
        PaperVO paperVO=paperService.show();
        if(paperVO.getPaperStatus()==0)
        {
            return Result.success(paperVO);
        }
        else{
            return Result.error("审核未通过或失败");
        }
    }

    /**
     * 文章点赞
     */
    @GetMapping("/like")
    @ApiOperation("点赞文章")
    public Result like(PaperDTO paperDTO){
        log.info("点赞文章{}",paperDTO);
        paperService.like(paperDTO);
        return Result.success();
    }

    /**
     * 文章评论
     * @param paperDTO
     * @return
     */
    public Result comment(PaperDTO paperDTO,String userComment){
        log.info("文章评论{}",paperDTO);
        paperService.comment(paperDTO,userComment);
        return Result.success();
    }
}

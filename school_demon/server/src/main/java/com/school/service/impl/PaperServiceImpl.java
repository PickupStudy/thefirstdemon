package com.school.service.impl;

import com.school.dto.PaperDTO;
import com.school.entity.Paper;
import com.school.mapper.PaperMapper;
import com.school.service.PaperService;
import com.school.vo.PaperVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaperServiceImpl implements PaperService {
    private final PaperMapper paperMapper;

    public PaperServiceImpl(PaperMapper paperMapper) {
        this.paperMapper = paperMapper;
    }

    /**
     * 保存文章
     * @param paperDTO
     */
    @Override
    public void save(PaperDTO paperDTO) {
        Paper paper=new Paper();
        BeanUtils.copyProperties(paperDTO,paper);
        paper.setPaperCommandLove(0);
        paper.setPaperCommandNumber(0);
        paperMapper.save(paper);
    }

    /**
     * 展现文章
     * @return
     */
    @Override
    public PaperVO show() {
        PaperVO paperVO=paperMapper.show();
        return paperVO;
    }

    /**
     * 点赞文章
     * @param paperDTO
     */
    @Override
    public void like(PaperDTO paperDTO) {
        paperMapper.like(paperDTO);
    }

    /**
     * 文章评论
     * @param paperDTO
     */
    @Override
    public void comment(PaperDTO paperDTO,String userComment) {
        paperMapper.comment(paperDTO,userComment);
    }
}

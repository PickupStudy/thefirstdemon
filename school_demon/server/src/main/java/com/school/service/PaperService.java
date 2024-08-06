package com.school.service;

import com.school.dto.PaperDTO;
import com.school.vo.PaperVO;
import org.springframework.stereotype.Service;

@Service
public interface PaperService {
    /**
     * 保存文章
     * @param paperDTO
     */
    void save(PaperDTO paperDTO);

    /**
     * 展现文章
     * @return
     */
    PaperVO show();

    /**
     * 点赞文章
     * @param paperDTO
     */
    void like(PaperDTO paperDTO);

    /**
     * 文章评论
     * @param paperDTO
     */
    void comment(PaperDTO paperDTO,String userComment);
}

package com.school.mapper;

import com.school.dto.PaperDTO;
import com.school.entity.Paper;
import com.school.vo.PaperVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PaperMapper {

    /**
     * 保存文章
     * @param paper
     */
    @Insert("insert into school_demon.paper(paperTitle, paperContext, paperCommandNumber, paperCommandLove) values(#{paperTitle},#{paperContext},#{paperCommandNumber},#{paperCommandLove}) ")
    void save(Paper paper);

    /**
     * 展示文章
     * @return
     */
    @Select("select paperTitle,paperContext,papaerStatsu from school_demon.paper")
    PaperVO show();

    @Update("update school_demon.paper set paperCommandLove=paperCommandLove+1 where paperTitle=#{paperTitle}")
    void like(PaperDTO paperDTO);

    @Insert("insert into school_demon.comment (comment) values #{userComment} where commentId=id")
    void comment(PaperDTO paperDTO,String userComment);
}

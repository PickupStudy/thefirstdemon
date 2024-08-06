package com.school.mapper;

import com.school.dto.AdminDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {

    /**
     * 获取用户状态
     * @param id
     * @return
     */
    @Select("select userStatus from school_demon.user")
    int getStatus(Integer id);

    /**
     *  修改用户状态
     * @param id
     */
    @Update("update school_demon.user set userStatus =#{Status} where userId=#{id} ")
    void setStatus(Integer id,Integer Status);

    /**
     * 审核文章
     * @param paperId
     */
    @Update("update school_demon.paper set papaerStatsu=#{setPaperStatus} where paperTitle=#{paperId}")
    void setPaperStatus(String paperId,Integer setPaperStatus);

    /**
     * 删除文章
     * @param droppedPaperId
     */
    @Delete("delete from school_demon.paper where paperTitle=#{droppedPaperId}")
    void droPaper(String droppedPaperId);

    /**
     * 管理端注册
     * @param adminDTO
     */
    void register(AdminDTO adminDTO);

    /**
     * 管理端登录
     * @param adminDTO
     * @return
     */
    @Select("select * from school_demon.admin where adminId=#{adminId} and adminPassword=#{adminPassword} ")
    AdminDTO login(AdminDTO adminDTO);
}

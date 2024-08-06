package com.school.service;


import com.school.dto.AdminDTO;
import com.school.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    //查询用户状态
    UserVO getStatus(Integer id);


    //修改用户状态
    void setStatus(Integer id);

    /**
     * 审核文章状态
     * @param paperId
     */
    void setPaperStatus(String paperId,Integer setPaperStatus);

    /**
     * 删除文章
     * @param droppedPaperId
     */
    void dropPaper(String droppedPaperId);

    /**
     * 用管理端注册
     * @param adminDTO
     */
    void register(AdminDTO adminDTO);

    /**
     * 管理员登录
     * @param adminDTO
     * @return
     */
    AdminDTO login(AdminDTO adminDTO);
}

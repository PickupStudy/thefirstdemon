package com.school.service.impl;

import com.school.dto.AdminDTO;
import com.school.mapper.AdminMapper;
import com.school.service.AdminService;
import com.school.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class  AdminServiceImpl implements AdminService {
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 查询用户状态
     * @param id
     */

    @Override
    public UserVO getStatus(Integer id) {
        UserVO userVO=new UserVO();
        userVO.setStatus(adminMapper.getStatus(id));
        return userVO;
    }

    /**
     * 修改用户状态
     * @param id
     */
    @Override
    public void setStatus(Integer id) {
        if (adminMapper.getStatus(id) == 0) {
            adminMapper.setStatus(id,1);
        }else{
            adminMapper.setStatus(id,0);
        }


    }

    /**
     * 审核文章
     * @param paperId
     */
    @Override
    public void setPaperStatus(String paperId,Integer setPaperStatus) {
        adminMapper.setPaperStatus(paperId,setPaperStatus);
    }

    /**
     * 删除文章
     * @param droppedPaperId
     */
    @Override
    public void dropPaper(String droppedPaperId) {

        adminMapper.droPaper(droppedPaperId);
    }

    /**
     * 管理员注册
     * @param adminDTO
     */
    @Override
    public void register(AdminDTO adminDTO) {
        adminMapper.register(adminDTO);
    }

    /**
     * 管理员登录
     * @param adminDTO
     * @return
     */
    @Override
    public AdminDTO login(AdminDTO adminDTO) {
        return adminMapper.login(adminDTO);
    }

}

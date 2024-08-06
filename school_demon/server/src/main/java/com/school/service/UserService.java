package com.school.service;

import com.school.dto.UserDTO;
import com.school.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * 用户注册
     * @param userDTO
     */
    void register(UserDTO userDTO);

    /**
     * 查看用户信息
     * @param userId
     * @return
     */
    User seeInformation(String userId);

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    UserDTO login(UserDTO userDTO);
}

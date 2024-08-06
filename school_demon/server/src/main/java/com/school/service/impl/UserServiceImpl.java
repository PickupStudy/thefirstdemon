package com.school.service.impl;

import com.school.dto.UserDTO;
import com.school.entity.User;
import com.school.mapper.UserMapper;
import com.school.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 用户注册
     * @param userDTO
     */
    @Override
    public void register(UserDTO userDTO) {
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setStatus(0);
        user.setUserPaper(null);
        user.setFansNumber(0);
        user.setLoveNumber(0);
        userMapper.register(user);
    }

    /**
     * 查看用户信息
     * @param userId
     * @return
     */
    @Override
    public User seeInformation(String userId) {
        User user=userMapper.seeInformation(userId);
        return user;
    }

    @Override
    public UserDTO login(UserDTO userDTO) {

        return userMapper.login(userDTO);
    }
}

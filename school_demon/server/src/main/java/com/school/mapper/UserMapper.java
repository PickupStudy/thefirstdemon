package com.school.mapper;

import com.school.dto.UserDTO;
import com.school.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {


    /**
     * 注册账号
     *
     * @param user
     */
    void register(User user);

    /**
     * 查看用户信息
     * @param userId
     * @return
     */
    @Select("select * from school_demon.user where userId=#{userId}")
    User seeInformation(String userId);

    /**
     * 用户登录
     * @param
     */
    @Select("select * from school_demon.user where userId=#{userId} and userPassword=#{userPassword}")
    UserDTO login(UserDTO userDTO);
}

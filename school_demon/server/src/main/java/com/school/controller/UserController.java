package com.school.controller;

import com.school.dto.UserDTO;
import com.school.entity.User;
import com.school.result.Result;
import com.school.service.UserService;
import com.school.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.school.constant.MessageConstant.LOGIN_FAILED;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户端")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @GetMapping("/register")
    @ApiOperation("用户注册")
    public Result register(UserDTO userDTO){
        log.info("用户注册{}",userDTO);
        userService.register(userDTO);
        return Result.success();
    }

    /**
     * 观看用户信息
     */
    @GetMapping("/{userId}")
    @ApiOperation("用户查看他人信息")
    public Result seeInformation(@PathVariable  String userId){
        log.info("查看用户信息{}",userId);
        User user=userService.seeInformation(userId);
        return Result.success(user);
    }

    /**
     * 用户粉丝关注
     */
    @GetMapping("/{lookId}/{lookedId}")
    @ApiOperation("用户粉丝关注")
    public Result lookAndLooked(@PathVariable String lookID,@PathVariable String lookedId){
        log.info("用户关注与粉丝{}{}",lookedId,lookID);
        userService.lookAndLooked(lookID,lookedId);
        return Result.success();
    }

    /**
     * 用户登录
     */
    @PostMapping("login")
    public Result login(@RequestBody UserDTO userDTO){
        log.info("用户登录{}",userDTO);
        UserDTO u=userService.login(userDTO);

        if(u!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",u.getUserId());
            claims.put("password",u.getUserPassword());
            String jwt= JwtUtil.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error(LOGIN_FAILED);
    }
}

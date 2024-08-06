package com.school.controller;

import com.school.dto.AdminDTO;
import com.school.result.Result;
import com.school.service.AdminService;
import com.school.utils.JwtUtil;
import com.school.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.school.service.AdminService;

import java.util.HashMap;
import java.util.Map;

import static com.school.constant.MessageConstant.LOGIN_FAILED;

@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags = "管理端")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 管理注册
     */
    @GetMapping("/register")
    @ApiOperation("管理注册")
    public Result login(AdminDTO adminDTO){

        log.info("管理端注册{}",adminDTO);
        adminService.register(adminDTO);
        return Result.success();

    }
    /**
     * 获取用户状态
     * @param id
     * @return
     */
    @PostMapping("/status")
    @ApiOperation("获取用户状态")
    public Result getStatus(@PathVariable Integer id){
        log.info("获取用户状态{}",id);
       UserVO userVO= adminService.getStatus(id);
        return Result.success(userVO);
    }

    /**
     * 修改用户状态
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    @ApiOperation("修改用户状态")
    public Result setStatus(@PathVariable Integer userId){
        log.info("修改用户状态{}",userId);
        adminService.setStatus(userId);
        return  Result.success();
    }
    /**
     * 审核文章
     */
    @GetMapping("/{paperID}")
    @ApiOperation("审核文章")
    public  Result setPaperStatus(@PathVariable String paperId,Integer setPaperStatus){
        log.info("审核文章{}",paperId);
        adminService.setPaperStatus(paperId,setPaperStatus);
        return Result.success("成功修改");
    }

    /**
     * 删除文章
     */
    @GetMapping("/{droppedPaperId}")
    @ApiOperation("删除文章")
    public Result dropPaper(@PathVariable String droppedPaperId){
        log.info("删除文章{}",droppedPaperId);
        adminService.dropPaper(droppedPaperId);
        return Result.success();
    }

    /**
     * 管理员登录
     */
    @PostMapping("login")
    @ApiOperation("管理员登录")
    public Result adminlogin(@RequestBody AdminDTO adminDTO) {
        log.info("管理员登录{}", adminDTO);
        AdminDTO a = adminService.login(adminDTO);

        if (a != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", a.getAdminId());
            claims.put("password", a.getAdminPassword());
            String jwt = JwtUtil.generateJwt(claims);
            return Result.success(jwt);

        }
        return Result.error(LOGIN_FAILED);
    }
}

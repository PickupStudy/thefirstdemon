package com.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO implements Serializable {
    //管理端账号
    private String adminId;
    //管理者密码
    private String adminPassword;
}

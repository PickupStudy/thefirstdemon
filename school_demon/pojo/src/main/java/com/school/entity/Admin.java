package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin implements Serializable {
    //管理员id
    private String adminId;
    //管理员密码
    private String adminPassword;
}

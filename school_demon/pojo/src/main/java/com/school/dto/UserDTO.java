package com.school.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserDTO implements Serializable {
    private String  userId;
    private String  userPassword;
}
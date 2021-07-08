package com.team10.user.model;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String description;

    private String createTime;

    private String picUrl;


}
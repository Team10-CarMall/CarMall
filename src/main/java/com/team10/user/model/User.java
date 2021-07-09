package com.team10.user.model;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String userId;

    private String username;

    private String password;

    private String description;

    private String picUrl;

    private String createTime;

    private String editTime;

    private Short version;

    private String state;

}
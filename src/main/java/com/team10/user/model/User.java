package com.team10.user.model;

import lombok.Data;

@Data
public class User {
    private String userId;

    private String username;

    private String password;

    private String description;

    private String picUrl;

    private String createTime;

    private String editTime;

    private Short version;

    private String state;

    public User(String userId,String username,String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

}
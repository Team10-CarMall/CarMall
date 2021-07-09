package com.team10.user.model;

import lombok.Data;

@Data
public class Address {
    private Integer id;

    private String name;

    private String phone;

    private String addr;

    private Integer userId;

    private Boolean state;

    private String createTime;

    private String updateTime;

    private Short version;

}
package com.team10.user.model;

import lombok.Data;

@Data
public class Address {
    private Integer id;

    private String name;

    private String phone;

    private String addr;

    private String userId;

    private String state;

    private String createTime;


    public Address(String name, String phone, String addr,String userId) {
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.userId = userId;
    }

    public Address(int id,String name, String phone, String addr) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
    }
}
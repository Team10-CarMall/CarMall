package com.team10.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddrDto implements Serializable {
    private int id;
    private String name;
    private String phone;
    private String addr;
}

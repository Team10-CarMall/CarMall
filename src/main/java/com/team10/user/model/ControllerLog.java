package com.team10.user.model;

import lombok.Data;
import java.util.Date;

@Data
public class ControllerLog {
    private Integer id;

    private String controller;
    
    private String createTime;

    private String userId;
    
}
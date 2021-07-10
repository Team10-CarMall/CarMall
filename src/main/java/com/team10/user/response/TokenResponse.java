package com.team10.user.response;

import lombok.Data;

@Data
public class TokenResponse {
    private int code;
    private String msg;
    private String token;
}

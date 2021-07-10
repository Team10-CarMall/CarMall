package com.team10.user.response;

import com.team10.user.dto.AddrDto;
import lombok.Data;


@Data
public class SingleReceiveResponse {
    private int code;
    private String msg;
    private AddrDto receiveAddr;
}

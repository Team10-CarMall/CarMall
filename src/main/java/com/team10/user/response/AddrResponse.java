package com.team10.user.response;

import com.team10.user.dto.AddrDto;
import lombok.Data;

import java.util.List;

@Data
public class AddrResponse {
    private int code;
    private String msg;
    private List<AddrDto> list;
}

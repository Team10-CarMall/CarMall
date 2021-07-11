package com.team10.user.service;

import com.team10.user.dto.AddrDto;

import java.util.List;

public interface AddressService {
    List<AddrDto> getAddrs(String userId);

    boolean addAddr(String name, String phone, String addr, String userId);

    boolean updateAddr(String name, String phone, String addr, String userId);

    AddrDto getAddr(String userId);

}

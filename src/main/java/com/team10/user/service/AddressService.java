package com.team10.user.service;

import com.team10.user.dto.AddrDto;
import com.team10.user.model.Address;

import java.util.List;

public interface AddressService {
    List<AddrDto> getAddrs(String userId);

    boolean addAddr(Address address);

    boolean updateAddr(Address address);

    AddrDto getAddr(int id);
}

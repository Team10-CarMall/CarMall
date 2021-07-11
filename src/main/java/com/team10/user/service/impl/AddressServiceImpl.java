package com.team10.user.service.impl;

import com.team10.user.dto.AddrDto;
import com.team10.user.mapper.AddressMapper;
import com.team10.user.model.Address;
import com.team10.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddrDto> getAddrs(String userId) {
        return addressMapper.selectAddrsByUserId(userId);
    }

    @Override
    public boolean addAddr(Address address) {
        if (addressMapper.insertSelective(address) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAddr(Address address) {
        if (addressMapper.updateByPrimaryKeySelective(address) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public AddrDto getAddr(int id) {
        return addressMapper.selectAddrById(id);
    }
}

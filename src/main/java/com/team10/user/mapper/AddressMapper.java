package com.team10.user.mapper;

import com.team10.user.dto.AddrDto;
import com.team10.user.model.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<AddrDto> selectAddrsByUserId(String userId);

    AddrDto selectAddrById(int id);
}
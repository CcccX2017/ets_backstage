package com.ets.mapper;

import org.apache.ibatis.annotations.Param;

import com.ets.pojo.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    int checkUsername(String username);
    
    int checkEmail(String email);
    
    Admin selectLogin(@Param("username") String username,@Param("password") String password);
}
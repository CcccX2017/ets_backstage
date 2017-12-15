package com.ets.mapper;

import com.ets.pojo.Shipping;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer receiverId);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer receiverId);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);
}
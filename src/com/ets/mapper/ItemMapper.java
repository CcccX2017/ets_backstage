package com.ets.mapper;

import com.ets.pojo.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKeyWithBLOBs(Item record);

    int updateByPrimaryKey(Item record);
}
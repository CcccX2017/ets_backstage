package com.ets.mapper;

import com.ets.pojo.ItemDescribe;

public interface ItemDescribeMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(ItemDescribe record);

    int insertSelective(ItemDescribe record);

    ItemDescribe selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(ItemDescribe record);

    int updateByPrimaryKey(ItemDescribe record);
}
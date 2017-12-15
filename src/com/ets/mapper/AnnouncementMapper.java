package com.ets.mapper;


import java.util.List;

import com.ets.pojo.Announcement;

public interface AnnouncementMapper {
    int deleteByPrimaryKey(Integer anId);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(Integer anId);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);
    
    int checkTitle(String title);
    
    List<Announcement> selectList();
    
    Announcement selectContentById(Integer id);
}
package com.ets.service;

import java.util.List;

import com.ets.common.ServerResponse;
import com.ets.pojo.Admin;
import com.ets.pojo.Announcement;
import com.github.pagehelper.PageInfo;

public interface IAnnouncementService {
	ServerResponse<String> checkValid(String title);
	
	ServerResponse<String> addAnnouncement(Announcement announcement,Admin admin);
	
	List<Announcement> getList();
	
	Announcement getContentById(int id);
	
	ServerResponse<String> delAnnouncementById(int id);
}

package com.ets.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ets.common.ServerResponse;
import com.ets.mapper.AnnouncementMapper;
import com.ets.pojo.Admin;
import com.ets.pojo.Announcement;
import com.ets.service.IAnnouncementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("announcementService")
public class AnnouncementServiceImpl implements IAnnouncementService {
	@Autowired
	private AnnouncementMapper announcementMapper;
	
	public ServerResponse<String> addAnnouncement(Announcement announcement,Admin admin){
		ServerResponse validResponse = this.checkValid(announcement.getTitle());
		if(!validResponse.isSuccess()){
			return validResponse;
		}
		announcement.setAdId(admin.getAdId());
		announcement.setState(1);
		int resultCount = announcementMapper.insert(announcement);
		if(resultCount == 0){
			ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}
	
	public ServerResponse<String> checkValid(String title){
		if(StringUtils.isNotBlank(title)){
			int resultCount = announcementMapper.checkTitle(title);
			if(resultCount > 0){
				return ServerResponse.createByErrorMessage("false");
			}else{
				return ServerResponse.createBySuccessMessage("true");
			}
		}
		return ServerResponse.createBySuccessMessage("false");
	}

	public List<Announcement> getList(){
		List<Announcement> list = announcementMapper.selectList();
		if(list != null){
			return list;
		}
		return null;
	}
	
	public Announcement getContentById(int id){
		Announcement announcement = announcementMapper.selectByPrimaryKey(id);
		if(announcement != null){
			return announcement;
		}
		return null;
	}
	
	public ServerResponse<String> delAnnouncementById(int id){
		if(StringUtils.isNotBlank(String.valueOf(id))){
			int resultCount = announcementMapper.deleteByPrimaryKey(id);
			if(resultCount > 0){
				return ServerResponse.createBySuccessMessage("删除成功");
			}else{
				return ServerResponse.createByErrorMessage("删除失败");
			}
		}
		return ServerResponse.createByErrorMessage("参数错误");
	}
	
	public ServerResponse<String> checkRoleByUserName(){
		return null;
	}
}

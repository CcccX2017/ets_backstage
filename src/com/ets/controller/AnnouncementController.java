package com.ets.controller;

import java.io.IOException;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ets.common.Const;
import com.ets.common.ResponseCode;
import com.ets.common.ServerResponse;
import com.ets.pojo.Admin;
import com.ets.pojo.Announcement;
import com.ets.service.IAnnouncementService;
import com.ets.util.DataTablePageUtil;
import com.ets.util.ResultUtil;
import com.github.pagehelper.PageInfo;

import oracle.net.aso.s;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
	@Autowired
	private IAnnouncementService announcementService;
	
	@RequestMapping(value="/checkTitle",method={RequestMethod.POST})
	@ResponseBody
	public ServerResponse<String> checkTitle(String title){
		return announcementService.checkValid(title);
	}
	
	@RequestMapping(value="/addAnnouncement",method={RequestMethod.POST})
	@ResponseBody
	public ServerResponse<String> addAnnouncement(Announcement announcement,HttpSession session){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(Const.Role.NEED_LOGIN,"用户未登录，请登录");
		}
		return announcementService.addAnnouncement(announcement, admin);
	}
	
	@RequestMapping(value="/delAnnouncement",method={RequestMethod.GET})
	@ResponseBody
	public ServerResponse<String> delAnnouncement(HttpSession session,int id){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(Const.Role.NEED_LOGIN,"用户未登录，请登录");
		}
		
		return announcementService.delAnnouncementById(id);
	}
}

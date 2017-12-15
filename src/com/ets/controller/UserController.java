package com.ets.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ets.common.Const;
import com.ets.common.ServerResponse;
import com.ets.pojo.Admin;
import com.ets.service.IUserService;

@Controller
@RequestMapping("/manage")
public class UserController {
	@Autowired
	private IUserService userService;
	
	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login",method={RequestMethod.POST})
	@ResponseBody
	public ServerResponse<Admin> login(String ad_username,String ad_password,HttpSession session){
		ServerResponse<Admin> response = userService.login(ad_username, ad_password);
		if(response.isSuccess()){
			session.setAttribute(Const.ADMIN_USERNAME,response.getData());
		}
		return response;
	}
	
	@RequestMapping(value="/logout",method={RequestMethod.GET})
	@ResponseBody
	public ServerResponse<String> logout(HttpSession session){
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess();
	}
	
	public ServerResponse<String> addAdmin(Admin admin,HttpSession session){
		Admin admin1 = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin1.getAdRole() == 2){
			return ServerResponse.createByErrorMessage("当前没有添加管理权限");
		}
		return userService.addAdmin(admin);
	}
	
	@RequestMapping(value="/checkValid",method={RequestMethod.POST})
	@ResponseBody
	public ServerResponse<String> checkValid(String str,String type){
		return userService.checkValid(str, type);
	}
	
	@RequestMapping(value="/getAdminInfo",method={RequestMethod.POST})
	@ResponseBody
	public ServerResponse<Admin> getAdminInfo(HttpSession session){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin != null){
			return ServerResponse.createBySuccess(admin);
		}
		return ServerResponse.createByErrorMessage("管理员未登录,无法获取当前管理员的信息");
	}
}

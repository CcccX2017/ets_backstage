package com.ets.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ets.common.Const;
import com.ets.pojo.Admin;
import com.ets.pojo.Announcement;
import com.ets.pojo.User;
import com.ets.service.IAnnouncementService;
import com.ets.service.IUserService;


@Controller
public class PageController {
	@Autowired
	private IAnnouncementService announcementService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/admin")
	public String showIndex(HttpSession session) {
		Admin admin = (Admin) session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return "login";
		}
		return "index";
	}
	
	@RequestMapping("/articleList")
	public ModelAndView ArticleList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		List<Announcement> list = announcementService.getList();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("article-list");
		return modelAndView;
	}
	
	@RequestMapping(value="/ariticleDetail",method={RequestMethod.GET})
	public String AriticleDetail(HttpServletRequest request){
		if(request != null){
			int id = Integer.parseInt(request.getParameter("id"));
			String author = request.getParameter("author");
			Announcement announcement = announcementService.getContentById(id);
			Admin admin = new Admin();admin.setAdUsername(author);
			announcement.setAdmin(admin);
			request.setAttribute("announcement",announcement);
			return "article-content";
		}
		return null;
	}
	
	@RequestMapping("/userList")
	public String UserList(HttpServletRequest request){
		if(request != null){
			List<User> list = userService.getUserList();
			request.setAttribute("user", list);
			return "member-list";
		}
		return null;
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
}

package com.ets.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ets.common.Const;
import com.ets.common.ResponseCode;
import com.ets.common.ServerResponse;
import com.ets.pojo.Admin;
import com.ets.service.ICategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("/addCategory")
	@ResponseBody
	public ServerResponse addCategory(HttpSession session,String categoryName,@RequestParam(value="parentId",defaultValue="0") int parentId){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
		}
		return categoryService.addCategory(categoryName, parentId);
	}
	
	@RequestMapping("/setCategoryName")
	@ResponseBody
	public ServerResponse setCategoryName(HttpSession session,Integer categoryId,String categoryName){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
		}
		return categoryService.updateCategoryName(categoryId, categoryName);
	}
	
	@RequestMapping("/getChildrenParallelCategory")
	@ResponseBody
	public ServerResponse getChildrenParallelCategory(HttpSession session,@RequestParam(value="categoryId",defaultValue="0") Integer categoryId){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
		}
		//查询子节点的Category信息，并且无递归
		return categoryService.getChildrenParallelCategory(categoryId);
	}
	
	@RequestMapping("/getCategory")
	@ResponseBody
	public ServerResponse getCategory(HttpSession session,@RequestParam(value="categoryId",defaultValue="0") Integer categoryId){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
		}
		//查询Category信息，并且无递归
		return categoryService.getCategory();
	}
	
	@RequestMapping("/getDeepCategory")
	@ResponseBody
	public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session,@RequestParam(value="categoryId",defaultValue="0") Integer categoryId){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
		}
		//查询当前节点的id和递归子节点的id
		//0->10000->100000
		return categoryService.selectCategoryAndChildrenById(categoryId);
	}
	
	@RequestMapping("/delectCategoryById")
	@ResponseBody
	public ServerResponse delectCategoryById(HttpSession session,Integer categoryId){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
		}
		return categoryService.delectCategoryById(categoryId);
	}
}

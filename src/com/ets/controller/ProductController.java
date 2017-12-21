package com.ets.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ets.common.Const;
import com.ets.common.ResponseCode;
import com.ets.common.ServerResponse;
import com.ets.pojo.Admin;
import com.ets.pojo.Item;
import com.ets.service.IFileService;
import com.ets.service.IProductService;
import com.ets.util.PropertiesUtil;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IFileService fileService;
	
	@RequestMapping("/productSave")
	@ResponseBody
	public ServerResponse productSave(HttpSession session,Item item){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
		}
		return productService.saveOrUpdateProduct(item);
	}
	
	@RequestMapping("/setSaleStatus")
	@ResponseBody
	public ServerResponse setSaleStatus(HttpSession session,Long itemId,Integer status){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
		}
		return productService.setSaleStatus(itemId, status);
	}
	
	@RequestMapping("/getDetail")
	@ResponseBody
	public ServerResponse getDetail(HttpSession session,Long itemId){
		Admin admin = (Admin)session.getAttribute(Const.ADMIN_USERNAME);
		if(admin == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
		}
		return productService.manageProductDetail(itemId);
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public Map upload(@RequestParam(value="upload_file",required = false) MultipartFile file,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("upload");
		String targetFileName = fileService.upload(file, path);
		String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;
		Map<String,Object> fileMap = new HashMap<String,Object>();
		fileMap.put("error", 0);
		fileMap.put("url", url);
		return fileMap;
	}
}

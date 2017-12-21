package com.ets.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ets.common.Const;
import com.ets.common.ServerResponse;
import com.ets.mapper.AdminMapper;
import com.ets.mapper.UserMapper;
import com.ets.pojo.Admin;
import com.ets.pojo.User;
import com.ets.service.IUserService;
import com.ets.util.MD5Util;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public ServerResponse<Admin> login(String username, String password) {
		int resultCount = adminMapper.checkUsername(username);
		if(resultCount == 0){
			return ServerResponse.createByErrorMessage("不存在该用户名的管理员");
		}
		
		//TODO 密码登录MD5
		String md5Password = MD5Util.MD5EncodeUtf8(password);
		Admin admin = adminMapper.selectLogin(username, md5Password);
		if(admin == null){
			return ServerResponse.createByErrorMessage("密码错误");
		}
		admin.setAdPassword(StringUtils.EMPTY);
		return ServerResponse.createBySuccess("登录成功",admin);
	}
	
	public ServerResponse<String> addAdmin(Admin admin){
		ServerResponse validResponse = this.checkValid(admin.getAdUsername(),Const.ADMIN_USERNAME);
		if(!validResponse.isSuccess()){
			return validResponse;
		}
		validResponse = this.checkValid(admin.getAdEmail(),Const.ADMIN_EMAIL);
		if(!validResponse.isSuccess()){
			return validResponse;
		}
		admin.setAdRole(Const.Role.ROLE_CUSTOMER_ADMIN);
		//MD5加密
		admin.setAdPassword(MD5Util.MD5EncodeUtf8(admin.getAdPassword()));
		
		int resultCount = adminMapper.insert(admin);
		if(resultCount == 0){
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}
	
	public ServerResponse<String> checkValid(String str,String type){
		if(StringUtils.isNotBlank(type)){
			if(Const.ADMIN_USERNAME.equals(type)){
				int resultCount = adminMapper.checkUsername(str);
				if(resultCount > 0){
					return ServerResponse.createByErrorMessage("已存在该用户名的管理员");
				}
			}
			if(Const.ADMIN_EMAIL.equals(type)){
				int resultCount = adminMapper.checkEmail(str);
				if(resultCount > 0){
					return ServerResponse.createByErrorMessage("email已存在");
				}
			}
		}else {
			return ServerResponse.createByErrorMessage("参数错误");
		}
		return ServerResponse.createBySuccessMessage("校验成功");
	}
	
	public List<User> getUserList(){
		List<User> list = userMapper.getUserList();
		if(list != null){
			return list;
		}
		return null;
	}
}

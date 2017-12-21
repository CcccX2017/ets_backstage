package com.ets.service;


import java.util.List;

import com.ets.common.ServerResponse;
import com.ets.pojo.Admin;
import com.ets.pojo.User;

public interface IUserService {
	ServerResponse<Admin> login(String username,String password);
	
	ServerResponse<String> addAdmin(Admin admin);
	
	ServerResponse<String> checkValid(String str,String type);
	
	List<User> getUserList();
}

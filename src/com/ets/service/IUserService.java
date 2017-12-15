package com.ets.service;


import com.ets.common.ServerResponse;
import com.ets.pojo.Admin;

public interface IUserService {
	ServerResponse<Admin> login(String username,String password);
	
	ServerResponse<String> addAdmin(Admin admin);
	
	ServerResponse<String> checkValid(String str,String type);
}

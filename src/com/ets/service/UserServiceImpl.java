package com.ets.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ets.mapper.UserMapper;
import com.ets.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByName(String name) {
		User user = userMapper.getUserByName("уехЩ");
		System.out.println("UserService======="+user.getName() + "\t" + user.getPassword());
		return user;
	}
}

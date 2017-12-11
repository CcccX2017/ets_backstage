package com.ets.service;

import org.springframework.stereotype.Service;

import com.ets.pojo.User;

public interface UserService {
	public User getUserByName(String name);
}

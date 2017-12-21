package com.ets.common;

public class Const {
	public static final String CURRENT_USER = "current_user";
	public static final String USERNAME = "username";
	public static final String EMAIL = "email";
	public static final String ADMIN_USERNAME = "ad_username";
	public static final String ADMIN_EMAIL = "ad_email";
	public static final String FTP_PATH = "10.88.86.57";
	
	public interface Role{
		int ROLE_CUSTOMER = 0; //普通用户
		int ROLE_SELLER = 1; //卖家
		int ROLE_CUSTOMER_ADMIN = 2; //普通管理员
		int ROLE_SUPER_ADMIN = 3; //超级管理员
		int NEED_LOGIN = 10; //需要登录
		int PAGE_NUM = 1;
		int PAGE_SIZE = 10;
	}
}

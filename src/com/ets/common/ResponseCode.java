package com.ets.common;

/**
 * @ClassName:ResponseCode
 * @Description:TODO
 * @author:cx
 * @date:2017年12月14日 上午11:36:22
 */
public enum ResponseCode {
	SUCCESS(0,"SUCCESS"),
	ERROR(1,"ERROR"),
	NEED_LOGIN(10,"NEED_LOGIN"),
	ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");//参数错误
	
	private final int code;
	private final String desc;
	
	ResponseCode(int code,String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode(){
		return code;
	}
	public String getDesc(){
		return desc;
	}
}
 
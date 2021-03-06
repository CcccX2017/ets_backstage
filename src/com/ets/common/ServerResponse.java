package com.ets.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @ClassName:ServerResponse
 * @Description:TODO
 * @author:cx
 * @date:2017年12月14日 上午11:22:09
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable{
	private int status;
	private String msg;
	private T data;
	
	private ServerResponse(int status){
		this.status = status;
	}
	private ServerResponse(int status,T data){
		this.status = status;
		this.data = data;
	}
	private ServerResponse(int status,String msg){
		this.status = status;
		this.msg = msg;
	}
	private ServerResponse(int status,String msg,T data){
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	
	@JsonIgnore
	public boolean isSuccess(){
		return this.status == ResponseCode.SUCCESS.getCode();
	}
	public int getStatus(){
		return status;
	}
	public T getData(){
		return data;
	}
	public String getMsg(){
		return msg;
	}
	
	public static <T> ServerResponse<T> createBySuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}
	public static <T> ServerResponse<T> createBySuccessMessage(String msg){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
	}
	public static <T> ServerResponse<T> createBySuccess(T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
	}
	public static <T> ServerResponse<T> createBySuccess(String msg,T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
	}
	
	public static <T> ServerResponse<T> createByError(){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
	}
	public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
	}
	
	public static <T> ServerResponse<T> createByErrorCodeMeaage(int errorCode,String errorMessage){
		return new ServerResponse<T>(errorCode,errorMessage);
	}
}

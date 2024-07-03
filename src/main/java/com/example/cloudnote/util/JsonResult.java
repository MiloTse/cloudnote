package com.example.cloudnote.util;

import java.io.Serializable;

public class JsonResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5055852645491022099L;

	public static final int SUCCESS=0;
	
	public static final int ERROR=1;
	
	/**
	 * 返回是否成功的状态
	 * 0表示成功
	 * 1或其他值表示失败
	 */
	public int state;
	/**
	 * 成功时，返回的JSON数据
	 */
	public Object data;
	/**
	 * 存储提示信息
	 */
	public String message;
	public JsonResult() {
		
	}
	public JsonResult(int state, Object data, String message) {
		
		this.state = state;
		this.data = data;
		this.message = message;
	}
	
	public JsonResult(Throwable e){
		state=ERROR;
		data="";
		message=e.getMessage();
	}
	public JsonResult(int state,Throwable e){
		this.state=state;
		data=null;
		message=e.getMessage();
				
		
		
	}
	public JsonResult(Object data){
		state=SUCCESS;
		this.data=data;
		message="";
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + "]";
	}
	
	
}

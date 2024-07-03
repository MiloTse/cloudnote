package com.example.cloudnote.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cloudnote.exception.NameException;
import com.example.cloudnote.exception.PasswordException;
import com.example.cloudnote.util.JsonResult;

public abstract class ExceptionController {
	@ExceptionHandler(Exception.class)  //指定就只负责该种异常
	@ResponseBody
	public Object Except(Exception e){
		e.printStackTrace();
		return new JsonResult(e);	
	}
	
	
	

	@ExceptionHandler(NameException.class)
	@ResponseBody
	public Object nameException(NameException e){
		e.printStackTrace();
		return new JsonResult(2,e);	
	}
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public Object pwdException(PasswordException e){
		e.printStackTrace();
		return new JsonResult(3,e);	
	}
	

}

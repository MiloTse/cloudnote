package com.example.cloudnote.service;

import com.example.cloudnote.entity.User;
import com.example.cloudnote.exception.NameException;
import com.example.cloudnote.exception.PasswordException;

public interface UserService {

	/**
	 * 登录功能
	 * name：登录用户
	 * password：登录密码
	 * User：成功登录后返回用户数据
	 * 用户名错
	 * 密码错误
	 */
	 User login(String name, String password) throws NameException, PasswordException;
	
	 User regist(String name,String password,String nick) throws NameException;
	
}

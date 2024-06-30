package com.example.cloudnote.service.impl;

import com.example.cloudnote.dao.UserDao;
import com.example.cloudnote.entity.User;
import com.example.cloudnote.exception.NameException;
import com.example.cloudnote.exception.PasswordException;
import com.example.cloudnote.service.UserService;
import com.example.cloudnote.util.NoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;
	public User login(String name, String password) throws NameException, PasswordException {
		 
		if(name==null || name.trim().isEmpty()){
			throw new NameException("用户名不能为空");
		}
		if(password==null|| password.trim().isEmpty()){
			throw new NameException("密码不能为空");
		}
		//利用用户名查找用户信息
		User user = userdao.findByName(name);
		if(user==null){
			throw new NameException("用户名错误");
		}
		//检验用户密码是否正确
		String md5Password = NoteUtil.md5(password);
		if(user.getPassword().equals(md5Password)){
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
		
		
		
	}
	public User regist(String name, String password, String nick) throws NameException {
		User user = userdao.findByName(name);
		if(user!=null){ //user不为空，则说明该用户名已经被占用
			throw new NameException("用户名被占用");
		}
		if(nick==null||nick.trim().isEmpty()){
			nick=name;  //如果nick不填，则跟name一样
		}
		String id = NoteUtil.createId(); //生成uuid
		
		//user为空，则该name不存在，则可以执行存入
		String token = "";
		//将密码进行加密
		password = NoteUtil.md5(password);
		user = new User(id, name,password,token,nick);

		userdao.save(user);	

		return user;
	}

}

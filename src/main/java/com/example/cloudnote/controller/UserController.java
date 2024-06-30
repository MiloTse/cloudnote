package com.example.cloudnote.controller;


import com.example.cloudnote.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cloudnote.service.UserService;
import com.example.cloudnote.util.JsonResult;


@Controller
@RequestMapping("/user")
public class UserController extends ExceptionController{
	@Autowired
	private UserService userService;  //@Resource通知spring把生成的实例放到userService这里来
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Object login(String name,String password){
		
//		try {
			User user = userService.login(name, password);
			
			return new JsonResult(user);  //JsonResult(Object data)是成功才使用的有参构造
			
//		}catch (NameException e) {
//			e.printStackTrace();
//			return new JsonResult(2,e);   //2用户名错误
//		}catch (PasswordException e) {
//			e.printStackTrace();
//			
//			return new JsonResult(3,e);  //3密码错误
//		}catch (Exception e) {
//			e.printStackTrace();
//			return new JsonResult(e);
//		}
	
	}
	
	

	
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult regist(String name,String nick,String password){
		
		System.out.println(name+", "+nick+", "+password);
		
		//验证name是否已经被占用
//		try {
			
			User user = userService.regist(name, password, nick);
			return new JsonResult(user);
			
//		}catch(NameException e){
//			e.printStackTrace();
//			return new JsonResult(2,e);
//		}
//		
//		catch (Exception e) {  //捕获的是未知的服务器异常
//			e.printStackTrace();
//			return new JsonResult(e);
//		}
 
	}
	
}

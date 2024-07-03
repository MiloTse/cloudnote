package com.example.cloudnote.test;

import com.example.cloudnote.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.cloudnote.service.UserService;

public class TestUserService {
	private UserService userservice;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext context= new ClassPathXmlApplicationContext(conf);
		userservice = context.getBean("userService",UserService.class);
		System.out.println(context);
	}
	//测试用户名错误
	@Test
	public void test1(){		
		User u = userservice.login("zhang", "123");
		System.out.println(u);
	}
	
	
	
	//测试密码错误
	@Test
	public void test2(){		
		User u = userservice.login("demo", "12345678");
		System.out.println(u);
	}
	
	//测试正确用户名和密码
	@Test
	public void test3(){		
		User u = userservice.login("zhouj", "123456");
		System.out.println(u);
	}
	
	
	//测试dao的save方法
	@Test
	public void testServiceRegist(){
		//name,password,nick
		User u = userservice.regist("Allen","123456","");
		
		
		System.out.println(u);
		
	}
	
}

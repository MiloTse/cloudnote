package com.example.cloudnote.test;



import com.example.cloudnote.entity.User;
import com.example.cloudnote.util.NoteUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.cloudnote.dao.UserDao;

public class TestUserDao {
	private UserDao dao;
;
	@Before
	public void init(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		dao=
		context.getBean("userDao",UserDao.class);
	}
	
	
	@Test
	public void testFindByName(){
		
		
		User user=dao.findByName("demo");
		
		System.out.println(user);
	}
	
	//测试dao的save方法
	@Test
	public void testDaoSave(){

		
		User user=new User();
		user.setId("001");
		user.setName("warren");
		user.setPassword(new NoteUtil().md5("123456"));
		user.setNick("wa");
		dao.save(user);
	}

	
}







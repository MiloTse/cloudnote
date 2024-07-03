package com.example.cloudnote.test;



import java.util.List;
import java.util.Map;

import com.example.cloudnote.entity.Note;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.cloudnote.dao.NoteDao;


public class TestNoteDao {
	
	private NoteDao dao;
	@Before
	public void init(){
		
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext context=
				new ClassPathXmlApplicationContext(conf);
		dao= context.getBean("noteDao",NoteDao.class);
		
	}
	
	@Test
	public void test(){
		String bookId="fa8d3d9d-2de5-4cfe-845f-951041bcc461";
		List<Map<String,Object>> list =dao.findByBookId(bookId);
		System.out.println(list);
		for(Map  m:list){
			System.out.println(m.get("id")+","+m.get("title"));
		}
		
	}
	
	//测试笔记add方法
	@Test
	public void testaddNote(){
		Note n = new Note();
		n.setBookId("888888");
		n.setCreateTime(System.currentTimeMillis());
		n.setId("11111111");
		n.setStatusId("1");
		n.setTitle("222New Note1");
		n.setTypeId("");
		n.setUserId("48595f52-b22c-4485-9244-f4004255b972");
		dao.save(n);
		System.out.println(n);
		
	}
}







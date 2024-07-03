package com.example.cloudnote.test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


import com.example.cloudnote.entity.Book;
import com.example.cloudnote.entity.Note;
import com.example.cloudnote.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.cloudnote.dao.BookDao;
import com.example.cloudnote.dao.NoteDao;
import com.example.cloudnote.dao.UserDao;


public class TestDao {
	private UserDao dao;
	private BookDao bookDao;
	@Autowired
	private NoteDao noteDao;
	@Before
	public void init(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		dao= context.getBean("userDao",UserDao.class);
		
		bookDao= context.getBean("bookDao",BookDao.class);
		
		noteDao= context.getBean("noteDao",NoteDao.class);
		
	}
	
	
	@Test
	public void testFindByName(){
		
		
		User user=dao.findByName("demo");
		
		System.out.println(user);
	}
	
	@Test
	public void testfindByUserId(){
		String userId = "03590914-a934-4da9-ba4d-b41799f917d1";
		
		User user=dao.findByUserId(userId);
		
		System.out.println(user);
		
	}
	
	
	//测试dao的save方法
//	@Test
//	public void testDaoSave(){
//
//		
//		User user=new User();
//		user.setId("001");
//		user.setName("warren");
//		user.setPassword(new NoteUtil().md5("123456"));
//		user.setNick("wa");
//		dao.save(user);
//	}

	@Test
	public void testBookDao(){
		
		String userId = "03590914-a934-4da9-ba4d-b41799f917d1";
		
		
		List<Book> list=bookDao.findByUserId(userId);
		
		for(Book b : list){
			System.out.println("笔记本ID是： "+b.getNotebookId()+",笔记本名: "+b.getNotebookName());
		}
		
	}
	
	@Test
	public void test(){
		String bookId="fa8d3d9d-2de5-4cfe-845f-951041bcc461";
		List<Map<String,Object>> list =noteDao.findByBookId(bookId);
		System.out.println("list直接输出："+list);
		for(Map  m:list){
			System.out.println(m.get("id")+","+m.get("title"));
		}	
	}
	
	@Test
	public void testShowNote(){
		String noteId="ss19055-30e8-4cdc-bfac-97c6bad9518f";
		Map<String,Object> m =noteDao.findByNoteId(noteId);
		System.out.println("这是dao直接输出的："+m);
		
			System.out.println(","+m.get("title")+m.get("body"));
			
	}
	
	@Test
	public void testSaveNote(){
		String noteId="ss19055-30e8-4cdc-bfac-97c6bad9518f";
		long lastModifyTime=System.currentTimeMillis();
		Note note = new Note();
		note.setId(noteId);
		note.setTitle("我的收藏2888");
		note.setBody("更88改了22222");
		note.setLastModifyTime(lastModifyTime);
		
		noteDao.update(note);
		System.out.println(note);
		
	}
	
	@Test
	public void testSaveNewBook(){
		Book  book = new Book();
		book.setNotebookId("888888");
		book.setUserId("48595f52-b22c-4485-9244-f4004255b972");
		
		book.setNotebookName("WTF");
//		| 1                   | favorites             | favorites             | 收藏                  |
//		| 2                   | recycle               | recycle               | 回收站                |
//		| 3                   | action                | action                | 活动                  |
//		| 4                   | push                  | push                  | 推送                  |
//		| 5                   | normal                | normal                | 正常
		book.setNotebookTypeId("5");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		book.setNotebookCreateTime(time);
		bookDao.save(book);

		System.out.println(book);
	}
	
	
}







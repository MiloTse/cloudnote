package com.example.cloudnote.test;

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

import com.example.cloudnote.service.BookService;
import com.example.cloudnote.service.NoteService;
import com.example.cloudnote.service.UserService;

public class TestService {
	@Autowired
	private UserService userservice;
	@Autowired
	private BookService bookservice;
	@Autowired
	private NoteService noteservice;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext context= new ClassPathXmlApplicationContext(conf);
		userservice = context.getBean("userService",UserService.class);
		
		bookservice = context.getBean("bookService",BookService.class);
		
		noteservice = context.getBean("noteService",NoteService.class);
		
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
	
	
	//测试service的save方法
	@Test
	public void testServiceRegist(){
		//name,password,nick
		User u = userservice.regist("Allen","123456","");
		
		
		System.out.println(u);
		
	}
	
	
	//测试service的listBooks方法
	@Test
	public void loadBooks(){
		String userId = "03590914-a934-4da9-ba4d-b41799f917d1";
		//String userId = "";
		List<Book> list = bookservice.loadBooks(userId);
		
		for(Book b : list){
			System.out.println("笔记本ID是： "+b.getNotebookId()+",笔记本名: "+b.getNotebookName());
		}
	}
	
	
	
	//测试noteservice的listnote方法
	@Test
	public void loadnote(){
		String bookId="d0b0727f-a233-4a1f-8600-f49fc1f25bc9";
		//String bookId = "";
		List<Map<String,Object>> list = noteservice.listNote(bookId);
		for(Map  m:list){
			System.out.println(m.get("id")+","+m.get("title"));
		}
	}
	
	//测试noteservice的listnote方法
	@Test
	public void serviceShowNote(){
		String noteId="f4cce0e5-ba14-4deb-bc04-e396f53c40f3";
		
		Map<String,Object> m =noteservice.showNote(noteId);
		System.out.println("这是service输出的："+m);
		
	
			System.out.println(m.get("body")+","+m.get("title"));

	}
	
	//测试service的saveNote方法
	@Test
	public void testSaveNote(){
		String noteId="ss19055-30e8-4cdc-bfac-97c6bad9518f";
		Note  note = new Note();
	
		String title = "我的收藏2更改了,来自service层的更改";
		String body="2222更改了,来自service层的更改";
		
		noteservice.saveNote(noteId,title,body);
		
	}
	
	
	//测试新建笔记本的service层
	@Test
	public void testAddBook(){
		String userId = "48595f52-b22c-4485-9244-f4004255b972";
		String bookName="cccccc";
		Book book = bookservice.addBook(userId,bookName);

			System.out.println(book);
		
	}	
	//测试addNote方法
	@Test
	public void testaddNote(){
		String bookId="123456";
		String userId="48595f52-b22c-4485-9244-f4004255b972";
		String noteTitle="xxoo";
		
		Note n=noteservice.addNote(bookId,userId,noteTitle);
		System.out.println(n);
		
	}
	
}

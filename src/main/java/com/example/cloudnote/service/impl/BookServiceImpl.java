package com.example.cloudnote.service.impl;

import java.sql.Timestamp;
import java.util.List;


import com.example.cloudnote.entity.Book;
import com.example.cloudnote.entity.User;
import com.example.cloudnote.exception.UserNotFoundException;
import com.example.cloudnote.service.BookService;
import com.example.cloudnote.dao.BookDao;
import com.example.cloudnote.dao.UserDao;
import com.example.cloudnote.util.NoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookdao;
	@Autowired
	private UserDao userdao;
	public List<Book>  loadBooks(String userId) throws UserNotFoundException {
		//判断userId是否为空
		if(userId==null || userId.trim().isEmpty()){
			
			//抛异常，用户未登录
			System.out.println("用户未登录，请重新登录");
			throw new UserNotFoundException("User ID不能为空");
			
		}
	
		//判断用户是否存在
		User user=userdao.findByUserId(userId);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
			
		}
		//调用bookdao方法
		
		//非空说明已经登录，开始查找
		List<Book> listBook=bookdao.findByUserId(userId);
		
		return listBook;
	}
	public Book addBook(String userId, String bookName) throws UserNotFoundException {
		if(userId==null || userId.trim().isEmpty()){
			throw new UserNotFoundException("UserID不能为空");
		}
		User user = userdao.findByUserId(userId);
		if(user==null){
			throw new UserNotFoundException("查无此用户");
		}
		if(bookName=="" || bookName.trim().isEmpty()){
			throw new UserNotFoundException("笔记本名称不能为空");
		}
		//验证通过
		Book book = new Book();
		book.setNotebookId(NoteUtil.createId());
		book.setUserId(userId);
		
		book.setNotebookName(bookName);

		book.setNotebookTypeId("5");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		book.setNotebookCreateTime(time);
		bookdao.save(book);
		
		
		return book;
	}

	


}

package com.example.cloudnote.controller;

import com.example.cloudnote.entity.Book;
import com.example.cloudnote.service.BookService;
import com.example.cloudnote.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController extends ExceptionController{

	@Autowired
	private BookService bookService;


	@ResponseBody
	@RequestMapping("/loadbooks.do")
	public JsonResult list(String userId){
		
		List<Book> result = bookService.loadBooks(userId);
		
		for(Book b:result){
			System.out.println(b);
		}
		
		return new JsonResult(result);
		
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public JsonResult addBook(String userId, String bookName){
		
		Book book = bookService.addBook(userId,bookName);
		
		return new JsonResult(book);
		
	}
	
	
	
	
}

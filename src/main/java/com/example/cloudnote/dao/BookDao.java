package com.example.cloudnote.dao;

import com.example.cloudnote.entity.Book;

import java.util.List;

public interface BookDao {
	List<Book> findByUserId(String userId);
	
	Book findByBookId(String bookId);
	
	void save(Book book);
	
}

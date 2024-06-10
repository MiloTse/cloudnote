package com.example.cloudnote.service;

import com.example.cloudnote.entity.Book;
import com.example.cloudnote.exception.UserNotFoundException;

import java.util.List;

public interface BookService {
	List<Book> loadBooks(String userId) throws UserNotFoundException;
	
	Book addBook(String userId,String bookName) throws UserNotFoundException;
	
}

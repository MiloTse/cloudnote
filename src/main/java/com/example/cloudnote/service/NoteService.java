package com.example.cloudnote.service;

import com.example.cloudnote.entity.Note;
import com.example.cloudnote.exception.NoteBookNotFoundException;
import com.example.cloudnote.exception.NoteNotFoundException;

import java.util.List;
import java.util.Map;

public interface NoteService {
	/**
	 * 根据bookId查找并列出该bookId下的笔记的方法
	 */
	public List<Map<String,Object>> listNote(String bookId) throws NoteBookNotFoundException;
	
	/**
	 * 根据noteId查找笔记用作显示内容和笔记标题的方法
	 */
	public Map<String,Object> showNote (String noteId) throws NoteNotFoundException;
	
	
	/**
	 * saveNote method
	 */
	public void saveNote(String noteId,String title,String body) throws NoteNotFoundException;
	
	public Note addNote(String userId, String noteTitle, String bookId) throws NoteNotFoundException;
	
}

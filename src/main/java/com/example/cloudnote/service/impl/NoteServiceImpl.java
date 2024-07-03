package com.example.cloudnote.service.impl;

import com.example.cloudnote.dao.BookDao;
import com.example.cloudnote.dao.NoteDao;
import com.example.cloudnote.entity.Book;
import com.example.cloudnote.entity.Note;
import com.example.cloudnote.exception.NoteBookNotFoundException;
import com.example.cloudnote.exception.NoteNotFoundException;
import com.example.cloudnote.service.NoteService;
import com.example.cloudnote.util.NoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteDao noteDao;
	@Autowired
	private BookDao bookDao;
	/**
	 * 该方法为进行业务判断，符合要求则调用NoteDao查找笔记
	 */
	public List<Map<String,Object>> listNote(String bookId) throws NoteBookNotFoundException {
		if(bookId==null || bookId.trim().isEmpty()){
			System.out.println("bookId不能为空，请刷新再试");
			 throw new NoteBookNotFoundException("Book ID不能为空");
		}
		
		
		//通过判断返回的book值。如果为空则抛异常
		Book book = bookDao.findByBookId(bookId);
		if(book==null){
			throw new NoteBookNotFoundException("笔记本不存在");
		}

		List<Map<String,Object>>list = noteDao.findByBookId(bookId);

		return list;
		
	}
	public Map<String, Object> showNote(String noteId) throws NoteNotFoundException {
		
		//判断Id是否为空
		
		//判断id数据是否有效
		
		
		
		
		
		if(noteId=="" || noteId.trim().isEmpty()){
			throw new NoteNotFoundException("Note ID不能为空");
		}
		
		Map<String,Object> m =noteDao.findByNoteId(noteId);
		if(m==null){
			throw new NoteNotFoundException("找不到该笔记喔");
		}
		
		return m;
	}
	
	
	
	public void saveNote(String noteId,String title,String body) throws NoteNotFoundException {
		if(noteId=="" || noteId.trim().isEmpty()){
			throw new NoteNotFoundException("Note ID不能为空");
		}
		if(title=="" || title.trim().isEmpty()){
			throw new NoteNotFoundException("title不能为空");
		}
		if(body=="" || noteId.trim().isEmpty()){
			body="";
		}
		Note note = new Note();
		note.setId(noteId);
		note.setTitle(title);
		note.setBody(body);
		
		//数据检测通过，开始调用dao进行保存
		noteDao.update(note);
		
	}
	public Note addNote(String userId, String noteTitle, String bookId) 
			throws NoteNotFoundException {
		//判断
		if(bookId==null || bookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("bookID不能为空");
		}
		
		if(userId==null){
			throw new NoteBookNotFoundException("找不到该用户");
		}
		if(noteTitle==null || noteTitle.trim().isEmpty()){
			throw new NoteBookNotFoundException("笔记标题不能为空");
		}
		
		
		Note n = new Note();
		n.setBookId(bookId);
		n.setCreateTime(System.currentTimeMillis());
		n.setId(NoteUtil.createId());
		n.setStatusId("1");
		n.setTitle(noteTitle);
		n.setTypeId("");
		n.setUserId(userId);
		noteDao.save(n);
		
		
		
		
		return n;
	}
}

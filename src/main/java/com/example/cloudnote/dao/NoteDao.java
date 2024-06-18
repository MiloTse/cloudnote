package com.example.cloudnote.dao;

import com.example.cloudnote.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteDao {

		List<Map<String,Object>> findByBookId(String bookId);
	
		Map<String,Object> findByNoteId(String noteId);

		void update(Note note);
		
		void save(Note note);
}

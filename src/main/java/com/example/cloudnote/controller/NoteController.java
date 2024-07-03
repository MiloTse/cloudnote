package com.example.cloudnote.controller;

import java.util.List;
import java.util.Map;


import com.example.cloudnote.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cloudnote.service.NoteService;
import com.example.cloudnote.util.JsonResult;

@Controller
@RequestMapping("/note")
public class NoteController extends ExceptionController{
	@Autowired
	private NoteService noteService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult listNote(String bookId){

		List<Map<String,Object>> result = noteService.listNote(bookId);

		return new JsonResult(result);
	}
	
	@RequestMapping("/show.do")
	@ResponseBody
	public JsonResult showNote(String noteId){    //将浏览器请求中的参数noteId传进来

		Map<String,Object> m = noteService.showNote(noteId);
		
		System.out.println("这是Controller输出的："+m);
		
		
		System.out.println(m.get("body")+","+m.get("title"));
	
		
		return new JsonResult(m);
	}
	
	/**
	 * 保存笔记
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult saveNote(String noteId,String title,String body){
	
		
		Note note = new Note();
	
		
		noteService.saveNote(noteId,title,body);
		
		JsonResult j = new JsonResult();
		j.setMessage("保存成功");
		return j;
		
		
		
		
	}
	
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult addNote(String userId,String noteTitle,String bookId){
		
		Note n = noteService.addNote(userId,noteTitle,bookId);
		
		return new JsonResult(n);
	}
	
}

package com.example.cloudnote.dao;

import com.example.cloudnote.entity.User;

public interface UserDao {
	public User findByName(String name);
	
	public void save(User user);
	
	public User findByUserId(String userId);
}

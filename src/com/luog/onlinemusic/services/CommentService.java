package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Comment;

public interface CommentService {
	
	public List<Comment> findAll();
	
	public Comment find(int id);
	
	public boolean create(Comment comment);
	
	public boolean update(Comment comment);
	
	public boolean delete(Comment comment);
}

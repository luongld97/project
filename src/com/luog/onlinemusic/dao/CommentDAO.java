package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Comment;

public interface CommentDAO {
	public List<Comment> findAll();

	public Comment find(int id);

	public boolean create(Comment comment);

	public boolean update(Comment comment);

	public boolean delete(Comment comment);
}

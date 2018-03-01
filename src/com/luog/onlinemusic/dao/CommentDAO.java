package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Comment;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.CommentEntity;

public interface CommentDAO {
	public List<Comment> findAll();

	public Comment find(int id);

	public boolean create(Comment comment);

	public boolean update(Comment comment);

	public boolean delete(Comment comment);
	
	public List<CommentEntity> getComments(Song song);
	
	public List<CommentEntity> getComments(Account account);
}

package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.CommentDAO;
import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Comment;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.CommentEntity;

@Transactional
@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public List<Comment> findAll() {
		return commentDAO.findAll();
	}

	@Override
	public Comment find(int id) {
		return commentDAO.find(id);
	}

	@Override
	public boolean create(Comment comment) {
		return commentDAO.create(comment);
	}

	@Override
	public boolean update(Comment comment) {
		return commentDAO.update(comment);
	}

	@Override
	public boolean delete(Comment comment) {
		return commentDAO.delete(comment);
	}

	@Override
	public List<CommentEntity> getComments(Song song) {
		return commentDAO.getComments(song);
	}

	@Override
	public List<CommentEntity> getComments(Account account) {
		return commentDAO.getComments(account);
	}
	
	

}

package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.CommentDAO;
import com.luog.onlinemusic.entity.commons.Comment;

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

}

package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AuthorDAO;
import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.entity.rest.AuthorEntity;

@Transactional
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDAO;

	@Override
	public List<Author> findAll() {
		return authorDAO.findAll();
	}

	@Override
	public Author find(int id) {
		return authorDAO.find(id);
	}
	
	@Override
	public boolean create(Author author) {
		return authorDAO.create(author);
	}

	@Override
	public boolean update(Author author) {
		return authorDAO.update(author);
	}
	
	@Override
	public boolean delete(Author author) {
		return authorDAO.delete(author);
	}

	@Override
	public List<AuthorEntity> getSongAuthor(Author author) {
		return authorDAO.getSongAuthor(author);
	}

	@Override
	public boolean isExist(String name) {
		return authorDAO.isExist(name);
	}

}

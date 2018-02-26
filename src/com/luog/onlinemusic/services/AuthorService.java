package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Author;

public interface AuthorService {
	public List<Author> findAll();

	public Author find(int id);

	public boolean create(Author author);
	
	public boolean update(Author author);
	
	public boolean delete(Author author);
}


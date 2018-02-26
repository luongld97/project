package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Author;

public interface AuthorDAO {

	public List<Author> findAll();

	public Author find(int id);

	public boolean create(Author author);

	public boolean update(Author author);

	public boolean delete(Author author);
}

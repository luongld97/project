package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Category;

public interface CategoryDAO {
	public List<Category> findAll();

	public Category find(int id);

	public boolean create(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);
	
	public boolean isExist(String name);
}

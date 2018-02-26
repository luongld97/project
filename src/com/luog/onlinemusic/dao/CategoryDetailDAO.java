package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.CategoryDetail;;

public interface CategoryDetailDAO {

	public List<CategoryDetail> findAll();

	public CategoryDetail find(int id);

	public boolean create(CategoryDetail categoryDetail);

	public boolean update(CategoryDetail categoryDetail);

	public boolean delete(CategoryDetail categoryDetail);
}

package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.CategoryDAO;
import com.luog.onlinemusic.entity.commons.Category;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public boolean isExist(String name) {
		if (categoryDAO != null) {
			System.out.println("Not null");
			return categoryDAO.isExist(name);
		}
		System.out.println("null");
		return true;
	}
	
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Category find(int id) {
		return categoryDAO.find(id);
	}

	@Override
	public boolean create(Category category) {
		return categoryDAO.create(category);
	}

	@Override
	public boolean update(Category category) {
		return categoryDAO.update(category);
	}

	@Override
	public boolean delete(Category category) {
		return categoryDAO.delete(category);
	}

}

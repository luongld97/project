package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.AuthorDetail;

public interface AuthorDetailDAO {
	
	public List<AuthorDetail> findAll();
	
	public AuthorDetail find(int id);
	
	public boolean create (AuthorDetail authorDetail);
	
	public boolean update(AuthorDetail authorDetail);
	
	public boolean delete(AuthorDetail authorDetail);
}

package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Role;

public interface RoleDAO {

	public List<Role> findAll();
	
	public Role find(int id);
	
	public boolean create(Role role);

	public boolean update(Role role);

	public boolean delete(Role role);
}

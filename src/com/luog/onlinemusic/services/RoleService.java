package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Role;

public interface RoleService {

	public List<Role> findAll();
	
	public Role find(int id);
	
	public boolean create(Role Role);
	
	public boolean update(Role Role);
	
	public boolean delete(Role Role);
}

package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.RoleDAO;
import com.luog.onlinemusic.entity.commons.Role;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public List<Role> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public Role find(int id) {
		return roleDAO.find(id);
	}

	@Override
	public boolean create(Role role) {
		return roleDAO.create(role);
	}

	@Override
	public boolean update(Role role) {
		return roleDAO.update(role);
	}

	@Override
	public boolean delete(Role role) {
		return roleDAO.delete(role);
	}
	
}

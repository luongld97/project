package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Account;

public interface AccountService {
	public List<Account> findAll();
	
	public Account find(String username);
	
	public boolean create(Account account);
	
	public boolean update(Account account);
	
	public boolean delete(Account account);
	
	public Account login(String username, String password);
}
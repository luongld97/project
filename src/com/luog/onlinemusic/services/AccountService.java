package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Song;

public interface AccountService {
	public List<Account> findAll();
	
	public Account find(String username);
	
	public boolean create(Account account);
	
	public boolean update(Account account);
	
	public boolean delete(Account account);
	
	public boolean changeStatus(Account account);
	
	public Account login(String username, String password);
	
	public boolean isExist(String username);
}

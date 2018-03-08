package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AccountDAO;
import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.helpers.BCrypt;

@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public Account find(String username) {
		return accountDAO.find(username);
	}
	
	@Override
	public boolean create(Account account) {
		return accountDAO.create(account);
	}

	@Override
	public boolean update(Account account) {
		return accountDAO.update(account);
	}
	
	@Override
	public boolean changeStatus(Account account) {
		boolean result = false;
		try {
			boolean currentStatus = account.isStatus();
			account.setStatus(!currentStatus);
			result = accountDAO.update(account);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public boolean delete(Account account) {
		return accountDAO.delete(account);
	}
	
	@Override
	public boolean isExist(String username) {
		return accountDAO.isExist(username);
	}

	@Override
	public Account login(String username, String password) {
		Account account = accountDAO.find(username);
		if(account != null) {
			if(BCrypt.checkpw(password, account.getPassword())) {
				return account;
			}
		}
		return null;
	}

}

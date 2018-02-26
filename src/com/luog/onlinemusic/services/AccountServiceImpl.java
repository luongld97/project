package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AccountDAO;
import com.luog.onlinemusic.entity.commons.Account;

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
	
	public boolean delete(Account account) {
		return accountDAO.delete(account);
	}
	
	public Account login(String username, String password) {
		return accountDAO.login(username, password);
	}

}

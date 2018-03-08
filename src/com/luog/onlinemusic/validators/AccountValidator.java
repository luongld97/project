package com.luog.onlinemusic.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.rest.AlbumEntity;
import com.luog.onlinemusic.services.AccountService;
import com.luog.onlinemusic.services.AlbumService;

@Component
public class AccountValidator implements Validator {
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Account.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Account account = (Account) object;
		if (accountService.isExist(account.getUsername()))
			errors.rejectValue("username", "account.exist");
	}
	
}

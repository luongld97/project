package com.luog.onlinemusic.validators;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.commons.Author;

@Service
public class AuthorValidator implements Validator {


	@Override
	public boolean supports(Class<?> arg0) {
		return Author.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
	}

}

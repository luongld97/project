package com.luog.onlinemusic.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.services.AuthorService;
import com.luog.onlinemusic.services.CategoryService;

@Service
public class AuthorValidator implements Validator {
	
	@Autowired
	private AuthorService authorService;

	@Override
	public boolean supports(Class<?> arg0) {
		return Author.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Author author = (Author) object;
		if (authorService.isExist(author.getName()) && author.getId() == null)
			errors.rejectValue("name", "author.exist");
	}

}

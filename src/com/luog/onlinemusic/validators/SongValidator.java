package com.luog.onlinemusic.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.rest.SongEntity;

@Component
public class SongValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return SongEntity.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}

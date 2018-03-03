package com.luog.onlinemusic.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.dao.SingerDAO;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.Singer;

@Service
public class SingerValidator implements Validator {


	@Autowired
	private SingerDAO singerDAO;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Singer.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Singer singer = (Singer) object;
		if (singer.getDateOfBirth() == null)
			errors.rejectValue("dateOfBirth", "date.null");
		if (singerDAO.isExist(singer.getName()))
			errors.rejectValue("name", "singer.exist");
	}

}

package com.luog.onlinemusic.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.rest.SongEntity;

@Component
public class SongValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return SongEntity.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		SongEntity songEntity = (SongEntity) object;
		if (songEntity.isVideo() && songEntity.getVideoLink().isEmpty())
			errors.rejectValue("videoLink", "videoLink.required");
		if (songEntity.getAuthors() == null && songEntity.getId() == null)
			errors.rejectValue("authors", "authors.required");
		if (songEntity.getCategories() == null && songEntity.getId() == null)
			errors.rejectValue("categories", "categories.required");
		if (songEntity.getSingers() == null && songEntity.getId() == null)
			errors.rejectValue("singers", "singers.required");

	}

}

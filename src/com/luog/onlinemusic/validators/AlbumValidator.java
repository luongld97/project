package com.luog.onlinemusic.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.rest.AlbumEntity;
import com.luog.onlinemusic.entity.rest.SongEntity;

@Component
public class AlbumValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return AlbumEntity.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		AlbumEntity albumEntity = (AlbumEntity) object;
		if (albumEntity.getName().isEmpty() && albumEntity.getPhoto().isEmpty() && albumEntity.getSingers().isEmpty()
				&& albumEntity.getSongs().isEmpty()) {
			errors.rejectValue("name", "name.required");
			errors.rejectValue("photo", "photo.required");
			errors.rejectValue("singers", "singers.required");
			errors.rejectValue("songs", "songs.required");
			
		}
	}

}

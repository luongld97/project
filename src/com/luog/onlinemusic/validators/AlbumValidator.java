package com.luog.onlinemusic.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.rest.AlbumEntity;
import com.luog.onlinemusic.services.AlbumService;

@Component
public class AlbumValidator implements Validator {
	
	@Autowired
	private AlbumService albumService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return AlbumEntity.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		AlbumEntity albumEntity = (AlbumEntity) object;
		if (albumEntity.getName() == null) {
			errors.rejectValue("name", "name.required");
		}
		if (albumEntity.getSingers() == null) {
			errors.rejectValue("singers", "singers.required");
		}
		if (albumEntity.getSongs() == null) {
			errors.rejectValue("songs", "songs.required");
		}
		
		if (albumService.isExist(albumEntity.getName()) && albumEntity.getId() == null)
			errors.rejectValue("name", "albumEntity.exist");
	}
	
}

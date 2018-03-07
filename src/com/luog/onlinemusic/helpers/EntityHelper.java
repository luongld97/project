package com.luog.onlinemusic.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SingerEntity;
import com.luog.onlinemusic.entity.rest.SongEntity;

public class EntityHelper {

	/**
	 * @author luog
	 */
	public static SongEntity toSongEntity(Song temp) {
		SongEntity songEntity = null;
		try {
			songEntity = new SongEntity();
			songEntity.setId(temp.getId());
			songEntity.setName(temp.getName());
			songEntity.setLink(temp.getLink());
			songEntity.setLyric(temp.getLyric());
			songEntity.setListen(0);
			songEntity.setStatus(temp.isStatus());
			songEntity.setVideo(temp.isVideo());
			songEntity.setVideoLink(temp.getVideoLink());
			songEntity.setVideoPhoto(temp.getVideoPhoto());
			songEntity.setUploadedTime(
					new SimpleDateFormat("yyyy-MM-dd")
						.format(temp.getUploadedTime())
				);
			songEntity.setUploadedBy(temp.getUploadedBy());
			List<Integer> authors= new ArrayList<>(), 
						  categories= new ArrayList<>(), 
						  singers = new ArrayList<>();
			temp.getAuthorDetails().forEach(
					authorDetail -> 
						authors.add(authorDetail.getAuthor().getId())
				);
			temp.getSongDetails().forEach(
					songDetail -> 
						singers.add(songDetail.getSinger().getId())
				);
			temp.getCategoryDetails().forEach(
					categoryDetail -> 
						categories.add(categoryDetail.getCategory().getId())
				);
			songEntity.setAuthors(authors);
			songEntity.setCategories(categories);
			songEntity.setSingers(singers);
		} catch (Exception e) {
			songEntity = new SongEntity();
		}
		return songEntity;
	}
	
	public static SingerEntity toSingerEntity(Singer singer) {

		SingerEntity singerEntity = null;
		SimpleDateFormat simpleDateFormat = null;
		try {
			singerEntity = new SingerEntity();
			singerEntity.setId(singer.getId());
			singerEntity.setName(singer.getName());
			singerEntity.setNickName(singer.getNickName());
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			singerEntity.setDateOfBirth(
					simpleDateFormat.format(singer.getDateOfBirth())
				);
			singerEntity.setGender(singer.getGender());
			singerEntity.setDescription(singer.getDescription());
			singerEntity.setPhoto(singer.getPhoto());
		} catch (Exception e) {
			e.printStackTrace();
			singerEntity = new SingerEntity();
		}
		return singerEntity;
	}

}

package com.luog.onlinemusic.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;

public class SongHelper {

	/**
	 * @author luog
	 */
	public static Song toSong(SongEntity temp) {
		Song song = new Song();
		song.setName(temp.getName());
		song.setLink(temp.getLink());
		song.setLyric(temp.getLyric());
		song.setListen(0);
		song.setShow(temp.isShow());
		song.setStatus(temp.isStatus());
		song.setVideo(temp.isVideo());
		song.setVideoLink(temp.getVideoLink());
		song.setVideoPhoto(temp.getVideoPhoto());
		song.setUploadedTime(new Date());
		song.setUploadedBy(temp.getUploadedBy());
		
		return song;
	}
	
	/**
	 * @author luog
	 */
	public static SongEntity toSongEntity(Song temp) {
		SongEntity songEntity = new SongEntity();
		songEntity.setId(temp.getId());
		songEntity.setName(temp.getName());
		songEntity.setLink(temp.getLink());
		songEntity.setLyric(temp.getLyric());
		songEntity.setListen(0);
		songEntity.setShow(temp.isShow());
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
		return songEntity;
	}

}

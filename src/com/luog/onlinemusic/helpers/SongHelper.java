package com.luog.onlinemusic.helpers;

import java.util.ArrayList;
import java.util.List;

import com.luog.onlinemusic.entity.admin.AdminSong;
import com.luog.onlinemusic.entity.commons.AuthorDetail;
import com.luog.onlinemusic.entity.commons.CategoryDetail;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.commons.SongDetail;

public class SongHelper {

	public static Song toSong(AdminSong adminSong) {
		Song song = new Song();
		song.setId(adminSong.getId());
		song.setName(adminSong.getName());
		song.setLink(adminSong.getLink());
		song.setLyric(adminSong.getLyric());
		song.setShow(adminSong.isShow());
		song.setStatus(adminSong.isStatus());
		song.setVideo(adminSong.isVideo());
		song.setUploadedBy(adminSong.getUploadedBy());
		song.setUploadedTime(adminSong.getUploadedTime());
		song.setListen(adminSong.getListen());
		song.setVideoPhoto(adminSong.getVideoPhoto());
		return song;
	}
	
	public static AdminSong toAdminSong(Song song) {
		AdminSong adminSong = new AdminSong();
		
		adminSong.setId(song.getId());
		adminSong.setName(song.getName());
		adminSong.setLink(song.getLink());
		adminSong.setLyric(song.getLyric());
		adminSong.setShow(song.isShow());
		adminSong.setStatus(song.isStatus());
		adminSong.setVideo(song.isVideo());
		adminSong.setUploadedBy(song.getUploadedBy());
		adminSong.setUploadedTime(song.getUploadedTime());
		adminSong.setListen(song.getListen());
		adminSong.setVideoPhoto(song.getVideoPhoto());
		List<Integer> authors = new ArrayList<>(), singers = new ArrayList<>(), categories = new ArrayList<>();
		for (AuthorDetail authorDetail : song.getAuthorDetails()) {
			authors.add(authorDetail.getAuthor().getId());
		}

		for (CategoryDetail categoryDetail : song.getCategoryDetails()) {
			categories.add(categoryDetail.getCategory().getId());
		}

		for (SongDetail songDetail : song.getSongDetails()) {
			singers.add(songDetail.getSinger().getId());
		}
		adminSong.setAuthors(authors);
		adminSong.setCategories(categories);
		adminSong.setSingers(singers);
		return adminSong;
	}
}

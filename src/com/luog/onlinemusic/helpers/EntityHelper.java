package com.luog.onlinemusic.helpers;

import java.text.SimpleDateFormat;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.Comment;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.AlbumEntity;
import com.luog.onlinemusic.entity.rest.CommentEntity;
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
			songEntity.setListen(temp.getListen());
			songEntity.setStatus(temp.isStatus());
			songEntity.setVideo(temp.isVideo());
			songEntity.setView(temp.getView());
			songEntity.setVideoLink(temp.getVideoLink());
			songEntity.setVideoPhoto(temp.getVideoPhoto());
			songEntity.setUploadedTime(new SimpleDateFormat("yyyy-MM-dd").format(temp.getUploadedTime()));
			songEntity.setUploadedBy(temp.getUploadedBy());
			String singers = "";
			for (int i = 0; i < temp.getSongDetails().size(); i++) {
				Singer currentSinger = temp.getSongDetails().get(i).getSinger();
				singers += currentSinger.getId() + ":" + currentSinger.getName() + ":" + currentSinger.getPhoto();
				if (i < temp.getSongDetails().size() - 1)
					singers += ",";
			}

			String authors = "";
			for (int i = 0; i < temp.getAuthorDetails().size(); i++) {
				Author currentAuthor = temp.getAuthorDetails().get(i).getAuthor();
				authors += currentAuthor.getId() + ":" + currentAuthor.getName() + ":" + currentAuthor.getPhoto();
				if (i < temp.getAuthorDetails().size() - 1)
					authors += ",";
			}

			String categories = "";
			for (int i = 0; i < temp.getCategoryDetails().size(); i++) {
				Category currentCategory = temp.getCategoryDetails().get(i).getCategory();
				categories += currentCategory.getId() + ":" + currentCategory.getName();
				if (i < temp.getCategoryDetails().size() - 1)
					categories += ",";
			}
			songEntity.setSingers(singers);
			songEntity.setAuthors(authors);
			songEntity.setCategories(categories);
		} catch (Exception e) {
			songEntity = null;
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
			singerEntity.setDateOfBirth(simpleDateFormat.format(singer.getDateOfBirth()));
			singerEntity.setGender(singer.getGender());
			singerEntity.setDescription(singer.getDescription());
			singerEntity.setPhoto(singer.getPhoto());
		} catch (Exception e) {
			e.printStackTrace();
			singerEntity = null;
		}
		return singerEntity;
	}

	public static AlbumEntity toAlbumEntity(Album album) {

		AlbumEntity albumEntity = null;
		SimpleDateFormat simpleDateFormat = null;
		try {
			albumEntity = new AlbumEntity();
			albumEntity.setId(album.getId());
			albumEntity.setName(album.getName());
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			albumEntity.setReleasedTime(simpleDateFormat.format(album.getReleasedTime()));

			String song = "";
			for (int i = 0; i < album.getAlbumSongs().size() - 1; i++) {
				Song currentSong = album.getAlbumSongs().get(i).getSong();
				song += currentSong.getId() + ":" + currentSong.getName();
				if (i < album.getAlbumSongs().size() - 2)
					song += ',';
			}

			String singer = "";
			for (int i = 0; i < album.getAlbumSingers().size() - 1; i++) {
				Singer currentSinger = album.getAlbumSingers().get(i).getSinger();
				singer += currentSinger.getId() + ":" + currentSinger.getName();
				if (i < album.getAlbumSingers().size() - 2)
					singer += ',';
			}
			albumEntity.setSongs(song);
			albumEntity.setSongs(singer);
		} catch (Exception e) {
			e.printStackTrace();
			albumEntity = null;
		}
		return albumEntity;
	}

	public static CommentEntity toCommentEntity(Comment comment) {
		CommentEntity commentEntity = null;
		SimpleDateFormat simpleDateFormat = null;
		try {
			commentEntity = new CommentEntity();
			commentEntity.setContent(comment.getContent());
			commentEntity.setId(comment.getId());
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			commentEntity.setCreated(simpleDateFormat.format(comment.getCreated()));
			commentEntity.setSongId(comment.getSong().getId());
			commentEntity.setUsername(comment.getAccount().getUsername());
			commentEntity.setUserPhoto(comment.getAccount().getPhoto());
		} catch (Exception e) {
			commentEntity = null;
		}
		return commentEntity;
	}
	
	

}

package com.luog.onlinemusic.services;

import java.util.Date;
import java.util.List;

import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;

public interface SongService {

	public List<Song> findAll(Boolean status);
	
	public Song find(int id);

	public boolean create(SongEntity temp);
	
	public boolean update(SongEntity temp);
	
	public boolean changeStatus(Song song);
	
	public boolean delete(Song song);

	public List<SongInfo> findSongInfo(Integer limit);
	
	public List<SongInfo> findMVSongInfo(Integer limit);
	
	public List<SongInfo> findSongBySinger(Singer singer);
	
	public List<SongInfo> findSongInCategory(Category category, Integer limit);

	public SongEntity getSongEntity(int id);

	public List<Song> randomSong(int limit, Song current);

	List<SongEntity> findSongEntities(String keyWord);

	public List<Song> getTopSongs(Singer singer, Integer limit);
	
	public List<SongEntity> getTopSong(boolean isVideo, Date currentDate, Integer limit);
	
	public Long getListen(Song song, boolean isVideo);
}

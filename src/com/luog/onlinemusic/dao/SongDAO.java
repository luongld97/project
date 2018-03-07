package com.luog.onlinemusic.dao;

import java.util.Date;
import java.util.List;

import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;

public interface SongDAO {
	public List<Song> findAll();

	public List<Song> findAll(boolean isVideo);

	public Song find(int id);
	
	public Song find(int id, boolean status);

	public boolean create(Song song);

	public boolean update(Song song);

	public boolean delete(Song song);

	public List<SongInfo> findSongInfo(Integer limit);

	public List<SongInfo> findMVSongInfo(Integer limit);

	public List<SongInfo> findSongBySinger(Singer singer);

	public List<SongInfo> findSongInCategory(Category category, Integer limit);

	public SongEntity getSongEntity(int id);

	public List<Song> randomSong(int limit, Song current);
	
	public List<Song> randomSong(Singer singer, boolean isVideo, int limit, Song current);

	List<SongEntity> findSongEntities(String keyWord);
	
	List<Song> findSong(String keyWord);

	List<Song> getTopSongs(Singer singer, Integer limit);
	
	public List<Song> getTopSong(boolean isVideo, Date currentDate, Integer limit);
}

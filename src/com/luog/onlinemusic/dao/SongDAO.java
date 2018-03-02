package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;

public interface SongDAO {
	public List<Song> findAll();

	public Song find(int id);

	public boolean create(Song song);

	public boolean update(Song song);

	public boolean delete(Song song);

	public List<SongInfo> findSongInfo();
	
	public List<SongInfo> findMVSongInfo();
	
	public List<SongInfo> findSongInCategory(Category category);

	public SongEntity getSongEntity(int id);

	public List<Song> randomSong(int limit);
	
	List<SongEntity> findSongEntities(String keyWord);
	
	List<Song> getTopSongs(Singer singer, Integer limit);
}

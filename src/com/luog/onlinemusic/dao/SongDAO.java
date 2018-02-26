package com.luog.onlinemusic.dao;

import java.util.List;
import java.util.Set;

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

	public SongEntity getSongEntity(int id);

	public Set<Song> randomSong(int limit, List<Object> conditions);

	public List<Song> randomSong(int limit);
}
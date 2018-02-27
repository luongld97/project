package com.luog.onlinemusic.services;

import java.util.List;
import java.util.Set;

import com.luog.onlinemusic.entity.admin.AdminSong;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;

public interface SongService {

	/**
	 * @author luog
	 */
	public List<Song> findAll();

	/**
	 * @author luog
	 */
	public Song find(int id);

	public boolean create(AdminSong song);

	/**
	 * @author luog
	 */
	public boolean update(AdminSong song);

	/**
	 * @author luog
	 */
	public boolean delete(AdminSong song);

	/**
	 * @author luog
	 */
	public boolean delete(Song song);

	public List<SongInfo> findSongInfo();

	/**
	 * @author luog
	 */
	public boolean increaseSongListen(Song song);

	/**
	 * @author luog
	 */

	public SongEntity getSongEntity(int id);
	
	/**
	 * @author luog
	 */

	public Set<Song> randomSong(int limit, List<Object> conditions);

	
	public List<Song> randomSong(int limit);
}

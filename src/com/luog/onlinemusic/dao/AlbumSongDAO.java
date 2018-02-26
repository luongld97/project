package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.AlbumSong;

public interface AlbumSongDAO {
	
public List<AlbumSong> findAll();
	
	public AlbumSong find(int id);
	
	public boolean create (AlbumSong albumSong);
	
	public boolean update(AlbumSong albumSong);
	
	public boolean delete(AlbumSong albumSong);
}

package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Song;

public interface AlbumDAO {

	
	public List<Album> findAll();
	
	public Album find(int id);
	
	public boolean create (Album album);
	
	public boolean update(Album album);
	
	public boolean delete(Album album);
	
}

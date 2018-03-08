package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Singer;

public interface AlbumDAO {

	
	public List<Album> findAll();
	
	public Album find(int id);
	
	public boolean create (Album album);
	
	public boolean update(Album album);
	
	public boolean delete(Album album);
	
	public List<Album> getAlbums(Singer singer);
	
	public boolean isExist(String name);
	
	public List<Album> randomAlbum(int limit, Album current);
	
}

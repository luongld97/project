package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.rest.AlbumEntity;

public interface AlbumService {

	public List<Album> findAll();

	public Album find(int id);

	public boolean create(AlbumEntity temp);

	public boolean update(AlbumEntity album);

	public boolean delete(Album album);
	
	public List<Album> getAlbums(Singer singer);

}

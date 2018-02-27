package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Album;

public interface AlbumService {

	public List<Album> findAll();

	public Album find(int id);

	public boolean create(Album album);

	public boolean update(Album album);

	public boolean delete(Album album);

}

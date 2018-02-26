package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.rest.AlbumContainSong;
import com.luog.onlinemusic.entity.rest.AlbumOfSinger;

public interface AlbumDAO {

	
	public List<Album> findAll();
	
	public Album find(int id);
	
	public boolean create (Album album);
	
	public boolean update(Album album);
	
	public boolean delete(Album album);
	
	public List<AlbumOfSinger> findAlbumSinger();
	
	public List<AlbumContainSong> findAlbumContainSong();
	
	public AlbumContainSong findSongByAlbum(int albumId);
	
	public List<AlbumContainSong> findSongByAlbums(int albumId);
}

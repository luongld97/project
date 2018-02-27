package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.AlbumSong;
import com.luog.onlinemusic.entity.rest.AlbumSongEntity;

public interface AlbumSongService {
	
	public List<AlbumSong> findAll();

	public AlbumSong find(int id);

	public boolean create(AlbumSong albumSong);

	public boolean update(AlbumSong albumSong);

	public boolean delete(AlbumSong albumSong);
	
	public List<AlbumSongEntity> findAlbumSong();

	public List<AlbumSongEntity> getSongByAlbum(Album album);
}

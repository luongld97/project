package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AlbumSongDAO;
import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.AlbumSong;
import com.luog.onlinemusic.entity.rest.AlbumSongEntity;;

@Transactional
@Service("albumSongService")
public class AlbumSongServiceImpl implements AlbumSongService{
	
	@Autowired
	private AlbumSongDAO albumSongDAO;

	@Override
	public List<AlbumSong> findAll() {
		return albumSongDAO.findAll();
	}

	@Override
	public AlbumSong find(int id) {
		return albumSongDAO.find(id);
	}

	@Override
	public boolean create(AlbumSong albumSong) {
		return albumSongDAO.create(albumSong);
	}

	@Override
	public boolean update(AlbumSong albumSong) {
		return albumSongDAO.update(albumSong);
	}

	@Override
	public boolean delete(AlbumSong albumSong) {
		return albumSongDAO.delete(albumSong);
	}

	@Override
	public List<AlbumSongEntity> findAlbumSong() {
		return albumSongDAO.findAlbumSong();
	}

	@Override
	public List<AlbumSongEntity> getSongByAlbum(Album album) {
		return albumSongDAO.getSongByAlbum(album);
	}

	
}

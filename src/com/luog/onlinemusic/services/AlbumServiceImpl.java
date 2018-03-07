package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AlbumDAO;
import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.rest.AlbumEntity;

@Transactional
@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumDAO albumDAO;

	@Override
	public List<Album> findAll() {
		return albumDAO.findAll();
	}

	@Override
	public Album find(int id) {
		return albumDAO.find(id);
	}

	@Override
	public boolean create(AlbumEntity albumEntity) {
		
		return albumDAO.create(new Album());
	}

	@Override
	public boolean update(AlbumEntity albumEntity) {
		return albumDAO.update(new Album());
	}

	@Override
	public boolean delete(Album album) {
		return albumDAO.delete(album);
	}

	/**
	 * @author luog
	 */
	@Override
	public List<Album> getAlbums(Singer singer) {
		return albumDAO.getAlbums(singer);
	}
	
	

}

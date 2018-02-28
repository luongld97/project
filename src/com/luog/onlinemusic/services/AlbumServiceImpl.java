package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AlbumDAO;
import com.luog.onlinemusic.entity.commons.Album;

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
	public boolean create(Album album) {
		return albumDAO.create(album);
	}

	@Override
	public boolean update(Album album) {
		return albumDAO.update(album);
	}

	@Override
	public boolean delete(Album album) {
		return albumDAO.delete(album);
	}

}

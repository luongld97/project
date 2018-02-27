package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AlbumSingerDAO;
import com.luog.onlinemusic.entity.commons.AlbumSinger;
import com.luog.onlinemusic.entity.rest.AlbumSingerEntity;

@Transactional
@Service("albumSingerService")
public class AlbumSingerServiceImpl implements AlbumSingerService{
	
	@Autowired
	private AlbumSingerDAO albumSingerDAO;
	
	@Override
	public List<AlbumSinger> findAll() {
		return albumSingerDAO.findAll();
	}

	@Override
	public AlbumSinger find(int id) {
		return albumSingerDAO.find(id);
	}

	@Override
	public boolean create(AlbumSinger albumSinger) {
		return albumSingerDAO.create(albumSinger);
	}

	@Override
	public boolean update(AlbumSinger albumSinger) {
		return albumSingerDAO.update(albumSinger);
	}

	@Override
	public boolean delete(AlbumSinger albumSinger) {
		return albumSingerDAO.delete(albumSinger);
	}

	@Override
	public List<AlbumSingerEntity> findAlbumSinger() {
		return albumSingerDAO.findAlbumSinger();
	}

}

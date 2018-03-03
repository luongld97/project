package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.SingerDAO;
import com.luog.onlinemusic.entity.commons.Singer;

@Transactional
@Service("singerService")
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerDAO singerDAO;

	@Override
	public List<Singer> findAll() {
		return singerDAO.findAll();
	}

	@Override
	public Singer find(int id) {
		return singerDAO.find(id);
	}
	
	@Override
	public boolean create(Singer singer) {
		return singerDAO.create(singer);
	}
	
	@Override
	public boolean update(Singer singer) {
		return singerDAO.update(singer);
	}
	
	@Override
	public boolean delete(Singer singer) {
		return singerDAO.delete(singer);
	}
	

}

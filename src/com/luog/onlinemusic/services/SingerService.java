package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.rest.SingerEntity;

public interface SingerService {
	public List<Singer> findAll();
	
	public Singer find(int id);
	
	public boolean create(Singer singer);
	
	public boolean update(Singer singer);
	
	public boolean create(SingerEntity temp);
	
	public boolean update(SingerEntity temp);
	
	public boolean delete(Singer singer);
	
	public List<SingerEntity> findSingerEntities (String keyWord);
}

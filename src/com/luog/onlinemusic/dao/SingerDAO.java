package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SingerEntity;

public interface SingerDAO {

	public List<Singer> findAll();

	public Singer find(int id);

	public boolean create(Singer singer);

	public boolean update(Singer singer);

	public boolean delete(Singer singer);
	
	public List<SingerEntity> findSingerEntities (String keyWord);
	
	public List<Singer> findSinger(String keyWord);
	
	public boolean isExist(String name);
	
}

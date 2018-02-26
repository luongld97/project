package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.SongDetail;

public interface SongDetailDAO {
	
	public List<SongDetail> findAll();
	
	public SongDetail find(int id);
	
	public boolean create (SongDetail songDetail);
	
	public boolean update(SongDetail songDetail);
	
	public boolean delete(SongDetail songDetail);
	
	/**
	 * @author luog
	 */
	public int isExist(SongDetail songDetail);
	
}

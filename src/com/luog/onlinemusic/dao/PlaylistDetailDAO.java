package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.PlayListDetail;

public interface PlaylistDetailDAO {
	
	public List<PlayListDetail> findAll();
	
	public PlayListDetail find(int id);
	
	public boolean create (PlayListDetail playListDetail);
	
	public boolean update(PlayListDetail playListDetail);
	
	public boolean delete(PlayListDetail playListDetail);
}

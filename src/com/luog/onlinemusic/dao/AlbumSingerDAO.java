package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.AlbumSinger;

public interface AlbumSingerDAO {
public List<AlbumSinger> findAll();
	
	public AlbumSinger find(int id);
	
	public boolean create (AlbumSinger album);
	
	public boolean update(AlbumSinger album);
	
	public boolean delete(AlbumSinger album);
}

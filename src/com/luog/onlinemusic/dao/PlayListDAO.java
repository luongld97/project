package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.rest.PlayListEntity;

public interface PlayListDAO {
	
	public List<PlayList> findAll();

	public PlayList find(int id);

	public boolean create(PlayList playList);

	public boolean update(PlayList playList);

	public boolean delete(PlayList playList);
	
	public List<PlayList> getUserPlayList(Account account);
	
	public List<PlayListEntity> getSongPlayList(PlayList playList);
	
	public boolean isExist(String name);
}

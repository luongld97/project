package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.PlayList;

public interface PlayListService {
	
	public List<PlayList> findAll();
	
	public PlayList find(int id);
	
	public boolean create(PlayList playList);
	
	public boolean update(PlayList playList);
	
	public boolean delete(PlayList playList);
	
	public List<PlayList> getUserPlayList(Account account);
}

package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.PlayListDAO;
import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.rest.PlayListEntity;

@Transactional
@Service("playListService")
public class PlayListServiceImpl implements PlayListService{
	
	@Autowired
	private PlayListDAO playListDAO;
	
	@Override
	public List<PlayList> findAll() {
		return playListDAO.findAll();
	}

	@Override
	public PlayList find(int id) {
		return playListDAO.find(id);
	}

	@Override
	public boolean create(PlayList playList) {
		return playListDAO.create(playList);
	}

	@Override
	public boolean update(PlayList playList) {
		return playListDAO.update(playList);
	}

	@Override
	public boolean delete(PlayList playList) {
		return playListDAO.delete(playList);
	}

	/**
	 * @author luog
	 */
	@Override
	public List<PlayList> getUserPlayList(Account account) {
		return playListDAO.getUserPlayList(account);
	}

	@Override
	public List<PlayListEntity> getSongPlayList(PlayList playList) {
		return playListDAO.getSongPlayList(playList);
	}

	/**
	 * @author luog
	 */
	@Override
	public boolean isExist(String name) {
		return playListDAO.isExist(name);
	}
	
	

}

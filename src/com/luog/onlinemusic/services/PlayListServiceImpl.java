package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.PlayListDAO;
import com.luog.onlinemusic.dao.PlaylistDetailDAO;
import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.PlayListDetail;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.PlayListEntity;

@Transactional
@Service("playListService")
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	private PlayListDAO playListDAO;

	@Autowired
	private PlaylistDetailDAO playListDetailDAO;

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
		boolean result = false;
		try {
			for (PlayListDetail playListDetail : playList.getPlayListDetails()) {
				result = playListDetailDAO.delete(playListDetail);
			}
			if (result) {
				result = playListDAO.delete(playList);
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	/**
	 * @author luog
	 */
	@Override
	public List<PlayList> getPlayLists(Account account) {
		return playListDAO.getPlayLists(account);
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

	/**
	 * @author luog
	 */
	@Override

	public boolean contain(Song song, PlayList inPlayList) {
		return playListDAO.contain(song, inPlayList);
	}

	@Override
	public List<PlayList> randomPlayList(Account account, int limit, PlayList current) {
		return playListDAO.randomPlayList(account, limit, current);
	}

}

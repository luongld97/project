package com.luog.onlinemusic.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.PlaylistDetailDAO;
import com.luog.onlinemusic.entity.commons.PlayListDetail;

@Transactional
@Service("playListDetailService")
public class PlayListDetailServiceImpl implements PlayListDetailService {

	@Autowired
	private PlaylistDetailDAO playlistDetailDAO;
	
	@Override
	public boolean create(PlayListDetail playListDetail) {
		return playlistDetailDAO.create(playListDetail);
	}

}

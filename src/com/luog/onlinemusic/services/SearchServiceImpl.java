package com.luog.onlinemusic.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.SingerDAO;
import com.luog.onlinemusic.dao.SongDAO;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SingerEntity;
import com.luog.onlinemusic.entity.rest.SongEntity;

@Transactional
@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SingerDAO singerDAO;

	@Autowired
	private SongDAO songDAO;

	@Override
	public List<Object> searchWS(String keyWord) {
		List<Object> result = null;
		try {

			result = new ArrayList<>();
			List<SongEntity> songEntities = songDAO.findSongEntities(keyWord);
			List<SingerEntity> singerEntities = singerDAO.findSingerEntities(keyWord);
			result.addAll(songEntities);
			result.addAll(singerEntities);
		} catch (Exception e) {
			result = new ArrayList<>();
		}
		return result;
	}
	
	@Override
	public List<Object> search(String keyWord) {
		List<Object> result = null;
		try {
			result = new ArrayList<>();
			List<Song> songs = songDAO.findSong(keyWord);
			List<Singer> singers = singerDAO.findSinger(keyWord);
			result.addAll(songs);
			result.addAll(singers);
		} catch (Exception e) {
			result = new ArrayList<>();
		}
		return result;
	}

}

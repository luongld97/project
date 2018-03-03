package com.luog.onlinemusic.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AuthorDAO;
import com.luog.onlinemusic.dao.AuthorDetailDAO;
import com.luog.onlinemusic.dao.CategoryDAO;
import com.luog.onlinemusic.dao.SingerDAO;
import com.luog.onlinemusic.dao.SongDetailDAO;
import com.luog.onlinemusic.dao.CategoryDetailDAO;
import com.luog.onlinemusic.dao.SongDAO;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;

@Transactional
@Service("songService")
public class SongServiceImpl implements SongService {

	@Autowired
	private SongDAO songDAO;

	@Autowired
	private SongDetailDAO songDetailDAO;

	@Autowired
	private AuthorDetailDAO authorDetailDAO;

	@Autowired
	private CategoryDetailDAO categoryDetailDAO;

	@Autowired
	private SingerDAO singerDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private AuthorDAO authorDAO;

	@Override
	public List<Song> findAll() {
		return songDAO.findAll();
	}

	@Override
	public Song find(int id) {
		return songDAO.find(id);
	}
	
	@Override
	public boolean create(Song song) {
		boolean result = false;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	@Override
	public boolean update(Song song) {
		boolean result = false;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}


	@Override
	public boolean delete(Song song) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SongInfo> findSongInfo() {
		return songDAO.findSongInfo();
	}

	/**
	 * @author luog
	 */
	@Override
	public boolean increaseSongListen(Song song) {
		boolean result = false;
		try {
			int currentSongListen = song.getListen();
			song.setListen(currentSongListen + 1);
			result = songDAO.update(song);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * @author luog
	 */
	@Override
	public SongEntity getSongEntity(int id) {
		return songDAO.getSongEntity(id);
	}

	/**
	 * @author luog
	 */
	@Override
	public List<Song> randomSong(int limit) {
		return songDAO.randomSong(limit);
	}

	/**
	 * @author luog
	 */
	@Override
	public List<SongEntity> findSongEntities(String keyWord) {
		return songDAO.findSongEntities(keyWord);
	}

	@Override
	public List<SongInfo> findMVSongInfo() {
		return songDAO.findMVSongInfo();
	}

	/**
	 * @author luog
	 */
	@Override
	public List<Song> getTopSongs(Singer singer, Integer limit) {
		return songDAO.getTopSongs(singer, limit);
	}

	@Override
	public List<SongInfo> findSongInCategory(Category category) {
		return songDAO.findSongInCategory(category);
	}

}

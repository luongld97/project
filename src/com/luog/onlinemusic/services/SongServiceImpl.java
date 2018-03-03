package com.luog.onlinemusic.services;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.luog.onlinemusic.entity.commons.AuthorDetail;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.CategoryDetail;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.commons.SongDetail;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;
import com.luog.onlinemusic.helpers.SongHelper;

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

	/*
	 * (non-Javadoc)
	 * @see com.luog.onlinemusic.services.SongService#findAll(java.lang.Boolean)
	 * @param boolean status 
	 * This method will return list song with status
	 * @param null
	 * This method will return all song
	 */
	@Override
	public List<Song> findAll(Boolean status) {
		return songDAO.findAll(status);
	}

	@Override
	public Song find(int id) {
		return songDAO.find(id);
	}

	/**
	 * @author luog
	 */
	@Override
	public boolean create(SongEntity temp) {
		boolean result = false;
		try {
			Song song = new Song();
			song.setName(temp.getName());
			song.setLink(temp.getLink());
			song.setLyric(temp.getLyric());
			song.setListen(0);
			song.setShow(temp.isShow());
			song.setStatus(true);
			song.setVideo(temp.isVideo());
			song.setVideoLink(temp.getVideoLink());
			song.setVideoPhoto(temp.getVideoPhoto());
			song.setUploadedTime(new Date());
			song.setUploadedBy(temp.getUploadedBy());
			result = songDAO.create(song);
			if (result) 
				result = toSongRelationship(temp, song);
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
	public boolean update(SongEntity temp) {
		boolean result = false;
		try {
			Song currentSong = songDAO.find(temp.getId());
			currentSong.setName(temp.getName());
			currentSong.setLink(temp.getLink());
			currentSong.setLyric(temp.getLyric());
			currentSong.setShow(temp.isShow());
			currentSong.setStatus(temp.isStatus());
			currentSong.setVideo(temp.isVideo());
			currentSong.setVideoLink(temp.getVideoLink());
			currentSong.setVideoPhoto(temp.getVideoPhoto());
			result = songDAO.update(currentSong);
			if (result) {
				result = removeSongRelationship(currentSong);
				result = toSongRelationship(temp, currentSong);
				
			}
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
	public boolean changeStatus(Song song) {
		boolean result = false;
		try {
			boolean currentStatus = song.isStatus();
			song.setStatus(!currentStatus);
			result = songDAO.update(song);
		} catch (Exception e) {
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
	
	/**
	 * @author luog
	 */
	private boolean toSongRelationship(SongEntity songEntity, Song song) {
		boolean result = false;
		for (int singerId : songEntity.getSingers()) {
			SongDetail songDetail = new SongDetail();
			songDetail.setSong(song);
			songDetail.setSinger(singerDAO.find(singerId));
			result = songDetailDAO.create(songDetail);
		}
		for (int categoryId : songEntity.getCategories()) {
			CategoryDetail categoryDetail = new CategoryDetail();
			categoryDetail.setSong(song);
			categoryDetail.setCategory(categoryDAO.find(categoryId));
			result = categoryDetailDAO.create(categoryDetail);
		}
		for (int authorId : songEntity.getAuthors()) {
			AuthorDetail authorDetail = new AuthorDetail();
			authorDetail.setSong(song);
			authorDetail.setAuthor(authorDAO.find(authorId));
			result = authorDetailDAO.create(authorDetail);
		}
		return result;
	}
	
	/**
	 * @author luog
	 */
	private boolean removeSongRelationship(Song song) {
		boolean result = false;
		for (SongDetail songDetail : song.getSongDetails())
			result = songDetailDAO.delete(songDetail);
		for (CategoryDetail categoryDetail : song.getCategoryDetails())
			result = categoryDetailDAO.delete(categoryDetail);
		for (AuthorDetail authorDetail : song.getAuthorDetails())
			result = authorDetailDAO.delete(authorDetail);
		return result;
	}
	@Override
	public List<SongInfo> findSongBySinger(Singer singer) {
		return songDAO.findSongBySinger(singer);
	}
	
	
	
}

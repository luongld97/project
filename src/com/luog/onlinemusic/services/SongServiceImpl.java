package com.luog.onlinemusic.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import com.luog.onlinemusic.entity.admin.AdminSong;
import com.luog.onlinemusic.entity.commons.AuthorDetail;
import com.luog.onlinemusic.entity.commons.CategoryDetail;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.commons.SongDetail;
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

	/**
	 * @author luog
	 */
	@Override
	public boolean create(AdminSong temp) {
		boolean result = false;
		try {
			Song song = new Song();

			song.setUploadedBy("luongld");
			song.setName(temp.getName());
			song.setLink(temp.getLink());
			song.setLyric(temp.getLyric());
			song.setStatus(true);
			song.setShow(temp.isShow());
			song.setUploadedTime(new Date());
			song.setVideo(temp.isVideo());
			song.setVideoPhoto(temp.getVideoPhoto());
			song.setListen(0);
			result = songDAO.create(song);
			result = createSongDetailForSong(song, temp.getSingers());
			result = createCategoryDetailForSong(song, temp.getCategories());
			result = createAuthorDetailForSong(song, temp.getAuthors());

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
	public boolean update(AdminSong temp) {
		boolean result = false;
		try {
			Song currentSong = songDAO.find(temp.getId());

			currentSong.setUploadedBy("luongld");
			currentSong.setName(temp.getName());
			currentSong.setLink(temp.getLink());
			currentSong.setLyric(temp.getLyric());
			currentSong.setStatus(true);
			currentSong.setShow(temp.isShow());
			currentSong.setUploadedTime(new Date());
			currentSong.setVideo(temp.isVideo());
			currentSong.setVideoPhoto(temp.getVideoPhoto());
			currentSong.setListen(0);
			result = songDAO.update(currentSong);
			List<Integer> singerIds = temp.getSingers();
			List<Integer> authorIds = temp.getAuthors();
			List<Integer> categoryIds = temp.getCategories();
			for (SongDetail currentSongDetail : currentSong.getSongDetails()) {
				if (singerIds.indexOf(currentSongDetail.getId()) == -1)
					result = songDetailDAO.delete(currentSongDetail);
			}
			for (AuthorDetail currentAuthorDetail : currentSong.getAuthorDetails()) {
				if (authorIds.indexOf(currentAuthorDetail.getId()) == -1)
					result = authorDetailDAO.delete(currentAuthorDetail);
			}
			for (CategoryDetail currentCategoryDetail : currentSong.getCategoryDetails()) {
				if (categoryIds.indexOf(currentCategoryDetail.getId()) == -1)
					result = categoryDetailDAO.delete(currentCategoryDetail);
			}
			result = createSongDetailForSong(currentSong, singerIds);
			result = createCategoryDetailForSong(currentSong, categoryIds);
			result = createAuthorDetailForSong(currentSong, authorIds);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean delete(AdminSong song) {
		return songDAO.delete(new Song());
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
	private boolean createSongDetailForSong(Song song, List<Integer> singerIds) {
		boolean result = false;
		try {
			for (int singerId : singerIds) {
				SongDetail songDetail = new SongDetail();
				songDetail.setSinger(singerDAO.find(singerId));
				songDetail.setSong(song);
				result = songDetailDAO.create(songDetail);
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
	private boolean createAuthorDetailForSong(Song song, List<Integer> authorIds) {
		boolean result = false;
		try {
			for (int authorId : authorIds) {
				AuthorDetail authorDetail = new AuthorDetail();
				authorDetail.setAuthor(authorDAO.find(authorId));
				authorDetail.setSong(song);
				result = authorDetailDAO.create(authorDetail);
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
	private boolean createCategoryDetailForSong(Song song, List<Integer> categoryIds) {
		boolean result = false;
		try {
			for (int categoryId : categoryIds) {
				CategoryDetail categoryDetail = new CategoryDetail();
				categoryDetail.setCategory(categoryDAO.find(categoryId));
				categoryDetail.setSong(song);
				result = categoryDetailDAO.create(categoryDetail);
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
	public Set<Song> randomSong(int limit, List<Object> conditions) {
		return songDAO.randomSong(limit, conditions);
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

}

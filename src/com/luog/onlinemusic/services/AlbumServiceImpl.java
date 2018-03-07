package com.luog.onlinemusic.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.AlbumDAO;
import com.luog.onlinemusic.dao.AlbumSingerDAO;
import com.luog.onlinemusic.dao.AlbumSongDAO;
import com.luog.onlinemusic.dao.SingerDAO;
import com.luog.onlinemusic.dao.SongDAO;
import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.AlbumSinger;
import com.luog.onlinemusic.entity.commons.AlbumSong;
import com.luog.onlinemusic.entity.commons.AuthorDetail;
import com.luog.onlinemusic.entity.commons.CategoryDetail;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.commons.SongDetail;
import com.luog.onlinemusic.entity.rest.AlbumEntity;
import com.luog.onlinemusic.entity.rest.SongEntity;

@Transactional
@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumDAO albumDAO;
	
	@Autowired
	private SongDAO songDAO;
	
	@Autowired
	private SingerDAO singerDAO;
	
	@Autowired
	private AlbumSongDAO albumSongDAO;
	
	@Autowired
	private AlbumSingerDAO albumSingerDAO;

	@Override
	public List<Album> findAll() {
		return albumDAO.findAll();
	}

	@Override
	public Album find(int id) {
		return albumDAO.find(id);
	}

	@Override
	public boolean create(AlbumEntity albumEntity) {
		boolean result = false;
		try {
			Album album = new Album();
			album.setName(albumEntity.getName());
			album.setPhoto(albumEntity.getPhoto());
			result = albumDAO.create(album);
			if (result)
				result = createAlbumSinger(albumEntity, album);
				result = createAlbumSong(albumEntity, album);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean update(AlbumEntity albumEntity) {
		boolean result = false;
		try {
			Album currentAlbum = albumDAO.find(albumEntity.getId());
			if (currentAlbum != null) {
				currentAlbum.setName(albumEntity.getName());
				result = albumDAO.update(currentAlbum);
				if (result) {
					if (albumEntity.getSingers() != null) {
						for (AlbumSinger albumSinger : currentAlbum.getAlbumSingers())
							result = albumSingerDAO.delete(albumSinger);
						result = createAlbumSinger(albumEntity, currentAlbum);
					}

					if (albumEntity.getSongs() != null) {
						for (AlbumSong albumSong : currentAlbum.getAlbumSongs())
							result = albumSongDAO.delete(albumSong);
						result = createAlbumSong(albumEntity, currentAlbum);
					}
				}
			} else
				result = false;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean delete(Album album) {
		return albumDAO.delete(album);
	}

	/**
	 * @author luog
	 */
	@Override
	public List<Album> getAlbums(Singer singer) {
		return albumDAO.getAlbums(singer);
	}
	
	private boolean createAlbumSong(AlbumEntity albumEntity, Album album) {
		boolean result = false;
		String[] songs = albumEntity.getSongs().split(",");
		for (int i = 0; i < songs.length; i++) {
			String[] songInfo = songs[i].split(":");
			int songId = Integer.parseInt(songInfo[0]);
			AlbumSong albumSong = new AlbumSong();
			albumSong.setAlbum(album);
			albumSong.setSong(songDAO.find(songId));
			result = albumSongDAO.create(albumSong);
		}
		return result;
	}
	
	private boolean createAlbumSinger(AlbumEntity albumEntity, Album album) {
		boolean result = false;
		String[] singers = albumEntity.getSingers().split(",");
		for (int i = 0; i < singers.length; i++) {
			String[] singerInfo = singers[i].split(":");
			int singerId = Integer.parseInt(singerInfo[0]);
			AlbumSinger albumSinger = new AlbumSinger();
			albumSinger.setAlbum(album);
			albumSinger.setSinger(singerDAO.find(singerId));
			result = albumSingerDAO.create(albumSinger);
		}
		return result;
	}

}

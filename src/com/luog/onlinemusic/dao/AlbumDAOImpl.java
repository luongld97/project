package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.rest.AlbumContainSong;
import com.luog.onlinemusic.entity.rest.AlbumOfSinger;
import com.luog.onlinemusic.entity.rest.SongInfo;

@Repository("albumDAO")
public class AlbumDAOImpl implements AlbumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> findAll() {
		List<Album> albums = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			albums = session.createQuery("FROM Album").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albums = new ArrayList<>();
		} finally {
			session.flush();
			session.close();
		}
		return albums;
	}

	@Override
	public Album find(int id) {
		Album album = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			album = (Album) session.get(Album.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			album = null;
		} finally {
			session.flush();
			session.close();
		}
		return album;
	}

	@Override
	public boolean create(Album album) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(album);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return result;
	}

	@Override
	public boolean update(Album album) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(album);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return result;
	}

	@Override
	public boolean delete(Album album) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(album);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<AlbumOfSinger> findAlbumSinger() {
		List<AlbumOfSinger> albumOfSingers = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT si.id as singerId, si.name as singerName, si.photo as singerPhoto, "
					+ "ab.id as albumId, ab.name as albumName "
					+ "FROM Singer si, Album ab, AlbumSinger abs "
					+ "WHERE abs.singer = si AND abs.album = ab "
					+ "ORDER BY ab.id DESC").setResultTransformer(Transformers.aliasToBean(AlbumOfSinger.class));
			albumOfSingers = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumOfSingers = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return albumOfSingers;
	}
	
	@SuppressWarnings("unchecked")
	public List<AlbumContainSong> findAlbumContainSong() {
		List<AlbumContainSong> albumContainSongs = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT so.id as songId, so.name as songName, ab.id as albumId, ab.name as albumName, "
					+ "so.link as linkSong, so.lyric as lyricSong, si.name as singerName, so.video as songVideo "
					+ "FROM Song so, Album ab, AlbumSong abs, AlbumSinger absi, Singer si "
					+ "WHERE abs.song = so AND abs.album = ab AND absi.singer = si AND absi.album = ab "
					+ "ORDER BY ab.id DESC").setResultTransformer(Transformers.aliasToBean(AlbumContainSong.class));
			albumContainSongs = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumContainSongs = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return albumContainSongs;
	}
	
	@SuppressWarnings("unchecked")
	public AlbumContainSong findSongByAlbum(int albumId) {
		AlbumContainSong albumContainSong = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT ab.id as albumId, "
					+ "ab.name as albumName, "
					+ "so.id as songId, "
					+ "so.name as songName, "
					+ "so.link as linkSong, "
					+ "so.video as songVideo, "
					+ "sg.name as singerName "
					+ "FROM Singer sg, Song so, Album ab, "
					+ "AlbumSinger abg, AlbumSong abs "
					+ "WHERE abg.singer = sg AND abg.album = ab "
					+ "AND abs.song = so AND abs.album = ab "
					+ "AND ab.id = :albumId").setResultTransformer(Transformers.aliasToBean(AlbumContainSong.class)).setParameter("albumId", albumId);
			albumContainSong = (AlbumContainSong) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumContainSong = new AlbumContainSong();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return albumContainSong;
	}
	
	@SuppressWarnings("unchecked")
	public List<AlbumContainSong> findSongByAlbums(int albumId) {
		List<AlbumContainSong> albumContainSongs = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			/*
			 * SELECT
			 * 
			 * FROM
			 * 	SONG,
			 * 	ALBUM,
			 * 	SINGER
			 * WHERE
			 * 	
			 */
			query = session.createQuery("SELECT ab.id as albumId, "
					+ "ab.name as albumName, "
					+ "so.id as songId, "
					+ "so.name as songName, "
					+ "so.link as linkSong, "
					+ "sg.name as singerName, "
					+ "so.lyric as lyricSong, "
					+ "so.video as songVideo "
					+ "FROM Singer sg, Song so, Album ab, "
					+ "AlbumSinger abg, AlbumSong abs "
					+ "WHERE abg.singer = sg AND abg.album = ab "
					+ "AND abs.song = so AND abs.album = ab "
					+ "AND ab.id = :albumId").setResultTransformer(Transformers.aliasToBean(AlbumContainSong.class)).setParameter("albumId", albumId);
			albumContainSongs = (List<AlbumContainSong>) query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumContainSongs = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return albumContainSongs;
	}

}

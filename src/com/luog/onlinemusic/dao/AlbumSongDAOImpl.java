package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.AlbumSong;
import com.luog.onlinemusic.entity.rest.AlbumSongEntity;

@Repository("albumSongDAO")
public class AlbumSongDAOImpl implements AlbumSongDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<AlbumSong> findAll() {
		List<AlbumSong> albumSongs = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			albumSongs = session.createQuery("FROM AlbumSong").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumSongs = new ArrayList<>();
		} finally {
			session.flush();
			session.close();
		}
		return albumSongs;
	}

	@Override
	public AlbumSong find(int id) {
		AlbumSong albumSong = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			albumSong = (AlbumSong) session.get(AlbumSong.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumSong = null;
		} finally {
			session.flush();
			session.close();
		}
		return albumSong;
	}

	@Override
	public boolean create(AlbumSong albumSong) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(albumSong);
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
	public boolean update(AlbumSong albumSong) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(albumSong);
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
	public boolean delete(AlbumSong albumSong) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(albumSong);
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
	public List<AlbumSongEntity> findAlbumSong() {
		List<AlbumSongEntity> albumSongEntities = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT so.id as songId, so.name as songName, ab.id as id, ab.name as name, "
					+ "so.link as link, so.lyric as lyric, si.name as singerName, so.video as isVideo "
					+ "FROM Song so, Album ab, AlbumSong abs, AlbumSinger absi, Singer si "
					+ "WHERE abs.song = so AND abs.album = ab AND absi.singer = si AND absi.album = ab "
					+ "ORDER BY ab.id DESC").setResultTransformer(Transformers.aliasToBean(AlbumSongEntity.class));
			albumSongEntities = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumSongEntities = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return albumSongEntities;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<AlbumSongEntity> getSongByAlbum(Album album) {
		List<AlbumSongEntity> albumSongEntities = null;
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
			query = session.createQuery("SELECT ab.id as id, "
					+ "ab.name as name, "
					+ "so.id as songId, "
					+ "so.name as songName, "
					+ "so.link as link, "
					+ "sg.name as singerName, "
					+ "so.lyric as lyric, "
					+ "so.video as isVideo "
					+ "FROM Singer sg, Song so, Album ab, "
					+ "AlbumSinger abg, AlbumSong abs "
					+ "WHERE abg.singer = sg AND abg.album = ab "
					+ "AND abs.song = so AND abs.album = ab "
					+ "AND ab = :album").setResultTransformer(Transformers.aliasToBean(AlbumSongEntity.class)).setParameter("album", album);
			albumSongEntities = (List<AlbumSongEntity>) query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumSongEntities = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return albumSongEntities;
	}

}

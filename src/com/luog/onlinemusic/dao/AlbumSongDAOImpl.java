package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luog.onlinemusic.entity.commons.AlbumSong;

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
}

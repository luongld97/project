package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luog.onlinemusic.entity.commons.AlbumSinger;

@Repository("albumSingerDAO")
public class AlbumSingerDAOImpl implements AlbumSingerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<AlbumSinger> findAll() {
		List<AlbumSinger> albumSingers = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			albumSingers = session.createQuery("FROM AlbumSinger").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumSingers = new ArrayList<>();
		} finally {
			session.flush();
			session.close();
		}
		return albumSingers;
	}

	@Override
	public AlbumSinger find(int id) {
		AlbumSinger albumSinger = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			albumSinger = (AlbumSinger) session.get(AlbumSinger.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			albumSinger = null;
		} finally {
			session.flush();
			session.close();
		}
		return albumSinger;
	}

	@Override
	public boolean create(AlbumSinger albumSinger) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(albumSinger);
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
	public boolean update(AlbumSinger albumSinger) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(albumSinger);
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
	public boolean delete(AlbumSinger albumSinger) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(albumSinger);
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

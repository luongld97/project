package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.entity.commons.Singer;

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

	/**
	 * @author luog
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Album> getAlbums(Singer singer) {
		List<Album> albums = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT al "
					+ "FROM "
					+ "Album al, "
					+ "AlbumSinger asg "
					+ "WHERE "
					+ "asg.album = al "
					+ "AND "
					+ "asg.singer = :singer");
			query.setParameter("singer", singer);
			albums = query.list();
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
	public boolean isExist(String name) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("FROM Album "
					+ "WHERE replace(name, ' ', '-') = :name");
			query.setParameter("name", name.replace(" ", "-"));
			Album currentAlbum = (Album) query.uniqueResult();
			result = currentAlbum != null;
			transaction.commit();
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

package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luog.onlinemusic.entity.commons.SongDetail;

@Repository("songDetailDAO")
public class SongDetailDAOImpl implements SongDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<SongDetail> findAll() {
		List<SongDetail> songDetails = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			songDetails = session.createQuery("FROM SongDetail").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songDetails = new ArrayList<>();
		} finally {
			session.flush();
			session.close();
		}
		return songDetails;
	}

	@Override
	public SongDetail find(int id) {
		SongDetail songDetail = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			songDetail = (SongDetail) session.get(SongDetail.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songDetail = null;
		} finally {
			session.flush();
			session.close();
		}
		return songDetail;
	}

	@Override
	public boolean create(SongDetail songDetail) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(songDetail);
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
	public boolean update(SongDetail songDetail) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(songDetail);
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
	public boolean delete(SongDetail songDetail) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(songDetail);
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
	public int isExist(SongDetail songDetail) {
		int songDetailID = -1;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		SongDetail currentSongDetail = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("FROM SongDetail "
					+ "WHERE singer = :singer "
					+ "AND song = :song");
			query.setParameter("singer", songDetail.getSinger());
			query.setParameter("song", songDetail.getSong());
			currentSongDetail = (SongDetail) query.uniqueResult();
			transaction.commit();
			songDetailID = currentSongDetail.getId();
		} catch (Exception e) {
			e.printStackTrace();
			songDetailID = -1;
		} finally {
			session.flush();
			session.close();
		}

		return songDetailID;
	}

}

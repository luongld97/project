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

import com.luog.onlinemusic.entity.commons.Singer;

@Repository("singerDAO")
public class SingerDAOImpl implements SingerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Singer> findAll() {
		List<Singer> singers = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("FROM Singer");
			singers = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			singers = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return singers;
	}

	@Override
	public Singer find(int id) {
		Singer singer = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			singer = (Singer) session.get(Singer.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			singer = null;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return singer;
	}

	@Override
	public boolean create(Singer singer) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(singer);
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
	public boolean update(Singer singer) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(singer);
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
	public boolean delete(Singer singer) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(singer);
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

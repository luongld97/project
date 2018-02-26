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

import com.luog.onlinemusic.entity.commons.Author;

@Repository("authorDAO")
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> findAll() {
		List<Author> authors = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("FROM Author");
			authors = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			authors = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return authors;
	}

	@Override
	public Author find(int id) {
		Author author = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			author = (Author) session.get(Author.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			author = null;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return author;
	}

	@Override
	public boolean create(Author author) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(author);
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
	public boolean update(Author author) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(author);
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
	public boolean delete(Author author) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(author);
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

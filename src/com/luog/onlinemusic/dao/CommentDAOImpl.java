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

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Comment;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.CommentEntity;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll() {
		List<Comment> comments = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("FROM Comment");
			comments = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			comments = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return comments;
	}
	
	@Override
	public Comment find(int id) {
		Comment comment = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			comment = (Comment) session.get(Comment.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			comment = null;
		} finally {
			session.flush();
			session.close();
		}
		return comment;
	}

	@Override
	public boolean create(Comment comment) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(comment);
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
	public boolean update(Comment comment) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(comment);
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
	public boolean delete(Comment comment) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(comment);
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
	/*
	 * (non-Javadoc)
	 * @see com.luog.onlinemusic.dao.CommentDAO#getComments(com.luog.onlinemusic.entity.commons.Song)
	 * This method will return List<CommentEntity>
	 * @parameter Song song
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentEntity> getComments(Song song) {
		List<CommentEntity> commentEntities = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT c.id as id, "
					+ "c.account.username as username, "
					+ "str(c.created) as created, "
					+ "c.song.id as songId, "
					+ "c.content as content ,"
					+ "c.account.photo as userPhoto "
					+ "FROM Comment c "
					+ "WHERE c.song = :song");
			query.setParameter("song", song);
			query.setResultTransformer(Transformers.aliasToBean(CommentEntity.class));
			commentEntities = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			commentEntities = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return commentEntities;
	}

	/**
	 * @author luog
	 */
	/*
	 * (non-Javadoc)
	 * @see com.luog.onlinemusic.dao.CommentDAO#getComments(com.luog.onlinemusic.entity.commons.Song)
	 * This method will return List<CommentEntity>
	 * @parameter Account account
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentEntity> getComments(Account account) {
		List<CommentEntity> commentEntities = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT c.id as id, "
					+ "c.account.username as username, "
					+ "str(c.created) as created, "
					+ "c.song.id as songId, "
					+ "c.content as content, "
					+ "c.account.photo as userPhoto "
					+ "FROM Comment c "
					+ "WHERE c.account = :account");
			query.setParameter("account", account);
			query.setResultTransformer(Transformers.aliasToBean(CommentEntity.class));
			commentEntities = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			commentEntities = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return commentEntities;
	}
	
	
}

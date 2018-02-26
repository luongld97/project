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
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.rest.PlayListEntity;

@Repository("playListDAO")
public class PlayListDAOImpl implements PlayListDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayList> findAll() {
		List<PlayList> playLists = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("FROM PlayList");
			playLists = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			playLists = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return playLists;
	}

	@Override
	public PlayList find(int id) {
		PlayList playList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			playList = (PlayList) session.get(PlayList.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			playList = null;
		} finally {
			session.flush();
			session.close();
		}
		return playList;
	}

	@Override
	public boolean create(PlayList playList) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(playList);
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
	public boolean update(PlayList playList) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(playList);
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
	public boolean delete(PlayList playList) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(playList);
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
	@Override
	@SuppressWarnings("unchecked")
	public List<PlayList> getUserPlayList(Account account) {
		List<PlayList> playLists = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM PlayList "
					+ "WHERE account = :account");
			query.setParameter("account", account);
			playLists = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			playLists = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return playLists;
	}
	
	@SuppressWarnings("unchecked")
	public List<PlayListEntity> getSongPlayList(PlayList playList) {
		List<PlayListEntity> playListEntities = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT pl.id as playListId, pl.name as playListName, so.id as songId, "
										+ "so.name as songName, so.lyric as songLyric, so.link as songLink "
										+ "FROM PlayList pl, Song so, PlayListDetail pld "
										+ "WHERE pld.playList = pl AND pld.song = so AND pl = :playList").setParameter("playList", playList)
						.setResultTransformer(Transformers.aliasToBean(PlayListEntity.class));
			playListEntities = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			playListEntities = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return playListEntities;
	}

}

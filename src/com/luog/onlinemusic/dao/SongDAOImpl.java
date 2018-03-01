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

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;

@Repository("songDAO")
public class SongDAOImpl implements SongDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Song> findAll() {
		List<Song> songs = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("FROM Song");
			songs = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songs = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songs;
	}

	@Override
	public Song find(int id) {
		Song song = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			song = (Song) session.get(Song.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			song = null;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return song;
	}

	@Override
	public boolean create(Song song) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(song);
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
	public boolean update(Song song) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(song);
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
	public boolean delete(Song song) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(song);
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
	public List<SongInfo> findSongInfo() {
		List<SongInfo> songInfos = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session
					.createQuery("SELECT si.id as singerId, si.name as singerName, si.photo as singerPhoto, "
							+ "so.id as id, so.name as name, " + "so.link as link, "
							+ "so.lyric as lyric, " + "so.video as isVideo " + "FROM Singer si, Song so, SongDetail sd "
							+ "WHERE sd.singer = si AND sd.song = so " + "ORDER BY so.id DESC")
					.setResultTransformer(Transformers.aliasToBean(SongInfo.class));
			songInfos = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songInfos = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songInfos;
	}
	
	@SuppressWarnings("unchecked")
	public List<SongInfo> findMVSongInfo() {
		List<SongInfo> songInfos = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT si.id as singerId, si.name as singerName, si.photo as singerPhoto, "
					+ "so.id as id, so.name as name, " + "so.link as link, " + "so.lyric as lyric, "
					+ "so.video as isVideo " + "FROM Singer si, Song so, SongDetail sd "
					+ "WHERE sd.singer = si AND sd.song = so AND so.video = true " + "ORDER BY so.id DESC")
					.setResultTransformer(Transformers.aliasToBean(SongInfo.class));
			songInfos = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songInfos = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songInfos;
	}

	
	/**
	 * @author luog
	 */
	@Override
	public SongEntity getSongEntity(int id) {

		SongEntity songEntity = null;
		Session session = null;
		Transaction transaction = null;
		String hql = "SELECT s.id as id, " + "s.name as name, " + "s.link as link, " + "s.listen as listen, "
				+ "s.show as show, " + "s.status as status, " + "s.video as video, " + "s.videoPhoto as videoPhoto, "
				+ "str(s.uploadedTime) as uploadedTime, " + "s.uploadedBy as uploadedBy " + "FROM Song s "
				+ "WHERE id = :id";
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setResultTransformer(Transformers.aliasToBean(SongEntity.class));
			songEntity = (SongEntity) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songEntity = null;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songEntity;
	}

	@Override
	public List<Song> randomSong(int limit) {
		List<Song> songs = null;
		Session session = null;
		Transaction transaction = null;
		try {
			songs = new ArrayList<>();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			while (songs.size() < limit) {
				Song song = (Song) session.createQuery("FROM Song ORDER BY rand()").setMaxResults(1).list().get(0);
				if (!songs.contains(song))
					songs.add(song);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songs = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songs;
	}

	/**
	 * @author luog
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SongEntity> findSongEntities(String keyWord) {

		List<SongEntity> songEntities = null;
		Session session = null;
		Transaction transaction = null;
		String hql = "SELECT s.id as id, " + "s.name as name, " + "s.link as link, " + "s.listen as listen, "
				+ "s.show as show, " + "s.status as status, " + "s.video as video, " + "s.videoPhoto as videoPhoto, "
				+ "str(s.uploadedTime) as uploadedTime, " + "s.uploadedBy as uploadedBy " + "FROM Song s "
				+ "WHERE replace(s.name, ' ', '-') like :name";
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("name", "%" + keyWord.replace(" ", "-") + "%");
			System.out.println(keyWord.replace(" ", "-"));
			query.setResultTransformer(Transformers.aliasToBean(SongEntity.class));
			songEntities = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songEntities = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songEntities;
	}

	/**
	 * @author luog
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Song> getTopSongs(Singer singer, Integer limit) {
		List<Song> songs = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("SELECT so "
					+ "FROM Song so, "
					+ "SongDetail sd "
					+ "WHERE sd.song = so "
					+ "AND sd.singer = :singer "
					+ "ORDER BY so.listen DESC");
			query.setParameter("singer", singer);
			if (limit != null)
				query.setMaxResults(limit);
			songs = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songs = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songs;
	}


}

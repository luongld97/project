package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
							+ "WHERE sd.singer = si AND sd.song = so " + "ORDER BY so.id DESC");
			query = session.createQuery("SELECT si.id as singerId, si.name as singerName, si.photo as singerPhoto, "
					+ "so.id as songId, so.name as songName, " + "so.link as linkSong, " + "so.lyric as lyricSong, "
					+ "so.video as songVideo " + "FROM Singer si, Song so, SongDetail sd "
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

	/**
	 * @author luog
	 */
	@SuppressWarnings("unchecked")
	public Set<Song> randomSong(int limit, List<Object> conditions) {
		Set<Song> songs = null;
		Session session = null;
		Transaction transaction = null;
		String hql = createHQLString(conditions);
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			for (Object object : conditions) {
				String objectClass = object.getClass().getSimpleName();
				String className = "";
				if (objectClass.startsWith("Author"))
					className = "Author";
				if (objectClass.startsWith("Category"))
					className = "Category";
				if (objectClass.startsWith("Singer"))
					className = "Singer";
				query.setParameter(className.toLowerCase(), object);
			}
			query.setMaxResults(limit);
			songs = new HashSet<Song>(query.list());
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			songs = new HashSet<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return songs;
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

	public String createHQLString(List<Object> conditions) {
		String hql = "SELECT song from Song song";
		List<String> classNames = new ArrayList<>();
		for (Object object : conditions) {
			String className = object.getClass().getSimpleName();
			if (className.startsWith("Author"))
				classNames.add("Author");
			if (className.startsWith("Category"))
				classNames.add("Category");
			if (className.startsWith("Singer"))
				classNames.add("Singer");
		}

		for (String className : classNames) {
			hql += ", " + className + " " + className.toLowerCase();
			if (className.equals("Author"))
				hql += ", AuthorDetail authorDetail";
			if (className.equals("Singer"))
				hql += ", SongDetail songDetail";
			if (className.equals("Category"))
				hql += ", CategoryDetail categoryDetail";
		}
		hql += " WHERE ";
		for (String className : classNames) {
			String classVar = "";
			if (className.equals("Author"))
				classVar = "authorDetail";
			if (className.equals("Category"))
				classVar = "categoryDetail";
			if (className.equals("Singer"))
				classVar = "songDetail";
			hql += classVar + ".song = song AND ";
		}
		hql += "(";
		for (String className : classNames) {
			String classVar = "";
			if (className.equals("Author"))
				classVar = "authorDetail";
			if (className.equals("Category"))
				classVar = "categoryDetail";
			if (className.equals("Singer"))
				classVar = "songDetail";
			hql += classVar + "." + className.toLowerCase() + " = :" + className.toLowerCase();
			if (classNames.indexOf(className) < classNames.size() - 1)
				hql += " OR ";
		}
		hql += ") ORDER BY rand()";
		return conditions.size() > 0 ? hql : "FROM Song ORDER BY rand()";
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

}

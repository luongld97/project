package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.Song;

@Repository("chartDAO")
public class ChartDAOImpl implements ChartDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Chart> findAll() {
		List<Chart> charts = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("FROM Chart");
			charts = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			charts = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return charts;
	}

	@Override
	public Chart find(int id) {
		Chart chart = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			chart = (Chart) session.get(Chart.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			chart = null;
		} finally {
			session.flush();
			session.close();
		}
		return chart;
	}

	@Override
	public boolean create(Chart chart) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(chart);
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
	public boolean update(Chart chart) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(chart);
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
	public boolean delete(Chart chart) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(chart);
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
	public Chart findChart(Song song, Date currentDate) {
		Chart chart = null;
		Session session = null;
		Transaction transaction = null;
		LocalDate localDate = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Query query = session
					.createQuery("FROM Chart WHERE song = :song AND month(date) = :month AND year(date) = :year");
			query.setParameter("song", song);
			query.setParameter("month", localDate.getMonthValue());
			query.setParameter("year", localDate.getYear());
			chart = (Chart) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			chart = null;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return chart;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chart> getChartsByMonth(Date currentDate, Integer limit) {
		List<Chart> charts = null;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		LocalDate localDate = null;
		try {
			localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery(
					"FROM Chart " + "WHERE month(date) = :month " + "AND year(date) = :year " + "ORDER BY listen DESC");
			query.setParameter("month", localDate.getMonthValue());
			query.setParameter("year", localDate.getYear());
			if (limit != null)
				query.setMaxResults(limit);
			charts = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			charts = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return charts;
	}
}
package com.luog.onlinemusic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luog.onlinemusic.entity.commons.Role;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		List<Role> roles = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			roles = session.createQuery("FROM Role").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			roles = new ArrayList<>();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return roles;
	}

	@Override
	public Role find(int id) {
		Role role = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			role = (Role) session.get(Role.class, (Serializable) id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			role = null;
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.flush();
			session.close();
		}
		return role;
	}
	
	@Override
	public boolean create(Role role) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(role);
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
	public boolean update(Role role) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(role);
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
	public boolean delete(Role role) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(role);
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

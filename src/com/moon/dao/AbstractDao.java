package com.moon.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao<E extends Serializable> {

	protected final Log logger = LogFactory.getLog(getClass());

	private Class<E> entityClass;

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected AbstractDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public E get(Serializable id) {
		logger.info("get before....");
		Object obj = getCurrentSession().get(entityClass, id);
		logger.info("get after...");

		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		}
		return (E) obj;
	}

	@SuppressWarnings("unchecked")
	public List<E> get(String hql, Object[] args) {
		Query query = getCurrentSession().createQuery(hql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		return query.list();
	}

	public List<?> load(String hql) {
		return (List<?>) getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public E load(Serializable id) {
		logger.info("load before....");
		Object obj = getCurrentSession().load(entityClass, id);
		logger.info("load after...");

		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		}
		return (E) obj;
	}

	public void save(E e) {
		getCurrentSession().save(e);
	}

	public void delete(E e) {
		getCurrentSession().delete(e);
	}

	public Class<E> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

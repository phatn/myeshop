package com.myeshop.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.util.ReflectionUtils;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public abstract class AbstractGenericDao<T> implements GenericDao<T> {
	
	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> domainClass;
	
	@SuppressWarnings("unchecked")
	public Class<T> getDomainClass() {
		if(domainClass == null) {
			ParameterizedType thisType = (ParameterizedType)getClass().getGenericSuperclass();
			this.domainClass = (Class<T>)thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	private String getDomainClassName() {
		return getDomainClass().getName();
	}
	
	public void setDomainClass(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	@Override
	public void create(T t) {
		Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateCreated",
				new Class[] {Date.class});
		if(method != null) {
			try {
				method.invoke(t, new Date());
			} catch(Exception e) {}
		}
		getEntityManager().persist(t);
	}
	
	@Override
	public T get(Serializable id) {
		return entityManager.find(getDomainClass(), id);
	}
	
	@Override
	public List<T> getAll() {
		return getAll(null, null);
	}
	
	@Override
	public List<T> getAll(Integer limit, Integer offset) {
		TypedQuery<T> query = getEntityManager().createQuery("from " + getDomainClassName(), getDomainClass());
		if(limit != null) {
			query.setMaxResults(limit);
		}
		
		if(offset != null) {
			query.setFirstResult(offset);
		}
		return query.getResultList();
	}
	
	@Override
	public void delete(T t) {
		entityManager.remove(t);
	}
	
	@Override
	public void deleteById(Serializable id) {
		delete(get(id));
	}
	
	@Override
	public void update(T t) {
		//if(entityManager.contains(t)) {
			Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateModified",
					new Class[] {Date.class});
			if(method != null) {
				try {
					method.invoke(t, new Date());
				} catch(Exception e) {}
			}
			entityManager.merge(t);
		//}
	}
	
	@Override
	public void deleteAll() {
		entityManager.createQuery("delete from " + getDomainClassName()).executeUpdate();
	}
	
	@Override
	public long count() {
		return (Long)getEntityManager().createQuery("select count(*) from " + getDomainClassName()).getSingleResult();
	}
	
	@Override
	public boolean exists(Serializable id) {
		return get(id) != null;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}

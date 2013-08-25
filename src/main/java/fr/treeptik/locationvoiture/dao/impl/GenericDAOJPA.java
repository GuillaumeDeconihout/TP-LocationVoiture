package fr.treeptik.locationvoiture.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.treeptik.locationvoiture.dao.GenericDAO;
import fr.treeptik.locationvoiture.exception.DAOException;

public class GenericDAOJPA<T,PK> implements GenericDAO<T, PK>{
	
	@PersistenceContext
	protected EntityManager entitymanager;

	private Class<T> type;
	
	

	public GenericDAOJPA(Class<T> type) {
		this.type = type;
	}

	@Override
	public T save(T entity) {
		entitymanager.persist(entity);
		return entity;
	}

	@Override
	public T findById(PK id) {
		return entitymanager.find(type, id);
	}

	@Override
	public void remove(PK id) {		
		Query query = entitymanager.createQuery("delete from "+ type.getSimpleName() + " o where o.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public List<T> findAll() {
		return entitymanager.createQuery("select o from "+ type.getSimpleName() + " o",type).getResultList();
	}

	@Override
	public T update(T entity) throws DAOException {
		entitymanager.merge(entity);
		return entity;
	}

	
	
}

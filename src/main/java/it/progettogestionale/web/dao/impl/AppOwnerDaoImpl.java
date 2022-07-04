package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import it.progettogestionale.web.dao.AppOwnerDao;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;

public class AppOwnerDaoImpl implements AppOwnerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public AppOwner getById(int i) {
		return  em.find(AppOwner.class, i);
	}

	@Override
	@Transactional
	public void add(AppOwner a) {
		em.persist(a);		
	}

	@Override
	@Transactional
	public void update(AppOwner a) {
		em.merge(a);
	}

	@Override
	@Transactional
	public void delete(int id) {
		em.remove(getById(id));		
	}
}

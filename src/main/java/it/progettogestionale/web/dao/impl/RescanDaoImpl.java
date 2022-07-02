package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import it.progettogestionale.web.dao.RescanDao;
import it.progettogestionale.web.model.Rescan;

public class RescanDaoImpl implements RescanDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Rescan getById(int id) {
		return em.find(Rescan.class, id);
	}

	@Override
	@Transactional
	public void add(Rescan r) {
		em.persist(r);
	}

	@Override
	@Transactional
	public void update(Rescan r) {
		em.merge(r);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Rescan r = getById(id);
		em.remove(r);
	}
}

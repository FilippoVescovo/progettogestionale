package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import it.progettogestionale.web.dao.LogFileRescanDao;
import it.progettogestionale.web.model.LogFileRescan;

public class LogFileRescanDaoImpl implements LogFileRescanDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public LogFileRescan getById(int id) {
		return em.find(LogFileRescan.class, id);
	}

	@Override
	@Transactional
	public void add(LogFileRescan lfr) {
		em.persist(lfr);
	}

	@Override
	@Transactional
	public void update(LogFileRescan lfr) {
		em.merge(lfr);
	}

	@Override
	@Transactional
	public void delete(int id) {
		LogFileRescan lfr = getById(id);
		em.remove(lfr);
	}
}

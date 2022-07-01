package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.LogFileRescanDao;
import it.progettogestionale.web.model.LogFileRescan;

public class LogFileRescanDaoImpl implements LogFileRescanDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public LogFileRescan getById(int id) {
		return em.find(LogFileRescan.class, id);
	}
}

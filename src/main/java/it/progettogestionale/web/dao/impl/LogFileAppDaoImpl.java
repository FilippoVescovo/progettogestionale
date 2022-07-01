package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.LogFileAppDao;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.LogFileApp;

public class LogFileAppDaoImpl implements LogFileAppDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public LogFileApp getById(int i) {
		return  em.find(LogFileApp.class, i);
	}
}

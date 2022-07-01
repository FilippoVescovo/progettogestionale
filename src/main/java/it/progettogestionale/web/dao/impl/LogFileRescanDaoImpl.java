package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.LogFileRescanDao;

public class LogFileRescanDaoImpl implements LogFileRescanDao {
	
	@PersistenceContext
	private EntityManager em;
}

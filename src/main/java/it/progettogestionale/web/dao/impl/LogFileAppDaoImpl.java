package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.LogFileAppDao;

public class LogFileAppDaoImpl implements LogFileAppDao {

	@PersistenceContext
	private EntityManager em;
}

package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.RescanDao;

public class RescanDaoImpl implements RescanDao {
	
	@PersistenceContext
	private EntityManager em;
}

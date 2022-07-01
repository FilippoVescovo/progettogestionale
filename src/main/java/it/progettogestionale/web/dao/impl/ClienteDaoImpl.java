package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.ClienteDao;

public class ClienteDaoImpl implements ClienteDao {
	
	@PersistenceContext
	private EntityManager em;
}

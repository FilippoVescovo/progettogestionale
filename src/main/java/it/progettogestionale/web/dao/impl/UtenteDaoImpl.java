package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.UtenteDao;

public class UtenteDaoImpl implements UtenteDao {
	
	@PersistenceContext
	private EntityManager em;
}

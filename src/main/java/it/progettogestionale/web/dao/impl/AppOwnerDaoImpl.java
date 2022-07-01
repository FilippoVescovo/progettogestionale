package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.AppOwnerDao;

public class AppOwnerDaoImpl implements AppOwnerDao {

	@PersistenceContext
	private EntityManager em;
}

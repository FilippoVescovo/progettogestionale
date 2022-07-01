package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.AppOwnerDao;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;

public class AppOwnerDaoImpl implements AppOwnerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public AppOwner getById(int i) {
		return  em.find(AppOwner.class, i);
	}
}

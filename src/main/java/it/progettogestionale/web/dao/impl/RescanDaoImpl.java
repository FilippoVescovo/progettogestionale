package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.RescanDao;
import it.progettogestionale.web.model.Rescan;

public class RescanDaoImpl implements RescanDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Rescan getById(int id) {
		return em.find(Rescan.class, id);
	}
}

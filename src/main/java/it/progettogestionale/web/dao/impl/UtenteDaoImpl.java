package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.web.dao.UtenteDao;
import it.progettogestionale.web.model.Utente;

public class UtenteDaoImpl implements UtenteDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Utente getById(int id) {
		return em.find(Utente.class, id);
	}
}

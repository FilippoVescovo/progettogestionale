package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import it.progettogestionale.web.dao.UtenteDao;
import it.progettogestionale.web.model.Utente;

public class UtenteDaoImpl implements UtenteDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Utente getById(int id) {
		return em.find(Utente.class, id);
	}

	@Override
	@Transactional
	public void add(Utente u) {
		em.persist(u);
	}

	@Override
	@Transactional
	public void update(Utente u) {
		em.merge(u);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Utente u = getById(id);
		em.remove(u);
	}
}

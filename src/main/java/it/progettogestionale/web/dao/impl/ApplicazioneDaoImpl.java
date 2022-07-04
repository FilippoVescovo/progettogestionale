package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import it.progettogestionale.web.dao.ApplicazioneDao;
import it.progettogestionale.web.model.Applicazione;

public class ApplicazioneDaoImpl implements ApplicazioneDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Applicazione getById(int i) {
		return  em.find(Applicazione.class, i);
	}

	@Override
	@Transactional
	public void add(Applicazione a) {
		em.persist(a);		
	}

	@Override
	@Transactional
	public void update(Applicazione a) {
		em.merge(a);		
	}

	@Override
	@Transactional
	public void delete(int id) {
		em.remove(getById(id));
	}

}

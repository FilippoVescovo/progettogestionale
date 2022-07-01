package it.progettogestionale.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.progettogestionale.dao.ApplicazioneDao;
import it.progettogestionale.web.model.Applicazione;

public class ApplicazioneDaoImpl implements ApplicazioneDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Applicazione getById(int i) {
		return  em.find(Applicazione.class, i);
	}

}

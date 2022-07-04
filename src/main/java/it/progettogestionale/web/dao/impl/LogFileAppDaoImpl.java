package it.progettogestionale.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.LogFileAppDao;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;

public class LogFileAppDaoImpl implements LogFileAppDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public LogFileApp getById(int i) {
		return  em.find(LogFileApp.class, i);
	}

	@Override
	@Transactional
	public void add(LogFileApp a) {
		em.persist(a);
	}

	@Override
	@Transactional
	public void update(LogFileApp a) {
		em.merge(a);
	}

	@Override
	@Transactional
	public void delete(int id) {
		em.remove(getById(id));
	}

	
}

package it.progettogestionale.web.dao;

import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;

public interface LogFileAppDao {
	public LogFileApp getById(int i);
	public void add(LogFileApp a);
	public void update(LogFileApp a);
	public void delete(int id);
}

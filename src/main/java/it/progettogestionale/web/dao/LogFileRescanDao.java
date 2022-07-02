package it.progettogestionale.web.dao;

import it.progettogestionale.web.model.LogFileRescan;

public interface LogFileRescanDao {
	public LogFileRescan getById(int id);
	public void add(LogFileRescan lfr);
	public void update(LogFileRescan lfr);
	public void delete(int id);
}

package it.progettogestionale.web.dao;

import it.progettogestionale.web.model.Rescan;

public interface RescanDao {
	public Rescan getById(int id);
	public void add(Rescan r);
	public void update(Rescan r);
	public void delete(int id);
}

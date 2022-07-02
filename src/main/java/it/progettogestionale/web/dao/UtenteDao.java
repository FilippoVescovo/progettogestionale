package it.progettogestionale.web.dao;

import it.progettogestionale.web.model.Utente;

public interface UtenteDao {
	public Utente getById(int id);
	public void add(Utente u);
	public void update(Utente u);
	public void delete(int id);
}

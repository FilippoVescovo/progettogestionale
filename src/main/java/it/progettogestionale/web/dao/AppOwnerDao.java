package it.progettogestionale.web.dao;

import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;

public interface AppOwnerDao {

	public AppOwner getById(int i);
	public void add(AppOwner a);
	public void update(AppOwner a);
	public void delete(int id);
}  

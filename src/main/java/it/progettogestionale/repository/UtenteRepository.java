package it.progettogestionale.repository;

import org.springframework.data.repository.CrudRepository;

import it.progettogestionale.web.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Integer>{
	public Utente findByEmail(String email);

}

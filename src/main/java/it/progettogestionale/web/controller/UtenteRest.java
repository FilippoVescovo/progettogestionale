package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.repository.UteneteRepository;
import it.progettogestionale.web.model.Utente;

@RestController
@RequestMapping("/utenterest")
public class UtenteRest {
	
	@Autowired
	private UteneteRepository utenteRepo;
	
	@GetMapping("/utente/{id}")
	public Utente getById(@PathVariable("id") Integer id) {
		return utenteRepo.findById(id).get();
	}
	
	@GetMapping("/utenti")
	public Iterable<Utente> getAll(){
		return utenteRepo.findAll();
	}
}

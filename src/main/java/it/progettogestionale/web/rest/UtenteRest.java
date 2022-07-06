package it.progettogestionale.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.dto.response.GetUtentiResponseDTO;
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
	public ResponseEntity<GetUtentiResponseDTO> getAll(){
		Iterable<Utente> i=utenteRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetUtentiResponseDTO(i));
	}
}

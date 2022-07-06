package it.progettogestionale.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.dto.response.GetUtenteResponseDTO;
import it.progettogestionale.dto.response.GetUtentiResponseDTO;
import it.progettogestionale.repository.UteneteRepository;
import it.progettogestionale.web.model.Utente;

@RestController
@RequestMapping("/utenterest")
public class UtenteRest {
	
	@Autowired
	private UteneteRepository utenteRepo;
	
//	@GetMapping("/utente/{id}")
//	public Utente getById(@PathVariable("id") Integer id) {
//		return utenteRepo.findById(id).get();
//	}
	
	@GetMapping("/utenti")
	public ResponseEntity<GetUtentiResponseDTO> getAll(){
		Iterable<Utente> i=utenteRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetUtentiResponseDTO(i));
	}
	
	@GetMapping("/utente/{id}")
	public ResponseEntity<GetUtenteResponseDTO> getById(@PathVariable("id") Integer id){
		Iterable<Utente> utenti = utenteRepo.findAll();
		List<Utente> listaUtenti = new ArrayList<>();
		for(Utente u : utenti) {
			if(u.getIdUtente().equals(id)) {
				listaUtenti.add(u);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(new GetUtenteResponseDTO(listaUtenti));
	}
	
	@PostMapping("/save") //il save aggiunge e modifica
	public Utente save(@RequestBody Utente u) {
		return utenteRepo.save(u);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if(utenteRepo.existsById(id)) {
			Utente u = utenteRepo.findById(id).get();
			utenteRepo.delete(u);
		}else {
			System.out.println("id scelto non presente nel db!");
		}
	}
}
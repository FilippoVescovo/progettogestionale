package it.progettogestionale.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.dto.generic.UtenteDTO;
import it.progettogestionale.repository.UtenteRepository;
import it.progettogestionale.web.model.Utente;

@RestController
@RequestMapping("/utenterest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UtenteRest {
	
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	
	@Autowired
	private UtenteRepository utenteRepo;
	
//	@GetMapping("/getallutenti")
//	public ResponseEntity<GetUtentiResponseDTO> getAllUtenti(){
//		Iterable<Utente> i=utenteRepo.findAll();
//		return ResponseEntity.status(HttpStatus.OK).body(new GetUtentiResponseDTO(i));
//
//		metodo che torna un json contenente una lista di json
//	}
	
	@GetMapping("/getallutenti")
	public ResponseEntity<List<UtenteDTO>> getAllUtenti(){
		Iterable<Utente> i=utenteRepo.findAll();
		List<UtenteDTO> ldto = new ArrayList<>();
		for(Utente u : i) {
			ldto.add(new UtenteDTO(u));
		}
		return ResponseEntity.status(HttpStatus.OK).body(ldto);
	}
	
//	@GetMapping("/utente/{id}")
//	public ResponseEntity<GetUtenteResponseDTO> getById(@PathVariable("id") Integer id){
//		Iterable<Utente> utenti = utenteRepo.findAll();
//		List<Utente> listaUtenti = new ArrayList<>();
//		for(Utente u : utenti) {
//			if(u.getIdUtente().equals(id)) {
//				listaUtenti.add(u);
//			}
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(new GetUtenteResponseDTO(listaUtenti));
//		
//		metodo sbagliato per l'eliminazione tramite id ma che potrebbe tornare utile se si volessero eliminare più utenti insieme selezionado il parametro di riferimento
//	}
	
	@PostMapping("/save") //il save aggiunge e modifica
	public ResponseEntity<Utente> save(@RequestBody Utente u) {
		Utente alfonso = utenteRepo.findByEmail(u.getEmail());
		try {
			if(alfonso.getEmail().equals(u.getEmail())) return ResponseEntity.status(HttpStatus.IM_USED).build();
		}catch(NullPointerException e) {
			u.setEmail("emaildidefault@mail.it");
		}
		return ResponseEntity.ok(utenteRepo.save(u));
//		return utenteRepo.save(u);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if(utenteRepo.existsById(id)) {
			Utente u = utenteRepo.findById(id).get();
			utenteRepo.delete(u);
		}else {
			System.out.println("id scelto non presente nel db!");
			/*nell'else ci andrà il reindirizzamento alla pagina dell'id 
			non trovato. Per adesso stampiamo solo un messaggio in 
			console.*/
		}
	}
	
	@GetMapping("/getutentebyid/{id}")
	public UtenteDTO getUtenteById(@PathVariable("id") Integer id){
		return new UtenteDTO(utenteRepo.findById(id).get());
	}
}

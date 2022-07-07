package it.progettogestionale.web.rest;

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
import it.progettogestionale.dto.response.GetUtentiResponseDTO;
import it.progettogestionale.repository.UteneteRepository;
import it.progettogestionale.web.model.Utente;

@RestController
@RequestMapping("/utenterest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UtenteRest {
	
	@Autowired
	private UteneteRepository utenteRepo;
	
//	@GetMapping("/utente/{id}")
//	public Utente getById(@PathVariable("id") Integer id) {
//		return utenteRepo.findById(id).get();
//	}
	
	@GetMapping("/getallutenti")
	public ResponseEntity<GetUtentiResponseDTO> getAllUtenti(){
		Iterable<Utente> i=utenteRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetUtentiResponseDTO(i));
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
//		metodo sbagliato per l'eliminazione tramite id ma che potrebbe tornare utile se si volessero eliminare pi� utenti insieme selezionado il parametro di riferimento
//	}
	
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
			/*nell'else ci andr� il reindirizzamento alla pagina dell'id 
			non trovato. Per adesso stampiamo solo un messaggio in 
			console.*/
		}
	}
	
	@GetMapping("/getutentebyid/{id}")
	public UtenteDTO getUtenteById(@PathVariable("id") Integer id){
		return new UtenteDTO(utenteRepo.findById(id).get());
	}
}

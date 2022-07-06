package it.progettogestionale.web.rest;

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

import it.progettogestionale.dto.generic.ApplicazioneDTO;
import it.progettogestionale.dto.response.GetApplicazioneResponseDTO;
import it.progettogestionale.dto.response.GetLogFileAppResposeDTO;
import it.progettogestionale.dto.response.GetUtentiResponseDTO;
import it.progettogestionale.repository.ApplicazioneRepository;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.Rescan;
import it.progettogestionale.web.model.Utente;

@RestController
@RequestMapping("/applicazionerest")
public class ApplicazioneRest {

	@Autowired
	private ApplicazioneRepository appRe;
	
	@GetMapping("/getbyid/{id}")
	public ApplicazioneDTO getById(@PathVariable("id") Integer id) {
		ApplicazioneDTO a = new ApplicazioneDTO(appRe.findById(id).get());
		return a;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<GetApplicazioneResponseDTO> getAll(){
		Iterable<Applicazione> i= appRe.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetApplicazioneResponseDTO(i));
	}
	
	//se nel json gli passo una nuova app salva, se gli passo un app gia esistente salva pero devo dargli anche l'id
	@PostMapping("/save")
	public Applicazione save(@RequestBody Applicazione a) {
		return appRe.save(a);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public Applicazione delete(@PathVariable("id") Integer id) {
		Applicazione a = appRe.findById(id).get();
		 appRe.deleteById(id);
		 return a;
	}
	
}

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

import it.progettogestionale.dto.generic.AppOwnerDTO;
import it.progettogestionale.dto.response.GetAppOwnerResponseDTO;
import it.progettogestionale.dto.response.GetApplicazioneResponseDTO;
import it.progettogestionale.repository.AppOwnerRepository;
import it.progettogestionale.repository.ApplicazioneRepository;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;

@RestController
@RequestMapping("/appownerrest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppOwnerRest {
	
	@Autowired
	private AppOwnerRepository appRe;
	
	@GetMapping("/getbyid/{id}")
	public AppOwnerDTO getById(@PathVariable("id") Integer id) {
		AppOwnerDTO a = new AppOwnerDTO(appRe.findById(id).get());
		return a;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<GetAppOwnerResponseDTO> getAll(){
		Iterable<AppOwner> i = appRe.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetAppOwnerResponseDTO(i));
	}
	
	@PostMapping("/save")
	public AppOwner save(@RequestBody AppOwner a) {
		return appRe.save(a);
	}
	
	@DeleteMapping("/delete/{id}")
	public AppOwner delete(@PathVariable("id") Integer id) {
		AppOwner a = appRe.findById(id).get();
		 appRe.deleteById(id);
		 return a;
	}
	

}

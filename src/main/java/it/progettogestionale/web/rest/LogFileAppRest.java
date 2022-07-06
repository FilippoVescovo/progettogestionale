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

import it.progettogestionale.dto.generic.LogFileAppDTO;
import it.progettogestionale.dto.response.GetLogFileAppResposeDTO;
import it.progettogestionale.dto.response.GetUtentiResponseDTO;
import it.progettogestionale.repository.AppOwnerRepository;
import it.progettogestionale.repository.LogFileAppRepository;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.Utente;

@RestController
@RequestMapping("/logfileapprest")
public class LogFileAppRest {
	
	@Autowired
	private LogFileAppRepository appRe;
	
	@GetMapping("/getappbyid/{id}")
	public LogFileAppDTO getAppById(@PathVariable("id") Integer id) {
		LogFileAppDTO l = new LogFileAppDTO(appRe.findById(id).get());
		return l ;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<GetLogFileAppResposeDTO> getAll(){
		Iterable<LogFileApp> i= appRe.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetLogFileAppResposeDTO(i));
	}
	
	@PostMapping("/save")
	public LogFileApp save(@RequestBody LogFileApp a) {
		return appRe.save(a);
	}
	
	@DeleteMapping("/delete/{id}")
	public LogFileApp delete(@PathVariable("id") Integer id) {
		LogFileApp a = appRe.findById(id).get();
		 appRe.deleteById(id);
		 return a;
	}

}

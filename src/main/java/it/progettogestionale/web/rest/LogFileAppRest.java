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

import it.progettogestionale.dto.generic.LogFileAppDTO;
import it.progettogestionale.dto.response.GetLogFileAppResposeDTO;
import it.progettogestionale.repository.LogFileAppRepository;
import it.progettogestionale.web.model.LogFileApp;

@RestController
@RequestMapping("/logfileapprest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LogFileAppRest {
	
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	
	@Autowired
	private LogFileAppRepository appRe;
	
	@GetMapping("/getbyid/{id}")
	public LogFileAppDTO getById(@PathVariable("id") Integer id) {
		LogFileAppDTO l = new LogFileAppDTO(appRe.findById(id).get());
		return l ;
	}
	
//	@GetMapping("/getall")
//	public ResponseEntity<GetLogFileAppResposeDTO> getAll(){
//		Iterable<LogFileApp> i= appRe.findAll();
//		return ResponseEntity.status(HttpStatus.OK).body(new GetLogFileAppResposeDTO(i));
//	}
	
	@GetMapping("/getalllog")
	public ResponseEntity<List<LogFileAppDTO>> getAllLog(){
		Iterable<LogFileApp> logs = appRe.findAll();
		List<LogFileAppDTO> lfaDTO = new ArrayList<>();
		for(LogFileApp l : logs) {
			lfaDTO.add(new LogFileAppDTO(l));
		}
		return ResponseEntity.status(HttpStatus.OK).body(lfaDTO);
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

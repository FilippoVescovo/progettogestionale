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

import it.progettogestionale.dto.generic.LogFileRescanDTO;
import it.progettogestionale.dto.response.GetLogFileRescanResponseDTO;
import it.progettogestionale.repository.LogFileRescanRepository;
import it.progettogestionale.web.model.LogFileRescan;

@RestController
@RequestMapping("/logfilerescanrest")
public class LogFileRescanRest {

	@Autowired
	private LogFileRescanRepository lfrRepo;
	
	@GetMapping("/getalllog")
	public ResponseEntity<GetLogFileRescanResponseDTO> getAllLog(){
		Iterable<LogFileRescan> logs = lfrRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetLogFileRescanResponseDTO(logs));
	}
	
	@GetMapping("/getlogfilerescanbyid/{id}")
	public LogFileRescanDTO getLogFileRescanById(@PathVariable("id") Integer id) {
		if(lfrRepo.existsById(id)) {
			return new LogFileRescanDTO(lfrRepo.findById(id).get());
		}
		return null;
	}
	
	@PostMapping("/save") //il save aggiunge e modifica
	public LogFileRescan save(@RequestBody LogFileRescan logging) {
		return lfrRepo.save(logging);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if(lfrRepo.existsById(id)) {
			LogFileRescan l = lfrRepo.findById(id).get();
			lfrRepo.delete(l);
		}else {
			System.out.println("id scelto non presente nel db!");
			/*nell'else ci andrà il reindirizzamento alla pagina dell'id 
			non trovato. Per adesso stampiamo solo un messaggio in 
			console.*/
		}
	}
}

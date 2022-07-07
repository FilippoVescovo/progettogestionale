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

import it.progettogestionale.dto.generic.RescanDTO;
import it.progettogestionale.dto.response.GetRescanResponseDTO;
import it.progettogestionale.repository.RescanRepository;
import it.progettogestionale.web.model.Rescan;

@RestController
@RequestMapping("/rescanrest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RescanRest {
	
	@Autowired
	private RescanRepository rescanRepo;
	
//	@GetMapping("rescan/{id}")
//	public Rescan getRescan(@PathVariable("id") Integer id) {
//		return rescanRepo.findById(id).get();
//	}
	
//	@PostMapping("/add")
//	public Rescan add(@RequestBody Rescan r) {
//		return rescanRepo.save(r);
//	}
	
//	@GetMapping("/allrescan")
//	public Iterable<Rescan> getRescans(){
//		return rescanRepo.findAll();
//	}
	
//	@GetMapping("/getallrescan")
//	public ResponseEntity<GetRescanResponseDTO> getAllRescan(){
//		Iterable<Rescan> rescans = rescanRepo.findAll();
//		return ResponseEntity.status(HttpStatus.OK).body(new GetRescanResponseDTO(rescans));
//	}
	
	@GetMapping("/getrescanbyid/{id}")
	public RescanDTO getRescanById(@PathVariable("id") Integer id ) {
		return new RescanDTO(rescanRepo.findById(id).get());
	}
	
	@PostMapping("/save") //il save aggiunge e modifica
	public Rescan save(@RequestBody Rescan r) {
		return rescanRepo.save(r);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public void delete(@PathVariable("id") Integer id) {
//		if(rescanRepo.existsById(id)) {
//			Rescan r = rescanRepo.findById(id).get();
//			rescanRepo.delete(r);
//		}else {
//			System.out.println("id scelto non presente nel db!");
//			/*nell'else ci andrà il reindirizzamento alla pagina dell'id 
//			non trovato. Per adesso stampiamo solo un messaggio in 
//			console.*/
//		}
//	}
}

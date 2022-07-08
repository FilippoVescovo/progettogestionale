package it.progettogestionale.web.rest;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.dto.generic.ApplicazioneDTO;
import it.progettogestionale.repository.ApplicazioneRepository;
import it.progettogestionale.repository.LogFileAppRepository;
import it.progettogestionale.repository.UtenteRepository;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.Utente;

@RestController
@RequestMapping("/applicazionerest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApplicazioneRest {
	
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */

	@Autowired
	private ApplicazioneRepository appRe;
	@Autowired
	private LogFileAppRepository logRepo;
	@Autowired
	private UtenteRepository utenteRepo;
	
	@GetMapping("/getbyid/{id}")
	public ApplicazioneDTO getById(@PathVariable("id") Integer id) {
		ApplicazioneDTO a = new ApplicazioneDTO(appRe.findById(id).get());
		return a;
	}
	
//	@GetMapping("/getall")
//	public ResponseEntity<GetApplicazioneResponseDTO> getAll(){
//		Iterable<Applicazione> i= appRe.findAll();
//		return ResponseEntity.status(HttpStatus.OK).body(new GetApplicazioneResponseDTO(i));
//	}
	
//	@GetMapping("/getallapp")
//    public ResponseEntity<List<ApplicazioneDTO>> getAllApp(){
//        Iterable<Applicazione> i=appRe.findAll();
//        List<ApplicazioneDTO> ldto = new ArrayList<>();
//        for(Applicazione u : i) {
////        	if(u.isExist() == true) ldto.add(new ApplicazioneDTO(u));
//        	try {
//        		if(u.isExist() == true) ldto.add(new ApplicazioneDTO(u));
//        	}catch (NullPointerException e) {
//        		Applicazione y = appRe.findById(u.getIdApplicazione()).get();
//        		recuperoApp(y.getIdApplicazione());
//				ldto.add(new ApplicazioneDTO(y));
//			}
////        	ldto.stream().forEach(t -> System.out.println(t.getIdApplicazione() + " " + t.getExist()));
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(ldto);
//    }
	
	@GetMapping("/getallapp")
	public ResponseEntity<List<ApplicazioneDTO>> getAllApp(){
        Iterable<Applicazione> i=appRe.findAll();
        List<ApplicazioneDTO> ldto = new ArrayList<>();
        for(Applicazione u : i) {
        	if(u.isExist() == true) ldto.add(new ApplicazioneDTO(u));
        }
        return ResponseEntity.status(HttpStatus.OK).body(ldto);
    }
	
	@GetMapping("/getappeliminate")
	public ResponseEntity<List<ApplicazioneDTO>> getAppEliminate(){
        Iterable<Applicazione> i=appRe.findAll();
        List<ApplicazioneDTO> ldto = new ArrayList<>();
        for(Applicazione u : i) {
        	if(u.isExist() == false) ldto.add(new ApplicazioneDTO(u));
        }
        return ResponseEntity.status(HttpStatus.OK).body(ldto);
    }
	
	//se nel json gli passo una nuova app salva, se gli passo un app gia esistente salva pero devo dargli anche l'id
//	@PostMapping("/save")
//	public Applicazione save(@RequestBody Applicazione a) {
//		return appRe.save(a);
//	}
	
	@PostMapping("/save") //update e insert con save
	public Applicazione save(@RequestBody Applicazione a) {
		if(a.isExist() == null) {
			a.setExist(true);
		}
		return appRe.save(a);
	}
	
	@PostMapping("/modificaapp")
	public Applicazione modificaApp(@RequestBody Applicazione a, @RequestBody Utente u) {
		LogFileApp lfa = new LogFileApp();
		Utente alfonso = utenteRepo.findById(u.getIdUtente()).get();
		if(appRe.findById(a.getIdApplicazione()) != null) {
			lfa.setData(LocalDateTime.now());
			lfa.setUtente(alfonso);
			lfa.setApplicazione(a);
			logRepo.save(lfa);
		}
		return appRe.save(a);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public Applicazione delete(@PathVariable("id") Integer id) {
//		Applicazione a = appRe.findById(id).get();
//		appRe.deleteById(id);
//		return a;
//	}
	
	@PutMapping("/logicdelete/{id}")
	public void logicDelete(@PathVariable("id") Integer id) {
		if(appRe.existsById(id)) {
			appRe.logicDelete(id);
		}
	}
	
	@PutMapping("/recuperoapp/{id}")
	public void recuperoApp(@PathVariable("id") Integer id) {
		if(appRe.existsById(id)) {
			appRe.recuperoApp(id);
		}
	}
}

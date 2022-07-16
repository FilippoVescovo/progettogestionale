package it.progettogestionale.web.rest;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.dto.generic.LogFileRescanDTO;
import it.progettogestionale.dto.generic.RescanDTO;
import it.progettogestionale.repository.AppOwnerRepository;
import it.progettogestionale.repository.ApplicazioneRepository;
import it.progettogestionale.repository.LogFileRescanRepository;
import it.progettogestionale.repository.RescanRepository;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileRescan;
import it.progettogestionale.web.model.Rescan;

@RestController
@RequestMapping("/rescanrest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RescanRest {
	
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	/* NON CANCELLARE NESSUN SERVIZIO COMMENTATO PERCHE' SONO TUTTI FUNZIONANTI E FUNZIONALI AD ALTRE SITUAZIONI */
	
	@Autowired
	private RescanRepository rescanRepo;
	@Autowired
	private ApplicazioneRepository appRe;
	@Autowired
	private AppOwnerRepository ownerRepo;
	@Autowired
	private LogFileRescanRepository logRepo;
	
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
	
	@GetMapping("/getallrescan")
	public ResponseEntity<List<RescanDTO>> getAllRescan(){
		Iterable<Rescan> rescans = rescanRepo.findAll();
		List<RescanDTO> reDTO = new ArrayList<>();
		for(Rescan r : rescans) {
			reDTO.add(new RescanDTO(r));
		}
		return ResponseEntity.status(HttpStatus.OK).body(reDTO);
	}
	
	@GetMapping("/getrescanbyid/{id}")
	public RescanDTO getRescanById(@PathVariable("id") Integer id ) {
		return new RescanDTO(rescanRepo.findById(id).get());
	}
	
	@PostMapping("/save") //il save aggiunge e modifica
	public Rescan save(@RequestBody Rescan r) {
		return rescanRepo.save(r);
	}
	
	@PostMapping("/rescan")
	public ResponseEntity<RescanDTO> rescan(@RequestBody RescanDTO crea){
		Applicazione app = appRe.findById(crea.getApplicazione()).get();
		AppOwner owner = ownerRepo.findById(crea.getAppOwner()).get();
		Rescan r = new Rescan();
		List<Integer> lista = rescanRepo.lastRescan(app.getIdApplicazione());
		if(app.getIdApplicazione() != null) {
			r.setnRescan(lista.get(0) + 1);
			r.setOnGoing(crea.getOnGoing());
			r.setArchive(crea.getArchive());
			r.setRkd(Date.valueOf(LocalDate.now()));
			r.setAfpe(crea.getAfpe());
			r.setNewOb(crea.getNewOb());
			r.setPy(crea.getPy());
			r.setYtd(crea.getYtd());
			r.setYoyRolling(crea.getYoyRolling());
			r.setLast_Rescan(crea.getLast_Rescan());
			r.setApplicazione(app);
			r.setAppOwner(owner);
			r.setExist(crea.getExist());
		}
		RescanDTO rdto = new RescanDTO(r);
		rescanRepo.save(r);
		return new ResponseEntity<RescanDTO>(rdto, HttpStatus.CREATED);
	}
	

//	public LogFileRescanDTO logRescan(RescanDTO r){
//		LogFileRescan lfr = new LogFileRescan();
//		List<Integer> lista = rescanRepo.lastLog(lfr.getIdLogRescan());
//		lfr.setData(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
//		lfr.setAppOwner(ownerRepo.findById(r.getAppOwner()).get());
//		lfr.setRescan(rescanRepo.findById(r.getIdRescan()).get());
//		lfr.setnRescan(r.getnRescan());
//		lfr.setOngoing(r.getOnGoing());
//		lfr.setArchive(r.getArchive());
//		lfr.setRkd(r.getRkd());
//		lfr.setAfpe(r.getAfpe());
//		lfr.setNewOb(r.getNewOb());
//		lfr.setPy(r.getPy());
//		lfr.setYtd(r.getYtd());
//		lfr.setYoyRolling(r.getYoyRolling());
//		lfr.setLast_Rescan(r.getLast_Rescan());
//		if(lfr.getIdPreUpdate() != null) {
//			lfr.setIdPreUpdate(lista.get(0));
//		}
//		logRepo.save(lfr);
//		LogFileRescanDTO lfrDTO = new LogFileRescanDTO(lfr);
//		return lfrDTO;
//	}
	
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

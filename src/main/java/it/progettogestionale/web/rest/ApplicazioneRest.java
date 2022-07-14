package it.progettogestionale.web.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.dto.generic.AppOwnerDTO;
import it.progettogestionale.dto.generic.ApplicazioneDTO;
import it.progettogestionale.dto.generic.LogFileAppDTO;
import it.progettogestionale.dto.generic.LogFileRescanDTO;
import it.progettogestionale.dto.generic.RescanDTO;
import it.progettogestionale.repository.AppOwnerRepository;
import it.progettogestionale.repository.ApplicazioneRepository;
import it.progettogestionale.repository.LogFileAppRepository;
import it.progettogestionale.repository.LogFileRescanRepository;
import it.progettogestionale.repository.UtenteRepository;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.LogFileRescan;
import it.progettogestionale.web.model.Rescan;
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
	@Autowired
	private AppOwnerRepository ownerRepo;
	@Autowired
	private LogFileRescanRepository rescanRepo;
	
	
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
		Iterable<AppOwner> owners = ownerRepo.findAll();
		Set<AppOwner> setAo = new HashSet<>();
		for(AppOwner x : owners) {
			if(a.getOwners() == null) appRe.inserimentoMonitoraggio(a.getIdApplicazione(), 1);
			else setAo.add(x);
		}
		a.setOwners(setAo);
		appRe.save(a);
//		if(a.getOwners() == null) {
//			appRe.inserimentoMonitoraggio(a.getIdApplicazione(), 1);
//		}
		return appRe.findById(a.getIdApplicazione()).get();
	}
	
	//metodo di modifica esatto
	@PostMapping("/modificaapp")
	public ResponseEntity<LogFileAppDTO> modificaApp (@RequestBody LogFileAppDTO modifica){
		Applicazione a = appRe.findById(modifica.getIdApplicazione()).get();
		Utente u = utenteRepo.findById(modifica.getIdUtente()).get();
		LogFileApp lfa = new LogFileApp();
		List<Integer> lista = appRe.lastDate(a.getIdApplicazione());
		if(a.getIdApplicazione() != null) {
			lfa.setData(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
			lfa.setNodoConsole(a.getNodoConsole());
			lfa.setLaunchingMeetingDataGatheringStarting(a.getLaunchingMeetingDataGatheringStarting());
			lfa.setAvgAnalysisTime(a.getAvgAnalysisTime());
			lfa.setAutomationEnablingDate(a.getAutomationEnablingDate());
			lfa.setDone(a.isDone());
			lfa.setOwnerOnboarding(a.getOwnerOnboarding());
			lfa.setOwnerAFP(a.getOwnerAFP());
			lfa.setUtente(u);
			lfa.setApplicazione(a);
			lfa.setNome_App(a.getNome_App());
			lfa.setApmCode(a.getApmCode());
			lfa.setInsertedInCastProgram(a.getInsertedInCastProgram());
			lfa.setStakeholderEngagement(a.getStakeholderEngagement());
			lfa.setStakeholderBrief(a.getStakeholderBrief());
			lfa.setOnBoardingKitDelivery(a.getOnBoardingKitDelivery());
			lfa.setPrimaRestitution(a.getPrimaRestitution());
			lfa.setGdsUnit(a.getGdsUnit());
			lfa.setTecnologia(a.getTecnologia());
			lfa.setServerManager(a.getServerManager());
			lfa.setSoloCMS(a.getSoloCMS());
			lfa.setMacchina(a.getMacchina());
			lfa.setNoteOnboarding(a.getNoteOnboarding());
			lfa.setFase(a.getFase());
			lfa.setAfpStatus(a.getAfpStatus());
			lfa.setPubblicatoDashboard(a.getPubblicatoDashboard());
			lfa.setNoteAppOwner(a.getNoteAppOwner());
			lfa.setJiraautomationActivation(a.getJiraautomationActivation());
			lfa.setRepoAvailability(a.getRepoAvailability());
			lfa.setAutomationStatus(a.getAutomationStatus());
			lfa.setAutomationNotes(a.getAutomationNotes());
			lfa.setGreenItIndex(a.getGreenItIndex());
			lfa.setOnboardingKitClosing(a.getOnboardingKitClosing());
			lfa.setSourceCodeFinalDelivery(a.getSourceCodeFinalDelivery());
			lfa.setLinkConfluence(a.getLinkConfluence());
			lfa.setBusinessCriticality(a.getBusinessCriticality());
			lfa.setDevMethodology(a.getDevMethodology());
			lfa.setProvider(a.getProvider());
			if(lfa.getIdPreUpdate() != null) {
				lfa.setIdPreUpdate(lista.get(0));
			}
		}
		appRe.save(a);
		LogFileAppDTO pluto = new LogFileAppDTO(lfa);
		logRepo.save(lfa);
		return new ResponseEntity<LogFileAppDTO>(pluto, HttpStatus.CREATED);
	}
	
	
//	@GetMapping("/prova")
//	public Integer prova() {
//		
//		List<Integer> l = appRe.lastDate(1);
//		
//		return l.get(0);
//	}
	
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

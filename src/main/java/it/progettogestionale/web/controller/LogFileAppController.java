package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.ApplicazioneDao;
import it.progettogestionale.web.dao.LogFileAppDao;
import it.progettogestionale.web.dao.UtenteDao;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.Utente;

@Controller
@RequestMapping("/logfileapp")
public class LogFileAppController {

	@Autowired
	public LogFileAppDao logFileAppService;
	@Autowired
	public UtenteDao utenteService;
	@Autowired
	public ApplicazioneDao applicazioneService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		LogFileApp a = logFileAppService.getById(2);
		return a.getNome_App();
	}
	
	@ResponseBody
	@GetMapping("/add")
	public String add() {
		LogFileApp l = new LogFileApp();
		Utente u = utenteService.getById(4);
		Applicazione a = applicazioneService.getById(1);
		l.setUtente(u);
		l.setApplicazione(a);
		l.setNome_App("nome prova log");
		logFileAppService.add(l);
		return "log rescan inserito correttamente";
	}
	
	@ResponseBody
	@GetMapping("/update")
	public String update() {
		LogFileApp a = logFileAppService.getById(2);
		a.setNome_App("filipp prova");
		logFileAppService.update(a);
		return "log rescan modificato correttamente";
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String delete() {
		logFileAppService.delete(2);
		return "log rescan eliminato correttamente";
	}
}

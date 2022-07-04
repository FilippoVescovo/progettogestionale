package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.ApplicazioneDao;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileRescan;
import it.progettogestionale.web.model.Rescan;
import it.progettogestionale.web.model.Utente;

@Controller
@RequestMapping("/applicazione")
public class ApplicazioneController {
	
	@Autowired
	public ApplicazioneDao applicazioService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		Applicazione a = applicazioService.getById(1);
		return a.getNome_App();
	}
	
	@ResponseBody
	@GetMapping("/add")
	public String add() {
		applicazioService.add(new Applicazione("nome prova"));
		return "log rescan inserito correttamente";
	}
	
	@ResponseBody
	@GetMapping("/update")
	public String update() {
		Applicazione a = applicazioService.getById(319);
		a.setNome_App("filipp prova");
		applicazioService.update(a);
		return "log rescan modificato correttamente";
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String delete() {
		applicazioService.delete(319);
		return "log rescan eliminato correttamente";
	}

}

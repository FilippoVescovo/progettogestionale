package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.ApplicazioneDao;
import it.progettogestionale.web.dao.LogFileAppDao;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.LogFileApp;

@Controller
@RequestMapping("/logfileapp")
public class LogFileAppController {

	@Autowired
	public LogFileAppDao logFileAppService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		LogFileApp a = logFileAppService.getById(2);
		return a.getNome_App();
	}
}

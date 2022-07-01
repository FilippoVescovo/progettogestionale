package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import it.progettogestionale.dao.ApplicazioneDao;
import it.progettogestionale.web.model.Applicazione;

@Controller
@RequestMapping("/controller")
public class ApplicazioneController {
	
	@Autowired
	public ApplicazioneDao applicazioService;
	
	@ResponseBody
	@GetMapping("/get")
	public String getById() {
		Applicazione a = applicazioService.getById(1);
		return a.getNome_App();
	}

}

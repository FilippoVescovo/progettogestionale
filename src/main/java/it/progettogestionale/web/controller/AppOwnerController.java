package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.AppOwnerDao;
import it.progettogestionale.web.dao.ApplicazioneDao;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;

@Controller
@RequestMapping("/appowner")
public class AppOwnerController {

	@Autowired
	public AppOwnerDao appOwnerService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		AppOwner a = appOwnerService.getById(1);
		return a.getNome();
	}
}

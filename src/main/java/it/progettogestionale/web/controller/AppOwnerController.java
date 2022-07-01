package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.progettogestionale.web.dao.AppOwnerDao;
import it.progettogestionale.web.dao.ApplicazioneDao;

@Controller
@RequestMapping("/appowner")
public class AppOwnerController {

	@Autowired
	public AppOwnerDao appOwnerService;
}

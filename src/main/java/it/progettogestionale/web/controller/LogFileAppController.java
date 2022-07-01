package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.progettogestionale.web.dao.ApplicazioneDao;
import it.progettogestionale.web.dao.LogFileAppDao;

@Controller
@RequestMapping("/logfileapp")
public class LogFileAppController {

	@Autowired
	public LogFileAppDao logFileAppService;
}

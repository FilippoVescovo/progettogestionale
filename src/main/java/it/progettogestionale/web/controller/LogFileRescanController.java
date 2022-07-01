package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.LogFileRescanDao;
import it.progettogestionale.web.model.LogFileRescan;

@Controller
@RequestMapping("/logfilerescan")
public class LogFileRescanController {
	
	@Autowired
	public LogFileRescanDao logFileRescanService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		LogFileRescan lfr = logFileRescanService.getById(1);
		return lfr.getAfpe();
	}
}

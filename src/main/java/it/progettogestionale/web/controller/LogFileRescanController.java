package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.LogFileRescanDao;
import it.progettogestionale.web.dao.RescanDao;
import it.progettogestionale.web.dao.UtenteDao;
import it.progettogestionale.web.model.LogFileRescan;
import it.progettogestionale.web.model.Rescan;
import it.progettogestionale.web.model.Utente;

@Controller
@RequestMapping("/logfilerescan")
public class LogFileRescanController {
	
	@Autowired
	public LogFileRescanDao logFileRescanService;
	@Autowired
	public UtenteDao utenteService;
	@Autowired
	public RescanDao rescanService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		LogFileRescan lfr = logFileRescanService.getById(1);
		return lfr.getAfpe();
	}
	
	@ResponseBody
	@GetMapping("/add")
	public String add() {
		LogFileRescan lfr = new LogFileRescan();
		Utente u = utenteService.getById(2);
		Rescan r = rescanService.getById(6);
//		lfr.setUtente(u);
		lfr.setRescan(r);
		lfr.setnRescan(5);
		logFileRescanService.add(lfr);
		return "log rescan inserito correttamente";
	}
	
	@ResponseBody
	@GetMapping("/update")
	public String update() {
		LogFileRescan lfr = logFileRescanService.getById(4);
		lfr.setYoyRolling(null);
		lfr.setAfpe("Kobe");
		logFileRescanService.update(lfr);
		return "log rescan modificato correttamente";
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String delete() {
		logFileRescanService.delete(5);
		return "log rescan eliminato correttamente";
	}
}

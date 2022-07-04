package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.RescanDao;
import it.progettogestionale.web.model.Rescan;

@Controller
@RequestMapping("/rescan")
public class RescanController {
	
	@Autowired
	public RescanDao rescanService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		Rescan r = rescanService.getById(110);
		return r.getAfpe();
	}
	
	@ResponseBody
	@GetMapping("/add")
	public String add() {
		Rescan r = new Rescan();
		r.setnRescan(5);
		r.setAfpe("Federico");
		rescanService.add(r);
		return "rescan inserito correttamente";
	}
	
	@ResponseBody
	@GetMapping("/update")
	public String update() {
		Rescan r = rescanService.getById(2);
		r.setAfpe("Dario");
		rescanService.update(r);
		return "rescan aggiornato";
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String delete() {
		rescanService.delete(22);
		return "rescan eliminato correttamente";
	}
}

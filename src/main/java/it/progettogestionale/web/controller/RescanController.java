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
}

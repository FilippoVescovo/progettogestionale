package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.progettogestionale.web.dao.UtenteDao;
import it.progettogestionale.web.model.Utente;

@Controller
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	public UtenteDao utenteService;
	
	@ResponseBody
	@GetMapping("/getbyid")
	public String getById() {
		Utente u = new Utente();
		if(u.getIdUtente() != null) {
			u = utenteService.getById(1);
			return u.getNome();
		}
		return null;
	}
}

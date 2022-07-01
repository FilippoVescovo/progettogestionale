package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.progettogestionale.web.dao.UtenteDao;

@Controller
@RequestMapping("/cliente")
public class UtenteController {
	
	@Autowired
	public UtenteDao clienteService;
	//ciao
}

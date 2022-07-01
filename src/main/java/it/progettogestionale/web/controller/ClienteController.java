package it.progettogestionale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.progettogestionale.web.dao.ClienteDao;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	public ClienteDao clienteService;
}

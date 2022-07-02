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
			Utente u = utenteService.getById(4);
			return u.getNome();
	}
	
	@ResponseBody
	@GetMapping("/add")
	public String add() {
		Utente u = new Utente();
		u.setNome("francesco");
		u.setCognome("verdi");
		u.setPassword("password");
		u.setEmail("fraver@email.gg");
		utenteService.add(u);
		return "utente aggiunto";
	}
	
	@ResponseBody
	@GetMapping("/update")
	public String update() {
		Utente u = utenteService.getById(1);
		u.setNome("Giuseppe");
		utenteService.update(u);
		return "l'utente e' stato modificato correttamente";
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String delete() {
		utenteService.delete(1);
		return "utente eliminato correttamente";
	}
}

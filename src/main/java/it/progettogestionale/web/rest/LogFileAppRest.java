package it.progettogestionale.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.repository.AppOwnerRepository;
import it.progettogestionale.repository.LogFileAppRepository;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.LogFileApp;

@RestController
@RequestMapping("/logfileapprest")
public class LogFileAppRest {
	
	@Autowired
	private LogFileAppRepository appRe;
	
	@GetMapping("/getappbyid/{id}")
	public LogFileApp getAppById(@PathVariable("id") Integer id) {
		return appRe.findById(id).get();
	}
	
	@GetMapping("/getall")
	public Iterable<LogFileApp> getAll(){
		return appRe.findAll();
	}
	
	@PostMapping("/save")
	public LogFileApp save(@RequestBody LogFileApp a) {
		return appRe.save(a);
	}
	
	@DeleteMapping("/delete/{id}")
	public LogFileApp delete(@PathVariable("id") Integer id) {
		LogFileApp a = appRe.findById(id).get();
		 appRe.deleteById(id);
		 return a;
	}

}

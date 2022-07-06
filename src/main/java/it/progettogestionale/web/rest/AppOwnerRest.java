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
import it.progettogestionale.repository.ApplicazioneRepository;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;

@RestController
@RequestMapping("/appownerrest")
public class AppOwnerRest {
	
	@Autowired
	private AppOwnerRepository appRe;
	
	@GetMapping("/getappbyid/{id}")
	public AppOwner getAppById(@PathVariable("id") Integer id) {
		return appRe.findById(id).get();
	}
	
	@GetMapping("/getall")
	public Iterable<AppOwner> getAll(){
		return appRe.findAll();
	}
	
	@PostMapping("/save")
	public AppOwner save(@RequestBody AppOwner a) {
		return appRe.save(a);
	}
	
	@DeleteMapping("/delete/{id}")
	public AppOwner delete(@PathVariable("id") Integer id) {
		AppOwner a = appRe.findById(id).get();
		 appRe.deleteById(id);
		 return a;
	}
	

}

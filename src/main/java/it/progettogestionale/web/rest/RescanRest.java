package it.progettogestionale.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.dto.response.GetRescanResponseDTO;
import it.progettogestionale.repository.RescanRepository;
import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Rescan;

@RestController
@RequestMapping("/rescanrest")
public class RescanRest {
	
	@Autowired
	private RescanRepository rescanRepo;
	
//	@GetMapping("rescan/{id}")
//	public Rescan getRescan(@PathVariable("id") Integer id) {
//		return rescanRepo.findById(id).get();
//	}
	
//	@PostMapping("/add")
//	public Rescan add(@RequestBody Rescan r) {
//		return rescanRepo.save(r);
//	}
	
//	@GetMapping("/allrescan")
//	public Iterable<Rescan> getRescans(){
//		return rescanRepo.findAll();
//	}
	
	@GetMapping("/getallrescan")
	public ResponseEntity<GetRescanResponseDTO> getAllRescan(){
		Iterable<Rescan> rescans = rescanRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(new GetRescanResponseDTO(rescans));
	}
}

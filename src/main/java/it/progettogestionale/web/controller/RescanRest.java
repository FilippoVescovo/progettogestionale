package it.progettogestionale.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.progettogestionale.repository.RescanRepository;
import it.progettogestionale.web.model.Rescan;

@RestController
@RequestMapping("/rescanrest")
public class RescanRest {
	
	@Autowired
	private RescanRepository rescanRepo;
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping("rescan/{id}")
	public Rescan getRescan(@PathVariable("id") Integer id) {
		return rescanRepo.findById(id).get();
	}
	
	@PostMapping("/add")
	public Rescan add(@RequestBody Rescan r) {
		return rescanRepo.save(r);
	}
}

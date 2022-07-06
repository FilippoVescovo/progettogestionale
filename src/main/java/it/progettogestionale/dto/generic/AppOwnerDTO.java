package it.progettogestionale.dto.generic;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.Rescan;

public class AppOwnerDTO {
	
	private String nome;
	private String cognome;
	private String email;
	private String cell;
	private String dsUnit;
	private Set<Rescan> appOwners;
	private Set<Applicazione> applicazione;

}

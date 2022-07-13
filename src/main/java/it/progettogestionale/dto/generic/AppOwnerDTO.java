package it.progettogestionale.dto.generic;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.Rescan;

public class AppOwnerDTO {
	
	private Integer idAppOwner;
	private String nome;
	private String cognome;
	private String email;
	private String cell;
	private String dsUnit;
	private List<Integer> idAppOwners;
	private List<Integer> idApplicazione;
	
	public AppOwnerDTO() {}

	public AppOwnerDTO(AppOwner a) {
		idAppOwner = a.getIdAppOwner();
		nome = a.getNome();
		cognome = a.getCognome();
		email = a.getEmail();
		cell = a.getCell();
		dsUnit = a.getDsUnit();
		idAppOwners = a.getAppOwners().stream().map(Rescan::getIdRescan).collect(Collectors.toList());;
		idApplicazione = a.getApplicazione().stream().map(Applicazione::getIdApplicazione).collect(Collectors.toList());;
	}
	
	
	public Integer getIdAppOwner() {
		return idAppOwner;
	}

	public void setIdAppOwner(Integer idAppOwner) {
		this.idAppOwner = idAppOwner;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getDsUnit() {
		return dsUnit;
	}

	public void setDsUnit(String dsUnit) {
		this.dsUnit = dsUnit;
	}

	public List<Integer> getIdAppOwners() {
		return idAppOwners;
	}

	public void setIdAppOwners(List<Integer> idAppOwners) {
		this.idAppOwners = idAppOwners;
	}

	public List<Integer> getIdApplicazione() {
		return idApplicazione;
	}

	public void setIdApplicazione(List<Integer> idApplicazione) {
		this.idApplicazione = idApplicazione;
	}
	
	
	
	

}

package it.progettogestionale.dto.generic;

import java.util.List;
import java.util.stream.Collectors;

import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.LogFileRescan;
import it.progettogestionale.web.model.Utente;

public class UtenteDTO {
	
	private Integer idUtente;
	private String nome;
	private String cognome;
	private String email;
	private Boolean ruolo;
	private Boolean accesso;
	private List<Integer> idLogFileApp;
	private List<Integer> idLogFileRescan;
	
	public UtenteDTO() {}
	
	public UtenteDTO(Utente u) {
		idUtente = u.getIdUtente();
		nome=u.getNome();
		cognome=u.getCognome();
		email=u.getEmail();
		ruolo=u.isRuolo();
		accesso = u.isAccesso();
		idLogFileApp=u.getLogfiles().stream().map(LogFileApp::getIdLogApp).collect(Collectors.toList());
		idLogFileRescan=u.getLogFile().stream().map(LogFileRescan::getIdLogRescan).collect(Collectors.toList());
	}

	
	
	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
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

	public Boolean getRuolo() {
		return ruolo;
	}

	public void setRuolo(Boolean ruolo) {
		this.ruolo = ruolo;
	}

	public Boolean getAccesso() {
		return accesso;
	}

	public void setAccesso(Boolean accesso) {
		this.accesso = accesso;
	}

	public List<Integer> getIdLogFileApp() {
		return idLogFileApp;
	}

	public void setIdLogFileApp(List<Integer> idLogFileApp) {
		this.idLogFileApp = idLogFileApp;
	}

	public List<Integer> getIdLogFileRescan() {
		return idLogFileRescan;
	}

	public void setIdLogFileRescan(List<Integer> idLogFileRescan) {
		this.idLogFileRescan = idLogFileRescan;
	}
	
	
	
}

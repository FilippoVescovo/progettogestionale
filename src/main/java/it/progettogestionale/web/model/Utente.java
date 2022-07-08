package it.progettogestionale.web.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.json.JSONPropertyIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "utente")
//@JsonIgnoreProperties({"logfiles", "logFile"})
public class Utente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//	@SequenceGenerator(name = "seq", sequenceName = "*nome sequenza database*", initialValue = 666) 
//	alter sequence *nome sequenza database* restart with 666;(modo alternativo per risolvere)
	private Integer idUtente;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "ruolo")
	private Boolean ruolo;
	@Column(name = "accesso")
	private Boolean accesso;
		//cascade:serve modificare a cascata tutto cio che è relazionato all'entity,fetch: download dei dati eage tutti lazy quando richiamo il getter
	@OneToMany(mappedBy = "utente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JsonManagedReference
	private Set<LogFileApp> logfiles;
	
	@OneToMany(mappedBy = "utente",fetch = FetchType.EAGER)
//	@JsonManagedReference
	private Set<LogFileRescan> logFile;
	
	
	public Utente() {}
	
	public Utente(Integer idUtente, String nome, String cognome, String password, String email, Boolean ruolo, Boolean accesso,
			Set<LogFileApp> logfiles, Set<LogFileRescan> logFile) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.ruolo = ruolo;
		this.accesso = accesso;
		this.logfiles = logfiles;
		this.logFile = logFile;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean isRuolo() {
		return ruolo;
	}
	public void setRuolo(Boolean ruolo) {
		this.ruolo = ruolo;
	}
	public Boolean isAccesso() {
		return accesso;
	}
	public void setAccesso(Boolean accesso) {
		this.accesso = accesso;
	}
	public Boolean getRuolo() {
		return ruolo;
	}
	public Set<LogFileApp> getLogfiles() {
		return logfiles;
	}
	public void setLogfiles(Set<LogFileApp> logfiles) {
		this.logfiles = logfiles;
	}
	public Set<LogFileRescan> getLogFile() {
		return logFile;
	}
	public void setLogFile(Set<LogFileRescan> logFile) {
		this.logFile = logFile;
	}

	
	@Override
	public String toString() {
		return "Utente [getIdUtente()= " + getIdUtente() + ", getNome()= " + getNome() + ", getCognome()= " + getCognome()
				+ ", getPassword()= " + getPassword() + ", getEmail()= " + getEmail() + ", isRuolo()= " + isRuolo()
				+ ", getAccesso()= " + isAccesso() + ", getRuolo()= " + getRuolo() + ", getLogfiles()= " + getLogfiles()
				+ ", getLogFile()= " + getLogFile() + "]";
	}
}

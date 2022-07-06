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
import javax.persistence.Table;

import org.json.JSONPropertyIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "utente")
//@JsonIgnoreProperties({"logfiles", "logFile"})
public class Utente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy = "utente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JsonManagedReference
	private Set<LogFileApp> logfiles;
	
	@OneToMany(mappedBy = "utente",fetch = FetchType.EAGER)
//	@JsonManagedReference
	private Set<LogFileRescan> logFile;
	
	
	public Utente() {}
	
	public Utente(Integer idUtente, String nome, String cognome, String password, String email, Boolean ruolo,
			Set<LogFileApp> logfiles, Set<LogFileRescan> logFile) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.ruolo = ruolo;
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
				+ ", getEmail()= " + getEmail() + ", isRuolo()= " + isRuolo() + ", getLogfiles()= " + getLogfiles()
				+ ", getLogFile()= " + getLogFile() + "]";
	}
}

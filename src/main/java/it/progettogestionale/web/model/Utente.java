package it.progettogestionale.web.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUtente;
	@Column
	private String nome, cognome, password, email;
	@Column
	private boolean ruolo;
	@OneToMany(mappedBy = "utente")
//	@JsonManagedReference
	private Set<LogFileApp> logfiles;
	@OneToMany(mappedBy = "utente")
//	@JsonManagedReference
	private Set<LogFileRescan> logFile;
	public Utente(Integer idUtente, String nome, String cognome, String password, String email, boolean ruolo,
			Set<LogFileApp> logfiles, Set<LogFileRescan> logFile) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.ruolo = ruolo;
		this.logfiles = logfiles;
		this.logFile = logFile;
	}
	public Utente() {
		super();
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
	public boolean isRuolo() {
		return ruolo;
	}
	public void setRuolo(boolean ruolo) {
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
	
	
}

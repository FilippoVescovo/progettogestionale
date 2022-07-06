package it.progettogestionale.web.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appowner")
public class AppOwner implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAppOwner;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "email")
	private String email;
	@Column(name = "cell")
	private String cell;
	@Column(name = "dsUnit")
	private String dsUnit;
	
	@OneToMany(mappedBy = "appOwner", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JsonManagedReference
//	@JsonIgnore
	private Set<Rescan> appOwners;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name = "monitoraggio",
			joinColumns = @JoinColumn(name = "fk_idAppOwner"),
			inverseJoinColumns = @JoinColumn(name = "fk_idApplicazione")
		)
//	@JsonIgnore
	private Set<Applicazione> applicazione;
	
	
	public AppOwner() {}
	
	public AppOwner(Integer idAppOwner, String nome, String cognome, String email, String cell, String dsUnit,
			Set<Rescan> appOwners, Set<Applicazione> applicazione) {
		this.idAppOwner = idAppOwner;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.cell = cell;
		this.dsUnit = dsUnit;
		this.appOwners = appOwners;
		this.applicazione = applicazione;
	}
	
	//costruttore con attributi not null
	public AppOwner( String nome, String cognome, String email, String dsUnit) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dsUnit = dsUnit;
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
	public Set<Rescan> getAppOwners() {
		return appOwners;
	}
	public void setAppOwners(Set<Rescan> appOwners) {
		this.appOwners = appOwners;
	}
	public Set<Applicazione> getApplicazione() {
		return applicazione;
	}
	public void setApplicazione(Set<Applicazione> applicazione) {
		this.applicazione = applicazione;
	}

	@Override
	public String toString() {
		return "AppOwner [idAppOwner=" + idAppOwner + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", cell=" + cell + ", dsUnit=" + dsUnit + ", appOwners=" + appOwners + ", applicazione="
				+ applicazione + "]";
	}
	
	
	
}

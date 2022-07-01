package it.progettogestionale.web.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Rescan implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRescan;
	@Column
	private Integer nRescan;
	@Column
	private Integer newOb;
	@Column
	private Integer py;
	@Column
	private Integer ytd;
	@Column
	private String afpe;
	@Column
	private String yoyRolling;
	@Column
	private String last_Rescan;
	@Column
	private Boolean onGoing;
	@Column
	private Boolean archive;
	@Column
	private Boolean exist;
	@Column
	private Date rkd;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_idApplicazione", referencedColumnName = "idApplicazione")
//	@JsonBackReference
	private Applicazione applicazione;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_idAppOwner", referencedColumnName = "idAppOwner")
//	@JsonBackReference
	private AppOwner appOwner;
	public Rescan(Integer idRescan, Integer nRescan, Integer newOb, Integer py, Integer ytd, String afpe, String yoyRolling,
			String last_Rescan, Boolean onGoing, Boolean archive, Boolean exist, Date rkd, Applicazione applicazione,
			AppOwner appOwner) {
		super();
		this.idRescan = idRescan;
		this.nRescan = nRescan;
		this.newOb = newOb;
		this.py = py;
		this.ytd = ytd;
		this.afpe = afpe;
		this.yoyRolling = yoyRolling;
		this.last_Rescan = last_Rescan;
		this.onGoing = onGoing;
		this.archive = archive;
		this.exist = exist;
		this.rkd = rkd;
		this.applicazione = applicazione;
		this.appOwner = appOwner;
	}
	public Rescan() {
		super();
	}
	public Integer getIdRescan() {
		return idRescan;
	}
	public void setIdRescan(Integer idRescan) {
		this.idRescan = idRescan;
	}
	public Integer getnRescan() {
		return nRescan;
	}
	public void setnRescan(Integer nRescan) {
		this.nRescan = nRescan;
	}
	public Integer getNewOb() {
		return newOb;
	}
	public void setNewOb(Integer newOb) {
		this.newOb = newOb;
	}
	public Integer getPy() {
		return py;
	}
	public void setPy(Integer py) {
		this.py = py;
	}
	public Integer getYtd() {
		return ytd;
	}
	public void setYtd(Integer ytd) {
		this.ytd = ytd;
	}
	public String getAfpe() {
		return afpe;
	}
	public void setAfpe(String afpe) {
		this.afpe = afpe;
	}
	public String getYoyRolling() {
		return yoyRolling;
	}
	public void setYoyRolling(String yoyRolling) {
		this.yoyRolling = yoyRolling;
	}
	public String getLast_Rescan() {
		return last_Rescan;
	}
	public void setLast_Rescan(String last_Rescan) {
		this.last_Rescan = last_Rescan;
	}
	public Boolean isOnGoing() {
		return onGoing;
	}
	public void setOnGoing(Boolean onGoing) {
		this.onGoing = onGoing;
	}
	public Boolean isArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public Boolean isExist() {
		return exist;
	}
	public void setExist(Boolean exist) {
		this.exist = exist;
	}
	public Date getRkd() {
		return rkd;
	}
	public void setRkd(Date rkd) {
		this.rkd = rkd;
	}
	public Applicazione getApplicazione() {
		return applicazione;
	}
	public void setApplicazione(Applicazione applicazione) {
		this.applicazione = applicazione;
	}
	public AppOwner getAppOwner() {
		return appOwner;
	}
	public void setAppOwner(AppOwner appOwner) {
		this.appOwner = appOwner;
	}
	
	
}

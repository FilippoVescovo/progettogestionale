package it.progettogestionale.web.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rescan")
public class Rescan implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRescan;
	
	@Column(name = "nrescan")
	private Integer nRescan;
	@Column(name = "newob")
	private Integer newOb;
	@Column(name = "py")
	private Integer py;
	@Column(name = "ytd")
	private Integer ytd;
	@Column(name = "afpe")
	private String afpe;
	@Column(name = "yoyrolling")
	private String yoyRolling;
	@Column(name = "last_rescan")
	private String last_Rescan;
	@Column(name = "ongoing")
	private Boolean onGoing;
	@Column(name = "archive")
	private Boolean archive;
	@Column(name = "exist")
	private Boolean exist;
	@Column(name = "rkd")
	private Date rkd;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_idApplicazione")
//	@JsonBackReference
	private Applicazione applicazione;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_idAppOwner")
//	@JsonBackReference
	private AppOwner appOwner;
	
	
	public Rescan() {}
	
	public Rescan(Integer idRescan, Integer nRescan, Integer newOb, Integer py, Integer ytd, String afpe, String yoyRolling,
			String last_Rescan, Boolean onGoing, Boolean archive, Boolean exist, Date rkd, Applicazione applicazione,
			AppOwner appOwner) {
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
	public Boolean getOnGoing() {
		return onGoing;
	}

	public Boolean getArchive() {
		return archive;
	}

	public Boolean getExist() {
		return exist;
	}
	
	
	@Override
	public String toString() {
		return "Rescan [getIdRescan()= " + getIdRescan() + ", getnRescan()= " + getnRescan() + ", getNewOb()= "
				+ getNewOb() + ", getPy()= " + getPy() + ", getYtd()= " + getYtd() + ", getAfpe()= " + getAfpe()
				+ ", getYoyRolling()= " + getYoyRolling() + ", getLast_Rescan()= " + getLast_Rescan() + ", isOnGoing()= "
				+ isOnGoing() + ", isArchive()= " + isArchive() + ", isExist()= " + isExist() + ", getRkd()= " + getRkd()
				+ ", getApplicazione()= " + getApplicazione() + ", getAppOwner()= " + getAppOwner() + ", getOnGoing()= "
				+ getOnGoing() + ", getArchive()= " + getArchive() + ", getExist()= " + getExist() + "]";
	}
}

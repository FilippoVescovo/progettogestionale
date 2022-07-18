package it.progettogestionale.web.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

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
@Table(name = "logfilerescan")
public class LogFileRescan implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLogRescan;
	
	@Column(name = "data")
	private LocalDateTime data;
	@Column(name = "nrescan")
	private Integer nRescan;
	@Column(name = "ongoing")
	private Boolean ongoing;
	@Column(name = "archive")
	private Boolean archive;
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
	@Column(name = "rkd")
	private Date rkd;
	@Column(name = "idpreupdate")
	private Integer idPreUpdate;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idUtente")
//	@JsonBackReference
//	private AppOwner appOwner;
	private Utente utente;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_idRescan")
//	@JsonBackReference
	private Rescan rescan;
	
	
	public LogFileRescan() {}
	
	public LogFileRescan(Integer idLogRescan, LocalDateTime data, Integer nRescan, Boolean ongoing, Boolean archive, Integer newOb,
			Integer py, Integer ytd, String afpe, String yoyRolling, String last_Rescan, Date rkd, Integer idPreUpdate,
			Utente utente, Rescan rescan) {
		this.idLogRescan = idLogRescan;
		this.data = data;
		this.nRescan = nRescan;
		this.ongoing = ongoing;
		this.archive = archive;
		this.newOb = newOb;
		this.py = py;
		this.ytd = ytd;
		this.afpe = afpe;
		this.yoyRolling = yoyRolling;
		this.last_Rescan = last_Rescan;
		this.rkd = rkd;
		this.idPreUpdate = idPreUpdate;
//		this.appOwner = appOwner;
		this.utente = utente;
		this.rescan = rescan;
	}
	
	
	public Integer getIdLogRescan() {
		return idLogRescan;
	}
	public void setIdLogRescan(Integer idLogRescan) {
		this.idLogRescan = idLogRescan;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Integer getnRescan() {
		return nRescan;
	}
	public void setnRescan(Integer nRescan) {
		this.nRescan = nRescan;
	}
	public Boolean isOngoing() {
		return ongoing;
	}
	public void setOngoing(Boolean ongoing) {
		this.ongoing = ongoing;
	}
	public Boolean isArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
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
	public Date getRkd() {
		return rkd;
	}
	public void setRkd(Date rkd) {
		this.rkd = rkd;
	}
	public Integer getIdPreUpdate() {
		return idPreUpdate;
	}
	public void setIdPreUpdate(Integer idPreUpdate) {
		this.idPreUpdate = idPreUpdate;
	}
//	public AppOwner getAppOwner() {
//		return appOwner;
//	}
//
//	public void setAppOwner(AppOwner appOwner) {
//		this.appOwner = appOwner;
//	}
	
	public Rescan getRescan() {
		return rescan;
	}
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public void setRescan(Rescan rescan) {
		this.rescan = rescan;
	}
	
	public Boolean getOngoing() {
		return ongoing;
	}

	public Boolean getArchive() {
		return archive;
	}

	@Override
	public String toString() {
		return "LogFileRescan [getIdLogRescan()=" + getIdLogRescan() + ", getData()=" + getData() + ", getnRescan()="
				+ getnRescan() + ", isOngoing()=" + isOngoing() + ", isArchive()=" + isArchive() + ", getNewOb()="
				+ getNewOb() + ", getPy()=" + getPy() + ", getYtd()=" + getYtd() + ", getAfpe()=" + getAfpe()
				+ ", getYoyRolling()=" + getYoyRolling() + ", getLast_Rescan()=" + getLast_Rescan() + ", getRkd()="
				+ getRkd() + ", getIdPreUpdate()=" + getIdPreUpdate() + ", getRescan()=" + getRescan()
				+ ", getUtente()=" + getUtente() + ", getOngoing()=" + getOngoing() + ", getArchive()=" + getArchive()
				+ "]";
	}

	
//	@Override
//	public String toString() {
//		return "LogFileRescan [getIdLogRescan()=" + getIdLogRescan() + ", getData()=" + getData() + ", getnRescan()="
//				+ getnRescan() + ", isOngoing()=" + isOngoing() + ", isArchive()=" + isArchive() + ", getNewOb()="
//				+ getNewOb() + ", getPy()=" + getPy() + ", getYtd()=" + getYtd() + ", getAfpe()=" + getAfpe()
//				+ ", getYoyRolling()=" + getYoyRolling() + ", getLast_Rescan()=" + getLast_Rescan() + ", getRkd()="
//				+ getRkd() + ", getIdPreUpdate()=" + getIdPreUpdate() + ", getAppOwner()=" + getAppOwner()
//				+ ", getRescan()=" + getRescan() + ", getOngoing()=" + getOngoing() + ", getArchive()=" + getArchive()
//				+ "]";
//	}
	
}

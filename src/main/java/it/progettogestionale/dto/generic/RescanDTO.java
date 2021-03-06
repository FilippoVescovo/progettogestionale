package it.progettogestionale.dto.generic;

import java.sql.Date;
import java.time.LocalDate;

import it.progettogestionale.web.model.Rescan;

public class RescanDTO {
	
	private Integer idRescan;
	private Integer nRescan;
	private Integer newOb;
	private Integer py;
	private Integer ytd;
	private String afpe;
	private String yoyRolling;
	private String last_Rescan;
	private Boolean onGoing;
	private Boolean archive;
	private Boolean exist;
	private LocalDate rkd;
	private Integer intero;
	private Integer applicazione;
	private Integer appOwner;
	
	
	public RescanDTO() {}

	public RescanDTO(Rescan r) {
		idRescan = r.getIdRescan();
		nRescan = r.getnRescan();
		newOb = r.getNewOb();
		py = r.getPy();
		ytd = r.getYtd();
		afpe = r.getAfpe();
		yoyRolling = r.getYoyRolling();
		last_Rescan = r.getLast_Rescan();
		onGoing = r.isOnGoing();
		archive = r.isArchive();
		exist = r.isExist();
		rkd = convertToLocalDateViaSqlDate(r.getRkd());
		intero = r.getIntero();
		if(r.getApplicazione() != null) applicazione = r.getApplicazione().getIdApplicazione();
		if(r.getAppOwner() != null) appOwner = r.getAppOwner().getIdAppOwner();
	}
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
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

	public Boolean getOnGoing() {
		return onGoing;
	}

	public void setOnGoing(Boolean onGoing) {
		this.onGoing = onGoing;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public LocalDate getRkd() {
		return rkd;
	}

	public void setRkd(LocalDate rkd) {
		this.rkd = rkd;
	}
	
	public Integer getIntero() {
		return intero;
	}

	public void setIntero(Integer intero) {
		this.intero = intero;
	}

	public Integer getApplicazione() {
		return applicazione;
	}

	public void setApplicazione(Integer applicazione) {
		this.applicazione = applicazione;
	}

	public Integer getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(Integer appOwner) {
		this.appOwner = appOwner;
	}
}

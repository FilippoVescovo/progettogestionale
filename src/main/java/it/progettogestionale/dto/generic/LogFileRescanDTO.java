package it.progettogestionale.dto.generic;

import java.sql.Date;
import java.time.LocalDateTime;

import it.progettogestionale.web.model.LogFileRescan;

public class LogFileRescanDTO {
	
	private LocalDateTime data;
	private Integer nRescan;
	private Boolean ongoing;
	private Boolean archive;
	private Integer newOb;
	private Integer py;
	private Integer ytd;
	private String afpe;
	private String yoyRolling;
	private String last_Rescan;
	private Date rkd;
	private Integer idPreUpdate;
	private Integer appOwner;
	private Integer rescan;
	
	
	public LogFileRescanDTO() {}
	
	public LogFileRescanDTO(LogFileRescan lfr) {
		data = lfr.getData();
		nRescan = lfr.getnRescan();
		ongoing = lfr.isOngoing();
		archive = lfr.isArchive();
		newOb = lfr.getNewOb();
		py = lfr.getPy();
		ytd = lfr.getYtd();
		afpe = lfr.getAfpe();
		yoyRolling = lfr.getYoyRolling();
		last_Rescan = lfr.getLast_Rescan();
		rkd = lfr.getRkd();
		idPreUpdate = lfr.getIdPreUpdate();
		appOwner = lfr.getAppOwner().getIdAppOwner();
		rescan = lfr.getRescan().getIdRescan();
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

	public Boolean getOngoing() {
		return ongoing;
	}

	public void setOngoing(Boolean ongoing) {
		this.ongoing = ongoing;
	}

	public Boolean getArchive() {
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

	public Integer getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(Integer appOwner) {
		this.appOwner = appOwner;
	}

	public Integer getRescan() {
		return rescan;
	}

	public void setRescan(Integer rescan) {
		this.rescan = rescan;
	}
}

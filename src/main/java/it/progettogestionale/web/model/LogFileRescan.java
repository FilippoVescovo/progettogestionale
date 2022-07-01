package it.progettogestionale.web.model;

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
@Table(name= "logfilerescan")
public class LogFileRescan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLogRescan;
	@Column(name="data")
	private Date data;
	@Column
	private int nRescan;
	@Column
	private boolean ongoing;
	@Column
	private boolean archive;
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
	private Date rkd;
	@Column
	private int idPreUpdate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_idUtente", referencedColumnName = "idUtente")
//	@JsonBackReference
	private Utente utente;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_idRescan", referencedColumnName = "idRescan")
//	@JsonBackReference
	private Rescan rescan;
	
	public LogFileRescan(Integer idLogRescan, Date data, int nRescan, boolean ongoing, boolean archive, Integer newOb,
			Integer py, Integer ytd, String afpe, String yoyRolling, String last_Rescan, Date rkd, int idPreUpdate,
			Utente utente, Rescan rescan) {
		super();
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
		this.utente = utente;
		this.rescan = rescan;
	}
	
	public LogFileRescan() {
		super();
	}
	
	public Integer getIdLogRescan() {
		return idLogRescan;
	}
	public void setIdLogRescan(Integer idLogRescan) {
		this.idLogRescan = idLogRescan;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getnRescan() {
		return nRescan;
	}
	public void setnRescan(int nRescan) {
		this.nRescan = nRescan;
	}
	public boolean isOngoing() {
		return ongoing;
	}
	public void setOngoing(boolean ongoing) {
		this.ongoing = ongoing;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
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
	public int getIdPreUpdate() {
		return idPreUpdate;
	}
	public void setIdPreUpdate(int idPreUpdate) {
		this.idPreUpdate = idPreUpdate;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Rescan getRescan() {
		return rescan;
	}
	public void setRescan(Rescan rescan) {
		this.rescan = rescan;
	}
	@Override
	public String toString() {
		return "LogFileRescan [idLogRescan=" + idLogRescan + ", data=" + data + ", nRescan=" + nRescan + ", ongoing="
				+ ongoing + ", archive=" + archive + ", newOb=" + newOb + ", py=" + py + ", ytd=" + ytd + ", afpe="
				+ afpe + ", yoyRolling=" + yoyRolling + ", last_Rescan=" + last_Rescan + ", rkd=" + rkd
				+ ", idPreUpdate=" + idPreUpdate + ", utente=" + utente + ", rescan=" + rescan + "]";
	}
	
	
}

package it.progettogestionale.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "applicazione")
public class Applicazione implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//	@SequenceGenerator(name = "seq", sequenceName = "*nome sequenza database*", initialValue = 666) 
//	alter sequence *nome sequenza database* restart with 666;(modo alternativo per risolvere)
	private Integer idApplicazione;
	
	@Column(name = "nodoconsole")
	private Integer nodoConsole;
	@Column(name = "launchingmeetingdatagatheringstarting")
	private Time launchingMeetingDataGatheringStarting;
	@Column(name = "avganalysistime")
	private BigDecimal avgAnalysisTime;
	@Column(name = "automationenablingdate")
	private Date automationEnablingDate;
	@Column(name = "done")
	private Boolean done;
	@Column(name = "exist")
	private Boolean exist;
	@Transient
	private Integer intero;
	@Column
	private String nome_App, apmCode, insertedInCastProgram, stakeholderEngagement,
	stakeholderBrief, onBoardingKitDelivery, primaRestitution, ownerOnboarding, ownerAFP, gdsUnit, tecnologia, serverManager,
	soloCMS, macchina, noteOnboarding, fase, afpStatus, pubblicatoDashboard, noteAppOwner,  jiraautomationActivation,
	repoAvailability, automationStatus, automationNotes, greenItIndex, onboardingKitClosing, sourceCodeFinalDelivery,
	linkConfluence, businessCriticality, devMethodology, provider;
	//cascade:serve modificare a cascata tutto cio che � relazionato all'entity,fetch: download dei dati eager tutti lazy quando richiamo il getter
	//@OneToMany(mappedBy = "utente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "applicazione", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JsonManagedReference
//	@JsonIgnore
	private Set<Rescan> rescans;
	
	@ManyToMany(mappedBy = "applicazione", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JsonIgnoreProperties("applicazione")
//	@JsonIgnore
	private Set<AppOwner> owners;
	
	@OneToMany (mappedBy = "applicazione", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JsonManagedReference
//	@JsonIgnore
	private Set<LogFileApp> logFiles;
	
	@OneToMany(mappedBy = "rescan", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JsonManagedReference
//	@JsonIgnore
	private Set<LogFileRescan> logFile;
	
	
	public Applicazione() {}
	
	public Applicazione(Integer idApplicazione, Integer nodoConsole, Time launchingMeetingDataGatheringStarting,
			BigDecimal avgAnalysisTime, Date automationEnablingDate, Boolean done, Boolean exist, Integer intero, String nome_App,
			String apmCode, String insertedInCastProgram, String stakeholderEngagement, String stakeholderBrief,
			String onBoardingKitDelivery, String primaRestitution, String ownerOnboarding, String ownerAFP,
			String gdsUnit, String tecnologia, String serverManager, String soloCMS, String macchina,
			String noteOnboarding, String fase, String afpStatus, String pubblicatoDashboard, String noteAppOwner,
			String jiraautomationActivation, String repoAvailability, String automationStatus, String automationNotes,
			String greenItIndex, String onboardingKitClosing, String sourceCodeFinalDelivery, String linkConfluence,
			String businessCriticality, String devMethodology, String provider, Set<Rescan> rescans,
			Set<AppOwner> owners, Set<LogFileApp> logFiles, Set<LogFileRescan> logFile) {
		this.idApplicazione = idApplicazione;
		this.nodoConsole = nodoConsole;
		this.launchingMeetingDataGatheringStarting = launchingMeetingDataGatheringStarting;
		this.avgAnalysisTime = avgAnalysisTime;
		this.automationEnablingDate = automationEnablingDate;
		this.done = done;
		this.exist = exist;
		this.intero = intero;
		this.nome_App = nome_App;
		this.apmCode = apmCode;
		this.insertedInCastProgram = insertedInCastProgram;
		this.stakeholderEngagement = stakeholderEngagement;
		this.stakeholderBrief = stakeholderBrief;
		this.onBoardingKitDelivery = onBoardingKitDelivery;
		this.primaRestitution = primaRestitution;
		this.ownerOnboarding = ownerOnboarding;
		this.ownerAFP = ownerAFP;
		this.gdsUnit = gdsUnit;
		this.tecnologia = tecnologia;
		this.serverManager = serverManager;
		this.soloCMS = soloCMS;
		this.macchina = macchina;
		this.noteOnboarding = noteOnboarding;
		this.fase = fase;
		this.afpStatus = afpStatus;
		this.pubblicatoDashboard = pubblicatoDashboard;
		this.noteAppOwner = noteAppOwner;
		this.jiraautomationActivation = jiraautomationActivation;
		this.repoAvailability = repoAvailability;
		this.automationStatus = automationStatus;
		this.automationNotes = automationNotes;
		this.greenItIndex = greenItIndex;
		this.onboardingKitClosing = onboardingKitClosing;
		this.sourceCodeFinalDelivery = sourceCodeFinalDelivery;
		this.linkConfluence = linkConfluence;
		this.businessCriticality = businessCriticality;
		this.devMethodology = devMethodology;
		this.provider = provider;
		this.rescans = rescans;
		this.owners = owners;
		this.logFiles = logFiles;
		this.logFile = logFile;
	}
	
	//costruttore con attributi not null
	public Applicazione(String nome_App) {
		super();
		this.nome_App = nome_App;
	}

	public Integer getIdApplicazione() {
		return idApplicazione;
	}
	public void setIdApplicazione(Integer idApplicazione) {
		this.idApplicazione = idApplicazione;
	}
	public Integer getNodoConsole() {
		return nodoConsole;
	}
	public void setNodoConsole(Integer nodoConsole) {
		this.nodoConsole = nodoConsole;
	}
	public Time getLaunchingMeetingDataGatheringStarting() {
		return launchingMeetingDataGatheringStarting;
	}
	public void setLaunchingMeetingDataGatheringStarting(Time launchingMeetingDataGatheringStarting) {
		this.launchingMeetingDataGatheringStarting = launchingMeetingDataGatheringStarting;
	}
	public BigDecimal getAvgAnalysisTime() {
		return avgAnalysisTime;
	}
	public void setAvgAnalysisTime(BigDecimal avgAnalysisTime) {
		this.avgAnalysisTime = avgAnalysisTime;
	}
	public Date getAutomationEnablingDate() {
		return automationEnablingDate;
	}
	public void setAutomationEnablingDate(Date automationEnablingDate) {
		this.automationEnablingDate = automationEnablingDate;
	}
	public Boolean isDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	public Boolean isExist() {
		return exist;
	}
	public void setExist(Boolean exist) {
		this.exist = exist;
	}
	
	public Integer getIntero() {
		return intero;
	}

	public void setIntero(Integer intero) {
		this.intero = intero;
	}

	public String getNome_App() {
		return nome_App;
	}
	public void setNome_App(String nome_App) {
		this.nome_App = nome_App;
	}
	public String getApmCode() {
		return apmCode;
	}
	public void setApmCode(String apmCode) {
		this.apmCode = apmCode;
	}
	public String getInsertedInCastProgram() {
		return insertedInCastProgram;
	}
	public void setInsertedInCastProgram(String insertedInCastProgram) {
		this.insertedInCastProgram = insertedInCastProgram;
	}
	public String getStakeholderEngagement() {
		return stakeholderEngagement;
	}
	public void setStakeholderEngagement(String stakeholderEngagement) {
		this.stakeholderEngagement = stakeholderEngagement;
	}
	public String getStakeholderBrief() {
		return stakeholderBrief;
	}
	public void setStakeholderBrief(String stakeholderBrief) {
		this.stakeholderBrief = stakeholderBrief;
	}
	public String getOnBoardingKitDelivery() {
		return onBoardingKitDelivery;
	}
	public void setOnBoardingKitDelivery(String onBoardingKitDelivery) {
		this.onBoardingKitDelivery = onBoardingKitDelivery;
	}
	public String getPrimaRestitution() {
		return primaRestitution;
	}
	public void setPrimaRestitution(String primaRestitution) {
		this.primaRestitution = primaRestitution;
	}
	public String getOwnerOnboarding() {
		return ownerOnboarding;
	}
	public void setOwnerOnboarding(String ownerOnboarding) {
		this.ownerOnboarding = ownerOnboarding;
	}
	public String getOwnerAFP() {
		return ownerAFP;
	}
	public void setOwnerAFP(String ownerAFP) {
		this.ownerAFP = ownerAFP;
	}
	public String getGdsUnit() {
		return gdsUnit;
	}
	public void setGdsUnit(String gdsUnit) {
		this.gdsUnit = gdsUnit;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getServerManager() {
		return serverManager;
	}
	public void setServerManager(String serverManager) {
		this.serverManager = serverManager;
	}
	public String getSoloCMS() {
		return soloCMS;
	}
	public void setSoloCMS(String soloCMS) {
		this.soloCMS = soloCMS;
	}
	public String getMacchina() {
		return macchina;
	}
	public void setMacchina(String macchina) {
		this.macchina = macchina;
	}
	public String getNoteOnboarding() {
		return noteOnboarding;
	}
	public void setNoteOnboarding(String noteOnboarding) {
		this.noteOnboarding = noteOnboarding;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getAfpStatus() {
		return afpStatus;
	}
	public void setAfpStatus(String afpStatus) {
		this.afpStatus = afpStatus;
	}
	public String getPubblicatoDashboard() {
		return pubblicatoDashboard;
	}
	public void setPubblicatoDashboard(String pubblicatoDashboard) {
		this.pubblicatoDashboard = pubblicatoDashboard;
	}
	public String getNoteAppOwner() {
		return noteAppOwner;
	}
	public void setNoteAppOwner(String noteAppOwner) {
		this.noteAppOwner = noteAppOwner;
	}
	public String getJiraautomationActivation() {
		return jiraautomationActivation;
	}
	public void setJiraautomationActivation(String jiraautomationActivation) {
		this.jiraautomationActivation = jiraautomationActivation;
	}
	public String getRepoAvailability() {
		return repoAvailability;
	}
	public void setRepoAvailability(String repoAvailability) {
		this.repoAvailability = repoAvailability;
	}
	public String getAutomationStatus() {
		return automationStatus;
	}
	public void setAutomationStatus(String automationStatus) {
		this.automationStatus = automationStatus;
	}
	public String getAutomationNotes() {
		return automationNotes;
	}
	public void setAutomationNotes(String automationNotes) {
		this.automationNotes = automationNotes;
	}
	public String getGreenItIndex() {
		return greenItIndex;
	}
	public void setGreenItIndex(String greenItIndex) {
		this.greenItIndex = greenItIndex;
	}
	public String getOnboardingKitClosing() {
		return onboardingKitClosing;
	}
	public void setOnboardingKitClosing(String onboardingKitClosing) {
		this.onboardingKitClosing = onboardingKitClosing;
	}
	public String getSourceCodeFinalDelivery() {
		return sourceCodeFinalDelivery;
	}
	public void setSourceCodeFinalDelivery(String sourceCodeFinalDelivery) {
		this.sourceCodeFinalDelivery = sourceCodeFinalDelivery;
	}
	public String getLinkConfluence() {
		return linkConfluence;
	}
	public void setLinkConfluence(String linkConfluence) {
		this.linkConfluence = linkConfluence;
	}
	public String getBusinessCriticality() {
		return businessCriticality;
	}
	public void setBusinessCriticality(String businessCriticality) {
		this.businessCriticality = businessCriticality;
	}
	public String getDevMethodology() {
		return devMethodology;
	}
	public void setDevMethodology(String devMethodology) {
		this.devMethodology = devMethodology;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public Set<Rescan> getRescans() {
		return rescans;
	}
	public void setRescans(Set<Rescan> rescans) {
		this.rescans = rescans;
	}
	public Set<AppOwner> getOwners() {
		return owners;
	}
	public void setOwners(Set<AppOwner> owners) {
		this.owners = owners;
	}
	public Set<LogFileApp> getLogFiles() {
		return logFiles;
	}
	public void setLogFiles(Set<LogFileApp> logFiles) {
		this.logFiles = logFiles;
	}
	public Set<LogFileRescan> getLogFile() {
		return logFile;
	}
	public void setLogFile(Set<LogFileRescan> logFile) {
		this.logFile = logFile;
	}

	@Override
	public String toString() {
		return "Applicazione [idApplicazione=" + idApplicazione + ", nodoConsole=" + nodoConsole
				+ ", launchingMeetingDataGatheringStarting=" + launchingMeetingDataGatheringStarting
				+ ", avgAnalysisTime=" + avgAnalysisTime + ", automationEnablingDate=" + automationEnablingDate
				+ ", done=" + done + ", exist=" + exist + ", nome_App=" + nome_App + ", apmCode=" + apmCode
				+ ", insertedInCastProgram=" + insertedInCastProgram + ", stakeholderEngagement="
				+ stakeholderEngagement + ", stakeholderBrief=" + stakeholderBrief + ", onBoardingKitDelivery="
				+ onBoardingKitDelivery + ", primaRestitution=" + primaRestitution + ", ownerOnboarding="
				+ ownerOnboarding + ", ownerAFP=" + ownerAFP + ", gdsUnit=" + gdsUnit + ", tecnologia=" + tecnologia
				+ ", serverManager=" + serverManager + ", soloCMS=" + soloCMS + ", macchina=" + macchina
				+ ", noteOnboarding=" + noteOnboarding + ", fase=" + fase + ", afpStatus=" + afpStatus
				+ ", pubblicatoDashboard=" + pubblicatoDashboard + ", noteAppOwner=" + noteAppOwner
				+ ", jiraautomationActivation=" + jiraautomationActivation + ", repoAvailability=" + repoAvailability
				+ ", automationStatus=" + automationStatus + ", automationNotes=" + automationNotes + ", greenItIndex="
				+ greenItIndex + ", onboardingKitClosing=" + onboardingKitClosing + ", sourceCodeFinalDelivery="
				+ sourceCodeFinalDelivery + ", linkConfluence=" + linkConfluence + ", businessCriticality="
				+ businessCriticality + ", devMethodology=" + devMethodology + ", provider=" + provider + ", rescans="
				+ rescans + ", owners=" + owners + ", logFiles=" + logFiles + ", logFile=" + logFile + "]";
	}
	
	
	
}

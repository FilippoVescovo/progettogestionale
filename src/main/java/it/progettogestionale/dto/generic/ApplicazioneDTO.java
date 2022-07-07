package it.progettogestionale.dto.generic;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.progettogestionale.web.model.AppOwner;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.LogFileRescan;
import it.progettogestionale.web.model.Rescan;

public class ApplicazioneDTO {
	
	private Integer idApplicazione;
	private Integer nodoConsole;
	private Time launchingMeetingDataGatheringStarting;
	private BigDecimal avgAnalysisTime;
	private Date automationEnablingDate;
	private Boolean done;
	private Boolean exist;
	private String nome_App, apmCode, insertedInCastProgram, stakeholderEngagement,
	stakeholderBrief, onBoardingKitDelivery, primaRestitution, ownerOnboarding, ownerAFP, gdsUnit, tecnologia, serverManager,
	soloCMS, macchina, noteOnboarding, fase, afpStatus, pubblicatoDashboard, noteAppOwner,  jiraautomationActivation,
	repoAvailability, automationStatus, automationNotes, greenItIndex, onboardingKitClosing, sourceCodeFinalDelivery,
	linkConfluence, businessCriticality, devMethodology, provider;
	private List<Integer> idRescans;
	private List<Integer> idOwners;	
	private List<Integer> idLogFileApp;
	private List<Integer> idLogFileRescan;
	
	public ApplicazioneDTO() {}

	public ApplicazioneDTO(Applicazione l) {
		
		idApplicazione = l.getIdApplicazione();
		nodoConsole = l.getNodoConsole();
		launchingMeetingDataGatheringStarting = l.getLaunchingMeetingDataGatheringStarting();
		avgAnalysisTime = l.getAvgAnalysisTime();
		automationEnablingDate = l.getAutomationEnablingDate();
		done = l.isDone();
		nome_App = l.getNome_App();
		apmCode = l.getApmCode();
		insertedInCastProgram = l.getInsertedInCastProgram();
		stakeholderEngagement = l.getStakeholderEngagement();
		stakeholderBrief = l.getStakeholderBrief();
		onBoardingKitDelivery = l.getOnBoardingKitDelivery();
		primaRestitution =l.getPrimaRestitution();
		ownerOnboarding = l.getOwnerOnboarding();
		ownerAFP = l.getOwnerAFP();
		gdsUnit = l.getGdsUnit();
		tecnologia = l.getTecnologia();
		serverManager = l.getServerManager();
		soloCMS = l.getSoloCMS();
		macchina = l.getMacchina();
		noteOnboarding = l.getNoteOnboarding();
		fase = l.getFase();
		afpStatus = l.getAfpStatus();
		pubblicatoDashboard = l.getPubblicatoDashboard();
		noteAppOwner = l.getNoteAppOwner();
		jiraautomationActivation = l.getJiraautomationActivation();
		repoAvailability = l.getRepoAvailability();
		automationStatus = l.getAutomationStatus();
		automationNotes = l.getAutomationNotes();
		greenItIndex = l.getGreenItIndex();
		onboardingKitClosing = l.getOnboardingKitClosing();
		sourceCodeFinalDelivery = l.getSourceCodeFinalDelivery();
		linkConfluence = l.getLinkConfluence();
		businessCriticality = l.getBusinessCriticality();
		devMethodology = l.getDevMethodology();
		provider = l.getProvider();
		exist = l.isExist();
		idRescans = l.getRescans().stream().map(Rescan::getIdRescan).collect(Collectors.toList());
		idOwners = l.getOwners().stream().map(AppOwner::getIdAppOwner).collect(Collectors.toList());
		idLogFileApp = l.getLogFiles().stream().map(LogFileApp::getIdLogApp).collect(Collectors.toList());
		idLogFileRescan = l.getLogFile().stream().map(LogFileRescan::getIdLogRescan).collect(Collectors.toList());
			
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

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
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

	public List<Integer> getIdRescans() {
		return idRescans;
	}

	public void setIdRescans(List<Integer> idRescans) {
		this.idRescans = idRescans;
	}

	public List<Integer> getIdOwners() {
		return idOwners;
	}

	public void setIdOwners(List<Integer> idOwners) {
		this.idOwners = idOwners;
	}

	public List<Integer> getIdLogFileApp() {
		return idLogFileApp;
	}

	public void setIdLogFileApp(List<Integer> idLogFileApp) {
		this.idLogFileApp = idLogFileApp;
	}

	public List<Integer> getIdLogFileRescan() {
		return idLogFileRescan;
	}

	public void setIdLogFileRescan(List<Integer> idLogFileRescan) {
		this.idLogFileRescan = idLogFileRescan;
	}
	
	
	
	
	
	

}

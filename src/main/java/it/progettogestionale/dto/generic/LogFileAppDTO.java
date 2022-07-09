package it.progettogestionale.dto.generic;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;
import it.progettogestionale.web.model.Utente;

public class LogFileAppDTO {

	private Integer idLogApp;
	private LocalDateTime data;
	private Integer nodoConsole;
	private Time launchingMeetingDataGatheringStarting;
	private BigDecimal avgAnalysisTime;
	private Date automationEnablingDate;
	private Boolean done;
	private Integer idPreUpdate;
	private String nome_App, apmCode, insertedInCastProgram, stakeholderEngagement, stakeholderBrief,
			onBoardingKitDelivery, primaRestitution, ownerOnboarding, ownerAFP, gdsUnit, tecnologia, serverManager,
			soloCMS, macchina, noteOnboarding, fase, afpStatus, pubblicatoDashboard, noteAppOwner,
			jiraautomationActivation, repoAvailability, automationStatus, automationNotes, greenItIndex,
			onboardingKitClosing, sourceCodeFinalDelivery, linkConfluence, businessCriticality, devMethodology,
			provider;
	private Integer idUtente;
	private Integer idApplicazione;

	public LogFileAppDTO() {
	}

	public LogFileAppDTO(LogFileApp l) {
		super();
		idLogApp = l.getIdLogApp();
		data = l.getData();
		nodoConsole = l.getNodoConsole();
		launchingMeetingDataGatheringStarting = l.getLaunchingMeetingDataGatheringStarting();
		avgAnalysisTime = l.getAvgAnalysisTime();
		automationEnablingDate = l.getAutomationEnablingDate();
		done = l.getDone();
		idPreUpdate = l.getIdPreUpdate();
		nome_App = l.getNome_App();
		apmCode = l.getApmCode();
		insertedInCastProgram = l.getInsertedInCastProgram();
		stakeholderEngagement = l.getStakeholderEngagement();
		stakeholderBrief = l.getStakeholderBrief();
		onBoardingKitDelivery = l.getOnBoardingKitDelivery();
		primaRestitution = l.getPrimaRestitution();
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
		idUtente = l.getUtente().getIdUtente();
		idApplicazione = l.getApplicazione().getIdApplicazione();
	}

	public Integer getIdLogApp() {
		return idLogApp;
	}

	public void setIdLogApp(Integer idLogApp) {
		this.idLogApp = idLogApp;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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

	public Integer getIdPreUpdate() {
		return idPreUpdate;
	}

	public void setIdPreUpdate(Integer idPreUpdate) {
		this.idPreUpdate = idPreUpdate;
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

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public Integer getIdApplicazione() {
		return idApplicazione;
	}

	public void setIdApplicazione(Integer idApplicazione) {
		this.idApplicazione = idApplicazione;
	}

	@Override
	public String toString() {
		return "LogFileAppDTO [getIdLogApp()=" + getIdLogApp() + ", getData()=" + getData() + ", getNodoConsole()="
				+ getNodoConsole() + ", getLaunchingMeetingDataGatheringStarting()="
				+ getLaunchingMeetingDataGatheringStarting() + ", getAvgAnalysisTime()=" + getAvgAnalysisTime()
				+ ", getAutomationEnablingDate()=" + getAutomationEnablingDate() + ", getDone()=" + getDone()
				+ ", getIdPreUpdate()=" + getIdPreUpdate() + ", getNome_App()=" + getNome_App() + ", getApmCode()="
				+ getApmCode() + ", getInsertedInCastProgram()=" + getInsertedInCastProgram()
				+ ", getStakeholderEngagement()=" + getStakeholderEngagement() + ", getStakeholderBrief()="
				+ getStakeholderBrief() + ", getOnBoardingKitDelivery()=" + getOnBoardingKitDelivery()
				+ ", getPrimaRestitution()=" + getPrimaRestitution() + ", getOwnerOnboarding()=" + getOwnerOnboarding()
				+ ", getOwnerAFP()=" + getOwnerAFP() + ", getGdsUnit()=" + getGdsUnit() + ", getTecnologia()="
				+ getTecnologia() + ", getServerManager()=" + getServerManager() + ", getSoloCMS()=" + getSoloCMS()
				+ ", getMacchina()=" + getMacchina() + ", getNoteOnboarding()=" + getNoteOnboarding() + ", getFase()="
				+ getFase() + ", getAfpStatus()=" + getAfpStatus() + ", getPubblicatoDashboard()="
				+ getPubblicatoDashboard() + ", getNoteAppOwner()=" + getNoteAppOwner()
				+ ", getJiraautomationActivation()=" + getJiraautomationActivation() + ", getRepoAvailability()="
				+ getRepoAvailability() + ", getAutomationStatus()=" + getAutomationStatus() + ", getAutomationNotes()="
				+ getAutomationNotes() + ", getGreenItIndex()=" + getGreenItIndex() + ", getOnboardingKitClosing()="
				+ getOnboardingKitClosing() + ", getSourceCodeFinalDelivery()=" + getSourceCodeFinalDelivery()
				+ ", getLinkConfluence()=" + getLinkConfluence() + ", getBusinessCriticality()="
				+ getBusinessCriticality() + ", getDevMethodology()=" + getDevMethodology() + ", getProvider()="
				+ getProvider() + ", getIdUtente()=" + getIdUtente() + ", getIdApplicazione()=" + getIdApplicazione()
				+ "]";
	}
	
	

}

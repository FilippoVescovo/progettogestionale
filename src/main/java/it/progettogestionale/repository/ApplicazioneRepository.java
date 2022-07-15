package it.progettogestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileApp;

public interface ApplicazioneRepository extends CrudRepository<Applicazione, Integer> {
	
	@Modifying
	@Transactional
	@Query("update Applicazione a set a.exist = false where a.idApplicazione = ?1")
	public void logicDelete(int id);
	
	@Modifying
	@Transactional
	@Query("update Applicazione a set a.exist = true where a.idApplicazione = ?1")
	public void recuperoApp(int id);
	
	@Query(value = "SELECT idlogapp FROM LogFileApp WHERE fk_idapp = ?1 ORDER BY data DESC LIMIT 1", nativeQuery = true)
	public List<Integer> lastDate(int id);
	
	@Query(value = "SELECT fk_idappowner FROM monitoraggio WHERE fk_idapplicazione = ?1 ", nativeQuery = true)
	public Integer recuperoIdAppOwner (int id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO monitoraggio (fk_idapplicazione, fk_idappowner) VALUES (?1, ?2)", nativeQuery = true)
	public void inserimentoMonitoraggio(int idapplicazione, int idappowner);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM monitoraggio WHERE fk_idapplicazione = ?1 AND fk_idappowner = ?2", nativeQuery = true)
	public void rimozioneOwner(int idapplicazione, int idappowner);
	
}

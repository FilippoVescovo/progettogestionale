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
	
	@Modifying
	@Transactional
	@Query(value = "SELECT idlogapp FROM LogFileApp l WHERE l.fk_idapp = ?1 ORDER BY data DESC LIMIT 1", nativeQuery = true)
	public List<LogFileApp> lastDate(int id);
}

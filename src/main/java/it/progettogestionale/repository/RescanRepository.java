package it.progettogestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.progettogestionale.web.model.Rescan;

public interface RescanRepository extends CrudRepository<Rescan, Integer>{
	
//	@Query(value = "SELECT id FROM logfilerescan WHERE fk_idrescan = ?1 ORDER BY idlogrescan DESC LIMIT 1", nativeQuery = true)
//	public List<Integer> lastRescan (int id);
	
	@Query(value = "SELECT nrescan FROM rescan WHERE fk_idapplicazione = ?1 ORDER BY nrescan DESC LIMIT 1", nativeQuery = true)
	public List<Integer> lastRescan (int id);
	
	@Query(value = "SELECT idlogrescan FROM logfilerescan WHERE fk_idrescan = ?1 ORDER BY data DESC LIMIT 1", nativeQuery = true)
	public List<Integer> lastLog(int id);
}

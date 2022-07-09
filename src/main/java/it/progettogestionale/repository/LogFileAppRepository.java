package it.progettogestionale.repository;

import org.springframework.data.repository.CrudRepository;

import it.progettogestionale.dto.generic.LogFileAppDTO;
import it.progettogestionale.web.model.LogFileApp;

public interface LogFileAppRepository extends CrudRepository<LogFileApp, Integer> {


}

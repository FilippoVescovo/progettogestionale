package it.progettogestionale.web.dao;
import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.LogFileRescan;

public interface ApplicazioneDao {
	public Applicazione getById(int i);
	public void add(Applicazione a);
	public void update(Applicazione a);
	public void delete(int id);
}

package it.progettogestionale.dto.generic;

import it.progettogestionale.web.model.Applicazione;
import it.progettogestionale.web.model.Utente;

public class ModificaAppDTO {
	
	private Integer idApplicazione;
	private Integer idUtente;
	
	
	public ModificaAppDTO() {}
	
	public ModificaAppDTO(Applicazione a, Utente u) {
		idApplicazione = a.getIdApplicazione();
		idUtente = u.getIdUtente();
	}

	
	public Integer getIdApplicazione() {
		return idApplicazione;
	}

	public void setIdApplicazione(Integer idApplicazione) {
		this.idApplicazione = idApplicazione;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	
	
}

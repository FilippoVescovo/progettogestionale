package it.progettogestionale.dto.response;

import java.util.ArrayList;
import java.util.List;

import it.progettogestionale.dto.generic.UtenteDTO;
import it.progettogestionale.web.model.Utente;

public class GetUtenteResponseDTO {
	private List<UtenteDTO> utenti;

	
	public GetUtenteResponseDTO() {}
	
	public GetUtenteResponseDTO(List<Utente> u) {
		utenti=new ArrayList<>();
		for(Utente u1 : u) {
			utenti.add(new UtenteDTO(u1));
		}
	}

	
	public List<UtenteDTO> getUtenti() {
		return utenti;
	}
	public void setUtenti(List<UtenteDTO> utenti) {
		this.utenti = utenti;
	}
}

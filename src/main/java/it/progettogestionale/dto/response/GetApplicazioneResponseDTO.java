package it.progettogestionale.dto.response;

import java.util.ArrayList;
import java.util.List;

import it.progettogestionale.dto.generic.ApplicazioneDTO;
import it.progettogestionale.web.model.Applicazione;

public class GetApplicazioneResponseDTO {

	private List<ApplicazioneDTO> lista;

	public GetApplicazioneResponseDTO() {
		
		
	}

	public GetApplicazioneResponseDTO(Iterable<Applicazione> l) {
		lista = new ArrayList<>();
		for(Applicazione a:l) {
			lista.add(new ApplicazioneDTO(a));
		}
	}

	public List<ApplicazioneDTO> getLista() {
		return lista;
	}

	public void setLista(List<ApplicazioneDTO> lista) {
		this.lista = lista;
	}
	
	
	
	
}

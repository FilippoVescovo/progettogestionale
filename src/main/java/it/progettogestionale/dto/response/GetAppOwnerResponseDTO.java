package it.progettogestionale.dto.response;

import java.util.ArrayList;
import java.util.List;

import it.progettogestionale.dto.generic.AppOwnerDTO;
import it.progettogestionale.dto.generic.ApplicazioneDTO;
import it.progettogestionale.web.model.AppOwner;

public class GetAppOwnerResponseDTO {
	private List<AppOwnerDTO> lista;

	public GetAppOwnerResponseDTO() {}

	public GetAppOwnerResponseDTO(Iterable<AppOwner> l) {
		lista = new ArrayList<>();
		for(AppOwner a:l) {
			lista.add(new AppOwnerDTO(a));
		}
	}

	public List<AppOwnerDTO> getLista() {
		return lista;
	}

	public void setLista(List<AppOwnerDTO> lista) {
		this.lista = lista;
	}
	
	

	
}

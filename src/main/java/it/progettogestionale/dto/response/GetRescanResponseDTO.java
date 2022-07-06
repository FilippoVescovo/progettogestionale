package it.progettogestionale.dto.response;

import java.util.ArrayList;
import java.util.List;

import it.progettogestionale.dto.generic.RescanDTO;
import it.progettogestionale.web.model.Rescan;

public class GetRescanResponseDTO {
	List<RescanDTO> lista;

	
	public GetRescanResponseDTO() {}

	public GetRescanResponseDTO(Iterable<Rescan> iRescan) {
		lista = new ArrayList<>();
		for(Rescan r : iRescan) {
			lista.add(new RescanDTO(r));
		}
	}

	
	public List<RescanDTO> getLista() {
		return lista;
	}

	public void setLista(List<RescanDTO> lista) {
		this.lista = lista;
	}
}

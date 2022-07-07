package it.progettogestionale.dto.response;

import java.util.ArrayList;
import java.util.List;

import it.progettogestionale.dto.generic.LogFileRescanDTO;
import it.progettogestionale.web.model.LogFileRescan;

public class GetLogFileRescanResponseDTO {

	List<LogFileRescanDTO> lista;

	
	public GetLogFileRescanResponseDTO() {}
	
	public GetLogFileRescanResponseDTO(Iterable<LogFileRescan> logs) {
		lista = new ArrayList<>();
		for(LogFileRescan lfr : logs) {
			lista.add(new LogFileRescanDTO(lfr));
		}
	}

	
	public List<LogFileRescanDTO> getLista() {
		return lista;
	}

	public void setLista(List<LogFileRescanDTO> lista) {
		this.lista = lista;
	}
}

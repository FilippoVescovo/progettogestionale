package it.progettogestionale.dto.response;

import java.util.ArrayList;
import java.util.List;

import it.progettogestionale.dto.generic.LogFileAppDTO;
import it.progettogestionale.web.model.LogFileApp;

public class GetLogFileAppResposeDTO {
	
	private List<LogFileAppDTO> lista;
	
	public GetLogFileAppResposeDTO() {}
	
	public GetLogFileAppResposeDTO(Iterable<LogFileApp> i) {
		lista = new ArrayList<>();
		for(LogFileApp l:i) {
			lista.add(new LogFileAppDTO(l));
		}
	}

	public List<LogFileAppDTO> getLista() {
		return lista;
	}

	public void setLista(List<LogFileAppDTO> lista) {
		this.lista = lista;
	}
	
	
}

package it.prova.coge_be.service.rapportino;

import java.util.List;

import it.prova.coge_be.model.Rapportino;

public interface RapportinoService {
	
public List<Rapportino> listAll();
	
	public Rapportino caricaSingoloElemento(Long id);
	
	public Rapportino inserisciNuovo(Rapportino rapportinoInstance);
	
	public Rapportino aggiorna(Rapportino rapportinoInstance);
	
	public void rimuovi(Long idToDelete);
}

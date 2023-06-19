package it.prova.coge_be.service.commessa;

import java.util.List;

import it.prova.coge_be.model.Commessa;

public interface CommessaService {
	public List<Commessa> listAll();
	
	public Commessa caricaSingoloElemento(Long id);
	
	public Commessa inserisciNuovo(Commessa commessaInstance);
	
	public Commessa aggiorna(Commessa commessaInstance);
	
	public void rimuovi(Long idToDelete);
}

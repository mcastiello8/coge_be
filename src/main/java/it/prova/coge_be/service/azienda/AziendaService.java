package it.prova.coge_be.service.azienda;

import java.util.List;

import it.prova.coge_be.model.Azienda;


public interface AziendaService {
	
	public List<Azienda> listAll();

	public Azienda caricaSingolo(Long id);

	public Azienda aggiorna(Azienda aziendaInstance);

	public Azienda inserisciNuovo(Azienda aziendaInstance);

	public void rimuovi(Azienda aziendaInstance);

}

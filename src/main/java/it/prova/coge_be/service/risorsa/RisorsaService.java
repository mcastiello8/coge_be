package it.prova.coge_be.service.risorsa;

import java.util.List;

import it.prova.coge_be.model.Risorsa;


public interface RisorsaService {
	
	public List<Risorsa> listAllElements();
	
	public List<Risorsa> listAllElementsEager();
	
	public List<Risorsa> listAllElementsEagerWithCommesse();
	
	public List<Risorsa> listAllElementsEagerWithAttachment();

	public Risorsa caricaSingoloElemento(Long id);
	
	public Risorsa caricaSingoloElementoEager(Long id);
	
	public Risorsa caricaSingoloElementoEagerWithCommesse(Long id);
	
	public Risorsa caricaSingoloElementoEagerWithAttachment(Long id);

	public Risorsa aggiorna(Risorsa entityInstance);

	public Risorsa inserisciNuovo(Risorsa entityInstance);

	public void rimuoviById(Long idToRemove);

}

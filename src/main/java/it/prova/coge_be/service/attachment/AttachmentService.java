package it.prova.coge_be.service.attachment;

import java.util.List;

import it.prova.coge_be.model.Attachment;


public interface AttachmentService {
	public List<Attachment> listAllElements();

	public Attachment caricaSingoloElemento(Long id);

	public void aggiorna(Attachment entityInstance);

	public void inserisciNuovo(Attachment entityInstance);

	public void rimuoviById(Long idToRemove);

}

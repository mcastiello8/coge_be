package it.prova.coge_be.service.attachment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.coge_be.model.Attachment;
import it.prova.coge_be.repository.attachment.AttachmentRepository;

@Service
@Transactional(readOnly = true)
public class AttachmentServiceImpl implements AttachmentService{

	@Autowired
	private AttachmentRepository repository;

	@Override
	public List<Attachment> listAllElements() {
		return (List<Attachment>) repository.findAll();
	}

	@Override
	public Attachment caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void aggiorna(Attachment entityInstance) {
		repository.save(entityInstance);
		
	}

	@Override
	@Transactional
	public void inserisciNuovo(Attachment entityInstance) {
		entityInstance.setDataCreazione(LocalDate.now());
		repository.save(entityInstance);
	}

	@Override
	@Transactional
	public void rimuoviById(Long idToRemove) {
		repository.deleteById(idToRemove);
	}
}

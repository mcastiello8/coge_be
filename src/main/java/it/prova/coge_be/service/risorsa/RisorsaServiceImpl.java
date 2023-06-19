package it.prova.coge_be.service.risorsa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.coge_be.model.Risorsa;
import it.prova.coge_be.repository.risorsa.RisorsaRepository;

@Service
@Transactional(readOnly = true)
public class RisorsaServiceImpl implements RisorsaService{

	
	@Autowired
	private RisorsaRepository repository;

	@Override
	public List<Risorsa> listAllElements() {
		return (List<Risorsa>) repository.findAll();
	}

	@Override
	public Risorsa caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Risorsa aggiorna(Risorsa entityInstance) {
		return repository.save(entityInstance);
		
	}

	@Override
	@Transactional
	public Risorsa inserisciNuovo(Risorsa entityInstance) {
		return repository.save(entityInstance);
	}

	@Override
	@Transactional
	public void rimuoviById(Long idToRemove) {
		repository.deleteById(idToRemove);
	}

	@Override
	public List<Risorsa> listAllElementsEagerWithCommesse() {
		return repository.getAllEagerWithCommesse();
	}

	@Override
	public List<Risorsa> listAllElementsEagerWithAttachment() {
		return repository.getAllEagerWithAttachment();
	}

	@Override
	public List<Risorsa> listAllElementsEager() {
		return repository.getAllEager();
	}

	@Override
	public Risorsa caricaSingoloElementoEager(Long id) {
		return repository.getSingleEager(id);
	}

	@Override
	public Risorsa caricaSingoloElementoEagerWithCommesse(Long id) {
		return repository.getSingleEagerWithCommesse(id);
	}

	@Override
	public Risorsa caricaSingoloElementoEagerWithAttachment(Long id) {
		return repository.getSingleEagerWithAttachment(id);
	}
}

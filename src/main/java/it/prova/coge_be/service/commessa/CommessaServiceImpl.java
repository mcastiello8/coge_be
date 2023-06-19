package it.prova.coge_be.service.commessa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.coge_be.model.Commessa;
import it.prova.coge_be.repository.commessa.CommessaRepository;

@Service
@Transactional(readOnly = true)
public class CommessaServiceImpl implements CommessaService {
	
	@Autowired
	private CommessaRepository repository;

	@Override
	public List<Commessa> listAll() {
		
		return (List<Commessa>) repository.findAll();
	}

	@Override
	public Commessa caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Commessa inserisciNuovo(Commessa commessaInstance) {
		return repository.save(commessaInstance);
	}

	@Override
	@Transactional
	public Commessa aggiorna(Commessa commessaInstance) {
		return repository.save(commessaInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Long idToDelete) {
		repository.deleteById(idToDelete);
		
	}

}

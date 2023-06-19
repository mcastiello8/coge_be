package it.prova.coge_be.web.api.azienda;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.coge_be.dto.azienda.AziendaDTO;
import it.prova.coge_be.model.Azienda;
import it.prova.coge_be.service.azienda.AziendaService;

@RestController
@RequestMapping("api/azienda")
@CrossOrigin
public class AziendaController {
	
	
	@Autowired
	private AziendaService aziendaService;
	
	@GetMapping
	public List<AziendaDTO> getAll() {
		return AziendaDTO.createAziendaDTOListFromModelList(aziendaService.listAll(),false);
	}
	
	@GetMapping("/{id}")
	public AziendaDTO caricaSingolo(@PathVariable(required = true) Long id) {
		return AziendaDTO.buildAziendaDTOFromModel(aziendaService.caricaSingolo(id), false);
	}	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AziendaDTO inserisciNuovo(@Valid @RequestBody AziendaDTO aziendaInstance) {

//		if (aziendaInstance.getId() != null)
//			throw new IdNotNullForInsertException("impossibile creare un id per la creazione.");

		return AziendaDTO.buildAziendaDTOFromModel(aziendaService.inserisciNuovo(aziendaInstance.buildAziendaModel()), false);

	}
	
	

	@PutMapping("/{id}")
	public AziendaDTO update(@Valid @RequestBody AziendaDTO aziendaInstance) {
		

		return AziendaDTO.buildAziendaDTOFromModel(aziendaService.aggiorna(aziendaInstance.buildAziendaModel()),false);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true) Long id) {
		Azienda aziendaDaEliminare = aziendaService.caricaSingolo(id);
		
//
//		if (aziendaDaEliminare == null)
//			throw new DottoreNotFoundException("non è stato trovato alcun dottore.");

		
		AziendaDTO.buildAziendaDTOFromModel(aziendaDaEliminare, false);
	}
	
	
	
	

}

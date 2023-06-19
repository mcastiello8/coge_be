package it.prova.coge_be.web.api.commessa;

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

import it.prova.coge_be.dto.commessa.CommessaDTO;
import it.prova.coge_be.model.Commessa;
import it.prova.coge_be.service.commessa.CommessaService;

@RestController
@RequestMapping("api/commessa")
@CrossOrigin
public class CommessaController {
	
	@Autowired
	private CommessaService commessaService;
	
	
	@GetMapping
	public List<CommessaDTO> visualizzaCommesse(){
		return CommessaDTO.createCommessaDTOListFromModelList(commessaService.listAll(), true, false);
		
	}
	
	@GetMapping("/{id}")
	public CommessaDTO visualizza (@PathVariable(required = true) Long id) {
		return CommessaDTO.buildCommessaDTOFromModel(commessaService.caricaSingoloElemento(id), false, false);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommessaDTO createNew(@Valid @RequestBody CommessaDTO commessaInput) {
		
		
		Commessa commessaInserita = commessaService.inserisciNuovo(commessaInput.buildCommessaModel());
		return CommessaDTO.buildCommessaDTOFromModel(commessaInserita, true, false);
	}
	
	@PutMapping("{id}")
	public CommessaDTO update (@Valid @RequestBody CommessaDTO commessaInput, @PathVariable(required = true) Long id) {
		Commessa commessa = commessaService.caricaSingoloElemento(id);
		
		if(commessa == null) {
			throw new RuntimeException();
		}
		
		commessaInput.setId(id);
		
		Commessa commessaAggiornata = commessaService.aggiorna(commessaInput.buildCommessaModel());
		
		return CommessaDTO.buildCommessaDTOFromModel(commessaAggiornata, false, false);
	
    }
	
		@DeleteMapping("{id}")
	public void delete(@PathVariable(required = true) Long id) {
		commessaService.rimuovi(id);
	}
	
}

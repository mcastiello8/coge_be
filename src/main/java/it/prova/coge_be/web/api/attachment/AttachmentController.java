package it.prova.coge_be.web.api.attachment;

import java.util.List;

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

import it.prova.coge_be.dto.attachment.AttachmentDTO;
import it.prova.coge_be.model.Attachment;
import it.prova.coge_be.service.attachment.AttachmentService;

@RestController
@RequestMapping("/api/attachment")
@CrossOrigin
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;

	@GetMapping
	public List<AttachmentDTO> getAll() {
		return AttachmentDTO.createAttachmentDTOListFromModelList(attachmentService.listAllElements(), true);
	}

	@PutMapping("/{id}")
	public AttachmentDTO getSingle(@PathVariable(required = true, value = "id") Long id) {
		return AttachmentDTO.buildAttachmentDTOFromModel(attachmentService.caricaSingoloElemento(id), false);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AttachmentDTO createNew(@RequestBody AttachmentDTO attachmentDTO) {
		Attachment attachmentTransient = attachmentDTO.buildModelFromDTO();
		attachmentService.inserisciNuovo(attachmentTransient);
		return AttachmentDTO.buildAttachmentDTOFromModel(attachmentTransient, false);
	}

	@PutMapping("/edit//{id}")
	@ResponseStatus(HttpStatus.OK)
	public AttachmentDTO update(@RequestBody AttachmentDTO attachmentDTO,
			@PathVariable(required = true, value = "id") Long id) {
		attachmentDTO.setId(id);
		attachmentService.aggiorna(attachmentDTO.buildModelFromDTO());
		Attachment allegato = attachmentService.caricaSingoloElemento(id);
		return AttachmentDTO.buildAttachmentDTOFromModel(allegato, false);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true, value = "id") Long id) {
		attachmentService.rimuoviById(id);
	}
}

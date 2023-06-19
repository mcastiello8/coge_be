package it.prova.coge_be.dto.attachment;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import it.prova.coge_be.dto.risorsa.RisorsaDTO;
import it.prova.coge_be.model.Attachment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttachmentDTO {

	private Long id;
	private String fileName;
	private String contentType;
	private String descrizione;
	private LocalDate dataCreazione;

	private byte[] payload;

	private RisorsaDTO risorsa;

	public Attachment buildModelFromDTO() {
		return Attachment.builder().id(this.id).fileName(this.fileName).contentType(this.contentType)
				.descrizione(this.descrizione).dataCreazione(this.dataCreazione).payload(this.payload)
				.build();
	}

	public static AttachmentDTO buildAttachmentDTOFromModel(Attachment attachmentModel, boolean includeRisorsa) {
		AttachmentDTO result = AttachmentDTO.builder().id(attachmentModel.getId())
				.contentType(attachmentModel.getContentType()).descrizione(attachmentModel.getDescrizione())
				.dataCreazione(attachmentModel.getDataCreazione()).payload(attachmentModel.getPayload())
				.build();
		if (includeRisorsa) {
			result.setRisorsa(RisorsaDTO.buildRisorsaDTOFromModel(attachmentModel.getRisorsa(), includeRisorsa,false));
		}
		return result;
	}

	public static List<AttachmentDTO> createAttachmentDTOListFromModelList(List<Attachment> modelListInput,boolean includeRisorsa) {
		return modelListInput.stream().map(attachmentItem -> {
			return AttachmentDTO.buildAttachmentDTOFromModel(attachmentItem,includeRisorsa);
		}).collect(Collectors.toList());
	}
}

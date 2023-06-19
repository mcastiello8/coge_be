package it.prova.coge_be.dto.risorsa;

import java.time.LocalDate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.coge_be.dto.attachment.AttachmentDTO;
import it.prova.coge_be.dto.commessa.CommessaDTO;
import it.prova.coge_be.model.Risorsa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RisorsaDTO {

	private Long id;

	@NotBlank(message = "{nome.notblank}")
	private String nome;// obbligatoria

	@NotBlank(message = "{cognome.notblank}")
	private String cognome;// obbligatoria

	private LocalDate dataIn;

	private LocalDate dataOut;

	@NotBlank(message = "{cf.notblank}")
	private String cf;// obbligatoria

	private String email;

	private Integer costoGiornaliero;

	private AttachmentDTO cv;

	private List<CommessaDTO> commesse;

	public Risorsa buildModelFromDTO() {
		return Risorsa.builder().id(this.id).nome(this.nome).cognome(this.cognome).dataIn(this.dataIn)
				.dataOut(this.dataOut).cf(this.cf).email(this.email).costoGiornaliero(this.costoGiornaliero)
				.build();
	}

	public static RisorsaDTO buildRisorsaDTOFromModel(Risorsa risorsaModel, boolean includeCv,
			boolean includesCommesse) {
		RisorsaDTO result = RisorsaDTO.builder().id(risorsaModel.getId()).nome(risorsaModel.getNome())
				.cognome(risorsaModel.getCognome()).dataIn(risorsaModel.getDataIn()).dataOut(risorsaModel.getDataOut())
				.cf(risorsaModel.getCf()).email(risorsaModel.getEmail())
				.costoGiornaliero(risorsaModel.getCostoGiornaliero()).build();
		if (includeCv) {
			result.setCv(AttachmentDTO.buildAttachmentDTOFromModel(risorsaModel.getCv(),includeCv));
		}
		if (includesCommesse) {
			result.setCommesse(CommessaDTO.createCommessaDTOListFromModelSet(risorsaModel.getCommesse(),false,false));
		}
		return result;
	}

	public static List<RisorsaDTO> createRisorsaDTOListFromModelList(List<Risorsa> modelListInput, boolean includeCv,
			boolean includesCommesse) {
		return modelListInput.stream().map(risorsaItem -> {
			return RisorsaDTO.buildRisorsaDTOFromModel(risorsaItem,includeCv,includesCommesse);
		}).collect(Collectors.toList());
	}

	public static List<RisorsaDTO> createRisorsaDTOListFromModelSet(Set<Risorsa> modelListInput, boolean includeCv,
			boolean includesCommesse) {
		return modelListInput.stream().map(risorsaItem -> {
			return RisorsaDTO.buildRisorsaDTOFromModel(risorsaItem,includeCv,includesCommesse);
		}).collect(Collectors.toList());
	}

	public static Set<Risorsa> createRisorsaSetFromDTOList(List<RisorsaDTO> modelListInput) {
		return modelListInput.stream().map(risorsaItem -> {
			return risorsaItem.buildModelFromDTO();
		}).collect(Collectors.toSet());
	}

}

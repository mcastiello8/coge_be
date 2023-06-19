package it.prova.coge_be.dto.commessa;

import java.time.LocalDate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.coge_be.dto.azienda.AziendaDTO;
import it.prova.coge_be.dto.risorsa.RisorsaDTO;
import it.prova.coge_be.model.Commessa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Json include, se un dato è nullo non cerrà messo nell'output
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommessaDTO {

	private Long id;

	@NotBlank(message = "{descrizione.notblank}")
	private String descrizione;

	@NotBlank(message = "{codice.notblank}")
	private String codice;

	@NotNull(message = "{dataIn.notnull}")
	private LocalDate dataIn;
	@NotNull(message = "{dataOut.notnull}")
	private LocalDate dataOut;

	@NotNull(message = "{importo.notnull}")
	@Min(0)
	private Double importo;

	private AziendaDTO azienda;

	private List<RisorsaDTO> risorse;

	public Commessa buildCommessaModel() {
		Commessa result = Commessa.builder().id(this.id).descrizione(this.descrizione).codice(this.codice)
				.dataIn(this.dataIn).dataOut(this.dataOut).importo(this.importo).azienda(this.azienda.buildAziendaModel())
				.build();
		return result;
	}

	public static CommessaDTO buildCommessaDTOFromModel(Commessa commessaModel, boolean includeAzienda, boolean includeRisorse) {

		CommessaDTO result = CommessaDTO.builder().id(commessaModel.getId()).descrizione(commessaModel.getDescrizione())
				.codice(commessaModel.getCodice()).dataIn(commessaModel.getDataIn()).dataOut(commessaModel.getDataOut())
				.importo(commessaModel.getImporto()).build();
		if(includeAzienda) {
			result.setAzienda(AziendaDTO.buildAziendaDTOFromModel(commessaModel.getAzienda(), true));
		}
		if(includeRisorse) {
			result.setRisorse(RisorsaDTO.createRisorsaDTOListFromModelSet(commessaModel.getRisorse(), false, false));
		}
		return result;
	}

	public static List<CommessaDTO> createCommessaDTOListFromModelList(List<Commessa> modelListInput,boolean includeAzienda, boolean includeRisorse ) {
		return modelListInput.stream().map(inputEntity -> {
			return CommessaDTO.buildCommessaDTOFromModel(inputEntity,includeAzienda, includeRisorse);
		}).collect(Collectors.toList());
	}

	public static Set<CommessaDTO> createCommessaDTOSetFromModelSet(Set<Commessa> modelListInput, boolean includeAzienda, boolean includeRisorse) {
		return modelListInput.stream().map(commessaItem -> {
			return CommessaDTO.buildCommessaDTOFromModel(commessaItem, includeAzienda, includeRisorse);
		}).collect(Collectors.toSet());
	}

	public static List<CommessaDTO> createCommessaDTOListFromModelSet(Set<Commessa> modelListInput, boolean includeAzienda, boolean includeRisorse) {
		return modelListInput.stream().map(commessaItem -> {
			return CommessaDTO.buildCommessaDTOFromModel(commessaItem, includeAzienda, includeRisorse);
		}).collect(Collectors.toList());
	}

	public static Set<Commessa> createCommessaSetFromDTOList(List<CommessaDTO> modelListInput) {
		return modelListInput.stream().map(commessaItem -> {
			return commessaItem.buildCommessaModel();
		}).collect(Collectors.toSet());
	}
	
	
	
//	//public static List<RisorsaDTO> createRisorsaDTOListFromModelList(List<Risorsa> modelListInput, boolean includeCv,
//	boolean includesCommesse) {
//return modelListInput.stream().map(risorsaItem -> {
//	return RisorsaDTO.buildRisorsaDTOFromModel(risorsaItem,includeCv,includesCommesse);
//}).collect(Collectors.toList());
//}
//
//public static List<RisorsaDTO> createRisorsaDTOListFromModelSet(Set<Risorsa> modelListInput, boolean includeCv,
//	boolean includesCommesse) {
//return modelListInput.stream().map(risorsaItem -> {
//	return RisorsaDTO.buildRisorsaDTOFromModel(risorsaItem,includeCv,includesCommesse);
//}).collect(Collectors.toList());
//}
}

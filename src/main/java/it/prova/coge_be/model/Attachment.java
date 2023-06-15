package it.prova.coge_be.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="attachment")
public class Attachment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "fileName")
	private String fileName;
	@Column(name = "contentType")
	private String contentType;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "dataCreazione")
	private LocalDate dataCreazione;
	@Lob
	private byte[] payload;
	
	@OneToOne
    @JoinColumn(name = "risorsa_id")
    private Risorsa risorsa;
	
	
}

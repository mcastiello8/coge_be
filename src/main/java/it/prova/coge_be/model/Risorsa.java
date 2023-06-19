package it.prova.coge_be.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "risorsa")
public class Risorsa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "data_in")
	private LocalDate dataIn;
	@Column(name = "data_out")
	private LocalDate dataOut;
	@Column(name = "cf")
	private String cf;
	@Column(name = "email")
	private String email;
	@Column(name = "costogiornaliero")
	private Integer costoGiornaliero;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Attachment cv;
	
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "risorse")
	private Set<Commessa> commesse = new HashSet<>();
	
}

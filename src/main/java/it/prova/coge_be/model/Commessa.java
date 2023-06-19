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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "commessa")
public class Commessa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codice")
	private String codice;
	@Column(name = "data_in")
	private LocalDate dataIn;
	@Column(name = "data_out")
	private LocalDate dataOut;
	@Column(name = "importo")
	private Double importo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "azienda_id", nullable = false)
	private Azienda azienda;
	
	@ManyToMany
	@Builder.Default
	@JoinTable(name = "commessa_risorsa", joinColumns = @JoinColumn(name = "commessa_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "risorsa_id", referencedColumnName = "ID"))
	private Set<Risorsa> risorse = new HashSet<>();
	
}

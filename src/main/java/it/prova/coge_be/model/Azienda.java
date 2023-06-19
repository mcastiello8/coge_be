package it.prova.coge_be.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "azienda")
public class Azienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "ragionesociale")
	private String ragioneSociale;
	@Column(name = "partivaiva")
	private String partivaIva;
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@Builder.Default
	private Set<Commessa> commesse = new HashSet<>();
	
	
	

}

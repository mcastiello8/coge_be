package it.prova.coge_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rapportino")
public class Rapportino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "numerogiorni")
	private Integer numeroGiorni;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "risorsa_id", nullable = false)
	private Risorsa risorsa;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Commessa commessa;
	
}

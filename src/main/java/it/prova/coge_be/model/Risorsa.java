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
import javax.persistence.OneToMany;
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
@Table(name="risorsa")
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
	private LocalDate data_in;
	@Column(name = "data_out")
	private LocalDate data_out;
	@Column(name = "cf")
	private String cf;
	@Column(name = "email")
	private String email;
	@Column(name = "costogiornaliero")
	private Integer costoGiornaliero;
	@OneToOne
	@JoinColumn(name = "attachment_id")
	private Attachment cv;
	
	
	
	@OneToMany(fetch = FetchType.LAZY)
	 private Set<Rapportino> rapportini = new HashSet<>(0); 
	
	@ManyToMany
	 @JoinTable(name = "risorsa_commessa", joinColumns = @JoinColumn(name = "risorsa_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "commessa_id", referencedColumnName = "ID"))
	 private Set<Commessa> commesse = new HashSet<>(0); 
	

	
	
	
	
}





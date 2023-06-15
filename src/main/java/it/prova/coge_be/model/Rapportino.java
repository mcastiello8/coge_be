package it.prova.coge_be.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rapportino {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "risorsa_id", nullable = false)
    private Risorsa risorsa;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commessa_id")
    private Commessa commessa;

    @Column(name = "numerogiorni")
    private Integer numeroGiorni;
    
}



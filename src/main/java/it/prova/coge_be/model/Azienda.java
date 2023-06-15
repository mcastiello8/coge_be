package it.prova.coge_be.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Azienda {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ragioneSociale")
    private String ragioneSociale;

    @Column(name = "partitaIva")
    private String partitaIva;

    @Column(name = "indirizzo")
    private String indirizzo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Commessa> commesse;
    
    
}



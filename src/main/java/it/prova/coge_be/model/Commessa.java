package it.prova.coge_be.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private LocalDate data_in;

    @Column(name = "data_out")
    private LocalDate data_out;

    @Column(name = "importo")
    private double importo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "azienda_id")
    private Azienda azienda;

    @ManyToMany(mappedBy = "commesse", fetch = FetchType.LAZY)
    private List<Risorsa> risorse;
}

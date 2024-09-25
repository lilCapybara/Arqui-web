package org.example.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Torneo {
    @Id
    private int idTorneo;

    @Column
    private String nombreTorneo;

    @Column
    private List<Equipo>equiposParticipantes;
}

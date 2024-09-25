package org.example.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEquipo;

    @Column
    private String nombreEquipo;

    @Column
    private List<Jugador>plantilla;
}

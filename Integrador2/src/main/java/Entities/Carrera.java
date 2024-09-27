package Entities;

import javax.persistence.*;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrera;

    private String nombreCarrera;

    @OneToMany(mappedBy = "carrera")
    private List<Inscripcion> inscripciones;

    
}

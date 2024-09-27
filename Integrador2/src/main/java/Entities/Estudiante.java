package Entities;

import javax.persistence.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    private String nombres;
    private String apellido;
    private Integer edad;
    private String genero;
    private String documento;
    private String ciudadResidencia;
    private String libretaUniversitaria;

    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones;
}

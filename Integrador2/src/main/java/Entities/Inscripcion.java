package Entities;

import javax.persistence.*;

@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;

    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    private Integer antiguedad;
    private Boolean estadoGraduacion;

    // Getters, Setters, y Constructor
   

}

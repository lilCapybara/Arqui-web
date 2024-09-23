package org.example.Entities;
import javax.persistence.*;
import java.util.List;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Genera los id automaticamente
    private int id;
    @Column
    private String ciudad;

    @Column
    private String calle;
    //El mappedBy marca la navegabilidad de la relacion
    @OneToMany(mappedBy = "domicilio", fetch=FetchType.LAZY) //Lazy quiere decir que hasta que no se pida algo de la lista no le hace el fetch
    private List<Persona> habitante;

    public Direccion() {}

    public Direccion(String ciudad, String calle) {
        //El id no va porque se genera solo
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", ciudad='" + ciudad + '\'' +
                ", calle='" + calle + '\'' +
                '}';
    }
}

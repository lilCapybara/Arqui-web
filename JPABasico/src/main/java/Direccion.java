import javax.persistence.*;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Genera los id automaticamente
    private int id;
    @Column
    private String ciudad;

    @Column
    private String calle;

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

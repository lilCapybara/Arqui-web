import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity     //Establece que la clase Persona es una entidad (tabla)
public class Persona {
    @Id     //Establece que id es una columna de la tabla persona
    private int id;
    @Column(nullable=false)
    private String nombre;
    @Column(name="anios")
    private int edad;
    @ManyToOne  //Muchas personas pueden vivir en un mismo domicilio, pero una persona no puede tener mas de un domicilio
    private Direccion domicilio;

    public Persona() {}

    public Persona(int id, String nombre, int edad, Direccion domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", domicilio=" + domicilio +
                '}';
    }
}

package org.example.Entities;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Timestamp fecha;

    @ManyToMany(fetch=FetchType.LAZY)
    private List<Persona> jugadores;

    public Turno(){
        super();
    }

    public Turno(Timestamp fecha){
        super();
        this.fecha=fecha;
        this.jugadores=new ArrayList<Persona>();
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public List<Persona> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Persona> jugadores) {
        this.jugadores = jugadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", jugadores=" + jugadores +
                '}';
    }
}

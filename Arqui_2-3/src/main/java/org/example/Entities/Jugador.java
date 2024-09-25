package org.example.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jugador {
    @Id
    private int dni;

    @Column
    private String nombre;

    @Column
    private String posicion;

    public Jugador(int dni, String nombre, String posicion) {
        this.dni = dni;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}

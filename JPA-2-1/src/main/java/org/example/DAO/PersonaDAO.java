package org.example.DAO;
import org.example.Entities.*;

//Esta interfaz contiene los metodos encesarios para manejar los objetos de tipo "Persona" en la base de datos

public interface PersonaDAO {

    public void guardar(Persona persona);
    public Persona obtenerPorDni(int dni);
    public void actualizar(Persona persona);
    public void eliminar(int dni);
    public void agregarTurno(Turno turno);
}

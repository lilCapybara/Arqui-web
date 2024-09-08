package org.example;

public class PersonaService {
    private PersonaDAO personaDAO;

    public PersonaService(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void agregarPersona(String nombre, int dni) {
        Persona persona = new Persona(nombre, dni);
        personaDAO.guardar(persona);
    }

    public Persona obtenerPersonaPorDni(int dni) {
        return personaDAO.obtenerPorDni(dni);
    }

    public void actualizarPersona(String nombre, int dni) {
        Persona persona = new Persona(nombre, dni);
        personaDAO.actualizar(persona);
    }

    public void eliminarPersona(int dni) {
        personaDAO.eliminar(dni);
    }
}


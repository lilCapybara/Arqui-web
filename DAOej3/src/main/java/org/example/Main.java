package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            PersonaDAO personaDAO = new PersonaDAOImpl();
            PersonaService personaService = new PersonaService(personaDAO);

            // Agregar una nueva persona
            personaService.agregarPersona("Juan Pérez", 12345678);

            // Obtener persona por DNI
            Persona persona = personaService.obtenerPersonaPorDni(12345678);
            System.out.println("Persona obtenida: " + persona.getNombre());

            // Actualizar persona
            personaService.actualizarPersona("Juan Carlos Pérez", 12345678);

            // Eliminar persona
            personaService.eliminarPersona(12345678);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

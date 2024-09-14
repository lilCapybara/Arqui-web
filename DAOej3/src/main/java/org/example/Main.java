package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {


            PersonaDAOImpl personaDaoImpl=new PersonaDAOImpl();
            Persona p1=new Persona("Sebastian",39804501);

            // Agregar una nueva persona
            personaDaoImpl.guardar(p1);

            // Obtener persona por DNI
           personaDaoImpl.obtenerPorDni(39804501);
           
           // Actualizar persona
            personaDaoImpl.actualizar(p1);
            

            // Eliminar persona
            //personaDaoImpl.eliminar(39804501);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

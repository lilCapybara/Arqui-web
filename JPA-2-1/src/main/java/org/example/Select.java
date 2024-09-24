package org.example;

import org.example.Entities.Persona;
import org.example.Entities.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Select {
    public static void main(String[]args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");   //El nombre es el de la persistence unit puesto en el archivo persistence.xml
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
/**
        //Busco persona por id
        Persona j=em.find(Persona.class,1); //Pido al em que busque una persona por su id (la clase indica a la tabla/entidad a la que hago referencia)
        System.out.println(j);

        //Devuelvo la lista de todas las personas
        List<Persona> personas=em.createQuery("SELECT p FROM Persona p").getResultList();   //Imprimo la lista de personas de la tabla Persona
        personas.forEach(p -> System.out.println(p));
*/
        //Busco persona por turno asignado
        Turno t=new Turno(LocalDate.of(2023, 9, 23));
        Persona j=em.find(Persona.class,t);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}

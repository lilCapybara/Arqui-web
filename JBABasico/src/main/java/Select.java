import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Select {
    public static void main(String[]args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");   //El nombre es el de la persistence unit puesto en el archivo persistence.xml
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Persona j=em.find(Persona.class,1); //Pido al em que busque una persona por su id (la clase indica a la tabla/entidad a la que hago referencia)
        System.out.println(j);

        List<Persona> personas=em.createQuery("SELECT p FROM Persona p").getResultList();   //Imprimo la lista de personas de la tabla Persona
        personas.forEach(p -> System.out.println(p));

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}

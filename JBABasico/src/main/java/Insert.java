import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {
    public static void main(String[]args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");   //El nombre es el de la persistence unit puesto en el archivo persistence.xml
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Direccion d=new Direccion("Tandil","Sarmiento 772");
        em.persist(d); //Guardamos d
        Persona j = new Persona(1,"Juan",25,d);
        Persona a = new Persona(2,"Ana",22,d);
        Persona h = new Persona(3,"Carlos",32,d);
        em.persist(j);
        em.persist(a);
        em.persist(h);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

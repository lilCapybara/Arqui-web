package utils;
import javax.persistence.*;
import java.io.*;
import org.apache.commons.csv.*;
import java.util.List;

public class HelperJPQL {
    private EntityManagerFactory emf;
    private EntityManager em;

    public HelperJPQL() {
        emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        em = emf.createEntityManager();
    }

    public void closeConnection() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public void dropTables() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Jugador").executeUpdate();
        em.createQuery("DELETE FROM Equipo").executeUpdate();
        em.createQuery("DELETE FROM Torneo").executeUpdate();
        em.getTransaction().commit();
    }

    public void createTables() {
        // Las tablas se crearán automáticamente al iniciar el proyecto si está configurado correctamente
        System.out.println("Las tablas se gestionan automáticamente por JPA.");
    }

    public void populateDB() throws Exception {
        em.getTransaction().begin();

        for (CSVRecord row : getData("jugadores.csv")) {
            if (row.size() >= 3) {
                try {
                    int idJugador = Integer.parseInt(row.get(0));
                    String nombre = row.get(1);
                    int edad = Integer.parseInt(row.get(2));
                    Jugador jugador = new Jugador(idJugador, nombre, edad);
                    em.persist(jugador);
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato en datos de jugador: " + e.getMessage());
                }
            }
        }

        for (CSVRecord row : getData("equipos.csv")) {
            if (row.size() >= 2) {
                try {
                    int idEquipo = Integer.parseInt(row.get(0));
                    String nombre = row.get(1);
                    Equipo equipo = new Equipo(idEquipo, nombre);
                    em.persist(equipo);
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato en datos de equipo: " + e.getMessage());
                }
            }
        }

        for (CSVRecord row :

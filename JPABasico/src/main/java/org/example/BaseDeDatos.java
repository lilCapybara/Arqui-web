package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos {
    public static void main (String[] args){
        //Debo registrar el driver
        //new EmbedderdDriver(); no siempre se usa porque queresmos poder cambiar el driver sin necesidad de cambiar el codigo
        String driver= "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e){
            e.printStackTrace();
            System.exit(1);  //Si falla el agregado del driver salgo del programa
        }
        //Tras configurar el driver me tengo que conectar a la base de datos
        //Debo definir la uri de la DB (Direccion donde esta la DB)

        String uri = "jdbc:mysql://localhost:3306/arqui_1-5"; //Protocolo:Tipo de DB:Nombre de la DB; si no existe la crea

        try {
            Connection conn = DriverManager.getConnection(uri,"tester","password");
            conn.setAutoCommit(false);
            createTables(conn);
            //addPerson(conn,1,"Juan",30);
            //addPerson(conn,2,"Paula",30);
            conn.close();   //Si no corto la coneccion, la aplicacion seguira corriendo indefinidamente
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void addPerson(Connection conn, int id, String name, int years) throws SQLException{
        String insert = "INSERT INTO persona (id,nombre,edad) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, years);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }
    public static void createTables(Connection conn) throws SQLException{
        String table="CREATE TABLE persona(" + "id INT," + "nombre VARCHAR(500)," + "edad INT," + "PRIMARY KEY(id))";
        conn.prepareStatement(table).execute(); //Si no coloco la SQLException saltara error
        conn.commit();
    }
}
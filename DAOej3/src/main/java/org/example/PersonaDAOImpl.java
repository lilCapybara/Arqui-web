package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Esta clase es la encargada de hacer las consultas SQL a la base de datos
//implementando los metodos de la interfaz "PersonaDAO"

public class PersonaDAOImpl implements PersonaDAO{
    private Connection conexion;

    //El constructor de la clase se encarga de abrir la conexion con la base de  datos

    public PersonaDAOImpl() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/arqui_1-3";
        String usuario = "tester";
        String contrasena = "password";
        this.conexion = DriverManager.getConnection(url, usuario, contrasena);
    }

    public void guardar(Persona persona){
        try {
            String sql = "INSERT INTO personas (nombre, dni) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, persona.getNombre());
            statement.setInt(2, persona.getDni());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public Persona obtenerPorDni(int dni){
        Persona persona = null;
        try {
            String sql = "SELECT * FROM personas WHERE dni = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, dni);
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                persona = new Persona(nombre, dni);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    };
    public void actualizar(Persona persona){
        try {
            String sql = "UPDATE personas SET nombre = ? WHERE dni = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, persona.getNombre());
            statement.setInt(2, persona.getDni());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public void eliminar(int dni){
        try {
            String sql = "DELETE FROM personas WHERE dni = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, dni);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

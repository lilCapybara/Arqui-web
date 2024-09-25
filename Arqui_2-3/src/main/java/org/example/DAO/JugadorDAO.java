package org.example.DAO;

import org.example.Entities.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JugadorDAO {
    private Connection conexion;

    public JugadorDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertJugador(Jugador jugador){
        String query="INSERT INTO Jugador (dni,nombre,posicion) VALUES (?,?,?)";
        PreparedStatement ps=null;

        try {
            ps=conexion.prepareStatement(query);
            ps.setInt(1,jugador.getDni());
            ps.setString(2, jugador.getNombre());
            ps.setString(3, jugador.getPosicion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

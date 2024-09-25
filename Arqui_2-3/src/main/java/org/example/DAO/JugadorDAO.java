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

    public boolean deleteJugador(int dni){
        String query="DELETE FROM Jugador WHERE dni= ?";
        PreparedStatement ps=null;
        boolean isDeleted=false;

        try {
            ps=conexion.prepareStatement(query);
            ps.setInt(1,dni);
            int rowsAffected=ps.executeUpdate();

            if (rowsAffected>0){
                System.out.println("Jugador eliminado exitosaente");
                isDeleted=true;
            }else{
                System.out.println("No se encontro ningun jugador con ese dni");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if (ps!=null){
                    ps.close();
                }
                conexion.commit();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return isDeleted;
    }
}

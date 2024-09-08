import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Select {
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

        String uri = "jdbc:mysql://localhost:3306/exampleDB"; //Protocolo:Tipo de DB:Nombre de la DB; si no existe la crea

        try {
            Connection conn = DriverManager.getConnection(uri,"root","password");
            conn.setAutoCommit(false);
            String select = "SELECT * FROM persona";    //Consulta SQL
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)); //Imprime los valores de la DB
            }
            conn.close();   //Si no corto la coneccion, la aplicacion seguira corriendo indefinidamente
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

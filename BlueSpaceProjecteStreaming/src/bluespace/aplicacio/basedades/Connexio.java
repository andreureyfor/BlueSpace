package bluespace.aplicacio.basedades;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexio {

    private static Connection conn = null;

    public static Connection getConection() {

        try {
            if (conn == null) {
                
                String servidor = "jdbc:mysql://localhost:3306/";
                String bbdd = "bluespace";
                String user = "root";
                String paswd = "1234";

                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(servidor + bbdd, user, paswd);
                System.out.println("Connexio establerta");
            }

        } catch (Exception e) {
            System.out.println("No s'ha pogut connectar a la BD");
            e.printStackTrace();
        }
        return conn;

    }

}

package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres?user=postgres.qcnpimlavaemqxwftame&password=21Jeimy2003*";
    private final String user = "postgres";
    private final String password = "21Jeimy2003*";

    private Connection conectar = null;

    public Connection establecerConexion() {
        try {
            conectar = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa.");
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return conectar;
    }

    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.establecerConexion();
        db.cerrarConexion();
    }
}


/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:postgresql://neondb_owner:npg_1PT9UoImWXpY@ep-misty-unit-a5pxescf-pooler.us-east-2.aws.neon.tech/prueba160225neon?sslmode=require";
    private static final String USUARIO = "neondb_owner";
    private static final String CONTRASEÑA = "npg_1PT9UoImWXpY";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


*/
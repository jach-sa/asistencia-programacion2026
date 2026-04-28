package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de establecer la conexión con MySQL.
 */
public class ConexionDB {

    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/app_login";
    private static final String USUARIO = "root";
    
    // ⚠️ Aquí pon tu contraseña real de MySQL
    private static final String PASSWORD = "Olmequitas6857?";
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Variable única de conexión
    private static Connection conexion = null;

    /**
     * Método para obtener la conexión activa.
     * @return objeto Connection
     */
    public static Connection getConexion() {

        try {
            // Si no existe conexión o está cerrada, crear nueva
            if (conexion == null || conexion.isClosed()) {

                Class.forName(DRIVER);

                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

                System.out.println("Conexión establecida correctamente con MySQL.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado: " + e.getMessage());

        } catch (SQLException e) {
            System.err.println("Error al conectar con MySQL: " + e.getMessage());
        }

        return conexion;
    }

    /**
     * Método para cerrar la conexión cuando termine el programa.
     */
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}
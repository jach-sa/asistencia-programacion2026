/*
 * Clase UsuarioDAO
 * --------------------------------------------
 * Esta clase se encarga de realizar todas las
 * operaciones CRUD sobre la tabla usuarios
 * utilizando JDBC y MySQL.
 * 
 * CRUD:
 * C -> Create (Insertar)
 * R -> Read   (Consultar)
 * U -> Update (Actualizar)
 * D -> Delete (Eliminar)
 */

package modelo;

// Importamos las librerías necesarias para conexión SQL
import java.sql.*;

// Importamos estructuras de datos para listas
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jachr
 */
public class UsuarioDAO {

    // Objeto Connection que recibe la conexión desde ConexionDB
    private Connection conn = ConexionDB.getConexion();

    // ══════════════════════════════════════════════════
    // CREATE — Insertar nuevo usuario en la base de datos
    // ══════════════════════════════════════════════════
    
    /**
     * Método insertar()
     * Recibe un objeto Usuario y guarda sus datos en MySQL.
     * 
     * @param u Objeto usuario con todos sus atributos
     * @return true si se insertó correctamente, false si hubo error
     */
    public boolean insertar(Usuario u) {
        
        // Consulta SQL con parámetros dinámicos
        String sql = "INSERT INTO usuarios (nombre, apellido, email, usuario, contrasena, foto) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            // Asignamos cada valor del objeto Usuario a la consulta
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getUsuario());
            ps.setString(5, u.getContrasena());

            // Validamos si existe foto o no
            if (u.getFoto() != null) {
                ps.setBytes(6, u.getFoto());
            } else {
                ps.setNull(6, Types.BLOB);
            }

            // Ejecuta el INSERT y devuelve true si afectó filas
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    // ══════════════════════════════════════════════════
    // READ — Buscar usuario por login
    // ══════════════════════════════════════════════════
    
    /**
     * Método login()
     * Verifica si el usuario y contraseña existen y están activos.
     * 
     * @param usuario Nombre de usuario ingresado
     * @param contrasena Contraseña ingresada
     * @return Objeto Usuario si el login es correcto, null si falla
     */
    public Usuario login(String usuario, String contrasena) {

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ? AND activo = 1";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            // Insertamos datos en la consulta
            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();

            // Si encuentra coincidencia se llena el objeto Usuario
            if (rs.next()) {
                Usuario u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEmail(rs.getString("email"));
                u.setUsuario(rs.getString("usuario"));
                u.setFoto(rs.getBytes("foto"));

                return u; // Login exitoso
            }

        } catch (SQLException e) {
            System.err.println("Error en login: " + e.getMessage());
        }

        return null; // Login incorrecto
    }

    // ══════════════════════════════════════════════════
    // READ — Mostrar todos los usuarios registrados
    // ══════════════════════════════════════════════════
    
    /**
     * Método listarTodos()
     * Obtiene todos los registros de la tabla usuarios.
     * 
     * @return Lista con objetos Usuario
     */
    public List<Usuario> listarTodos() {

        List<Usuario> lista = new ArrayList<>();

        // Consulta SQL corregida
        String sql = "SELECT id, nombre, apellido, email, usuario, fecha_reg FROM usuarios";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            // Recorremos todos los registros encontrados
            while (rs.next()) {

                Usuario u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEmail(rs.getString("email"));
                u.setUsuario(rs.getString("usuario"));

                // Agregamos el objeto a la lista
                lista.add(u);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }

    // ══════════════════════════════════════════════════
    // UPDATE — Actualizar información de usuario
    // ══════════════════════════════════════════════════
    
    /**
     * Método actualizar()
     * Modifica los datos de un usuario ya existente.
     * 
     * @param u Objeto Usuario con los nuevos datos
     * @return true si actualizó correctamente
     */
    public boolean actualizar(Usuario u) {

        String sql = "UPDATE usuarios SET nombre=?, apellido=?, email=?, contrasena=?, foto=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getContrasena());
            ps.setBytes(5, u.getFoto());
            ps.setInt(6, u.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    // ══════════════════════════════════════════════════
    // DELETE — Eliminar usuario por ID
    // ══════════════════════════════════════════════════
    
    /**
     * Método eliminar()
     * Borra un usuario de la base de datos según su ID.
     * 
     * @param id Identificador del usuario
     * @return true si se eliminó correctamente
     */
    public boolean eliminar(int id) {

        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    // ══════════════════════════════════════════════════
    // VALIDAR — Comprobar si el nombre de usuario ya existe
    // ══════════════════════════════════════════════════
    
    /**
     * Método usuarioExiste()
     * Verifica que no exista un nombre de usuario repetido.
     * 
     * @param usuario Nombre de usuario a consultar
     * @return true si ya existe, false si está disponible
     */
    public boolean usuarioExiste(String usuario) {

        String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.err.println("Error al validar: " + e.getMessage());
        }

        return false;
    }
}

/*
 * Clase LoginController
 * ---------------------------------------------------
 * Esta clase pertenece a la capa Controlador del
 * patrón MVC.
 * 
 * Su función es recibir los datos del formulario
 * FrmLogin, validarlos, consultar la base de datos
 * mediante UsuarioDAO y decidir qué acción realizar.
 */

package controlador;

// Importamos clases del modelo
import modelo.Usuario;
import modelo.UsuarioDAO;

// Importamos vistas
import vista.FrmLogin;
import vista.FrmBienvenida;

// Librería para mensajes emergentes
import javax.swing.JOptionPane;

public class LoginController {

    // Objeto DAO para acceder a la base de datos
    private UsuarioDAO dao = new UsuarioDAO();

    // ══════════════════════════════════════════════════
    // MÉTODO PRINCIPAL PARA PROCESAR LOGIN
    // ══════════════════════════════════════════════════
    
    /**
     * Método procesarLogin()
     * Recibe el usuario y contraseña ingresados desde
     * el formulario FrmLogin, los valida y consulta
     * si existen en la base de datos.
     * 
     * @param usuario nombre de usuario ingresado
     * @param contrasena contraseña ingresada
     * @param vista referencia del formulario login
     */
    public void procesarLogin(String usuario, String contrasena, FrmLogin vista) {

        // ═════════════════════════════════════
        // 1. VALIDAR CAMPOS VACÍOS
        // ═════════════════════════════════════
        if (usuario.isEmpty() || contrasena.isEmpty()) {

            JOptionPane.showMessageDialog(vista,
                    "Por favor ingresa usuario y contraseña.",
                    "Campos vacíos",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        // ═════════════════════════════════════
        // 2. CONSULTAR USUARIO EN BASE DE DATOS
        // ═════════════════════════════════════
        Usuario u = dao.login(usuario, contrasena);

        // ═════════════════════════════════════
        // 3. EVALUAR RESULTADO
        // ═════════════════════════════════════
        if (u != null) {

            // Si encontró usuario válido se abre la ventana de bienvenida
            new FrmBienvenida(u).setVisible(true);

            // Se cierra el formulario de login
            vista.dispose();

        } else {

            // Si no existe coincidencia muestra mensaje de error
            JOptionPane.showMessageDialog(vista,
                    "Usuario o contraseña incorrectos.",
                    "Error de acceso",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
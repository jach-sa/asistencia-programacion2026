/*
 * Clase RegistroController
 * ---------------------------------------------------
 * Esta clase pertenece a la capa Controlador del
 * patrón MVC.
 * 
 * Su función es recibir los datos del formulario
 * FrmRegistro, validarlos, verificar que el usuario
 * no exista y finalmente guardarlo en la base de datos.
 */

package controlador;

// Importamos clases del modelo
import modelo.Usuario;
import modelo.UsuarioDAO;

// Importamos vistas
import vista.FrmRegistro;
import vista.FrmLogin;

// Librería para mensajes emergentes
import javax.swing.JOptionPane;

public class RegistroController {

    // Objeto DAO para trabajar con la base de datos
    private UsuarioDAO dao = new UsuarioDAO();

    // ══════════════════════════════════════════════════
    // MÉTODO PRINCIPAL PARA PROCESAR EL REGISTRO
    // ══════════════════════════════════════════════════
    
    /**
     * Método procesarRegistro()
     * Recibe toda la información ingresada en FrmRegistro,
     * realiza validaciones y si todo está correcto
     * guarda el nuevo usuario.
     * 
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param email correo electrónico
     * @param usuario nombre de usuario
     * @param contrasena contraseña principal
     * @param confirmar confirmación de contraseña
     * @param foto imagen en bytes
     * @param vista referencia del formulario registro
     */
    public void procesarRegistro(String nombre, String apellido, String email,
                                 String usuario, String contrasena, String confirmar,
                                 byte[] foto, FrmRegistro vista) {

        // ═════════════════════════════════════
        // 1. VALIDAR CAMPOS OBLIGATORIOS
        // ═════════════════════════════════════
        if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty()
                || contrasena.isEmpty() || email.isEmpty()) {

            JOptionPane.showMessageDialog(vista,
                    "Todos los campos son obligatorios.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ═════════════════════════════════════
        // 2. VALIDAR CONFIRMACIÓN DE CONTRASEÑA
        // ═════════════════════════════════════
        if (!contrasena.equals(confirmar)) {

            JOptionPane.showMessageDialog(vista,
                    "Las contraseñas no coinciden.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ═════════════════════════════════════
        // 3. VALIDAR LONGITUD MÍNIMA
        // ═════════════════════════════════════
        if (contrasena.length() < 6) {

            JOptionPane.showMessageDialog(vista,
                    "La contraseña debe tener al menos 6 caracteres.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ═════════════════════════════════════
        // 4. VALIDAR USUARIO DUPLICADO
        // ═════════════════════════════════════
        if (dao.usuarioExiste(usuario)) {

            JOptionPane.showMessageDialog(vista,
                    "El nombre de usuario ya está en uso.",
                    "Usuario duplicado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ═════════════════════════════════════
        // 5. CREAR OBJETO USUARIO Y GUARDAR
        // ═════════════════════════════════════
        Usuario u = new Usuario(nombre, apellido, email, usuario, contrasena, foto);

        boolean ok = dao.insertar(u);

        // ═════════════════════════════════════
        // 6. EVALUAR SI SE GUARDÓ CORRECTAMENTE
        // ═════════════════════════════════════
        if (ok) {

            JOptionPane.showMessageDialog(vista,
                    "Usuario registrado correctamente. Ahora puedes iniciar sesión.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

            // Abrir formulario de login
            new FrmLogin().setVisible(true);

            // Cerrar formulario de registro
            vista.dispose();

        } else {

            JOptionPane.showMessageDialog(vista,
                    "Error al guardar en la base de datos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
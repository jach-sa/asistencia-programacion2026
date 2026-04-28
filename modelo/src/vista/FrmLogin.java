/*
 * Clase FrmLogin
 * ----------------------------------------------------
 * Esta clase representa la ventana de inicio de sesión
 * del sistema.
 * 
 * Pertenece a la capa Vista del patrón MVC.
 * Permite al usuario ingresar sus credenciales para
 * acceder o dirigirse a la ventana de registro.
 */

package vista;

// Importamos el controlador encargado del login
import controlador.LoginController;

// Librerías Swing
import javax.swing.*;

// Librerías de diseño
import java.awt.*;

// Librería para eventos
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame {

    // ══════════════════════════════════════════════════
    // DECLARACIÓN DE COMPONENTES GRÁFICOS
    // ══════════════════════════════════════════════════
    
    private JLabel lblTitulo, lblUsuario, lblContrasena, lblFoto;
    private JTextField txtUsuario;
    private JPasswordField pswContrasena;
    private JButton btnLogin, btnRegistrar;
    private JPanel panelPrincipal;

    // ══════════════════════════════════════════════════
    // CONSTRUCTOR
    // ══════════════════════════════════════════════════
    
    /**
     * Constructor principal.
     * Inicializa los componentes y configura la ventana.
     */
    public FrmLogin() {
        initComponents();
        configurarVentana();
    }

    // ══════════════════════════════════════════════════
    // MÉTODO PARA CREAR LOS COMPONENTES DE LA INTERFAZ
    // ══════════════════════════════════════════════════
    
    private void initComponents() {

        // Panel principal con diseño GridBagLayout
        panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(new Color(240, 248, 255));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ═════════════════════════════════════
        // TÍTULO
        // ═════════════════════════════════════
        lblTitulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(31, 78, 121));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panelPrincipal.add(lblTitulo, gbc);

        // ═════════════════════════════════════
        // CAMPO USUARIO
        // ═════════════════════════════════════
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        panelPrincipal.add(lblUsuario, gbc);

        gbc.gridx = 1;

        txtUsuario = new JTextField(20);
        txtUsuario.setPreferredSize(new Dimension(200, 30));
        panelPrincipal.add(txtUsuario, gbc);

        // ═════════════════════════════════════
        // CAMPO CONTRASEÑA
        // ═════════════════════════════════════
        gbc.gridy = 2;
        gbc.gridx = 0;

        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 14));
        panelPrincipal.add(lblContrasena, gbc);

        gbc.gridx = 1;

        pswContrasena = new JPasswordField(20);
        pswContrasena.setPreferredSize(new Dimension(200, 30));
        panelPrincipal.add(pswContrasena, gbc);

        // ═════════════════════════════════════
        // BOTÓN INGRESAR
        // ═════════════════════════════════════
        gbc.gridy = 3;
        gbc.gridx = 0;

        btnLogin = new JButton("Ingresar");
        btnLogin.setBackground(new Color(46, 117, 182));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 13));
        btnLogin.setPreferredSize(new Dimension(120, 35));
        panelPrincipal.add(btnLogin, gbc);

        // ═════════════════════════════════════
        // BOTÓN REGISTRARSE
        // ═════════════════════════════════════
        gbc.gridx = 1;

        btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 13));
        btnRegistrar.setPreferredSize(new Dimension(120, 35));
        panelPrincipal.add(btnRegistrar, gbc);

        // Agregamos panel al JFrame
        add(panelPrincipal);

        // ═════════════════════════════════════
        // EVENTOS DE LOS BOTONES
        // ═════════════════════════════════════

        // Evento para iniciar sesión
        btnLogin.addActionListener((ActionEvent e) -> {

            String user = txtUsuario.getText().trim();
            String pass = new String(pswContrasena.getPassword()).trim();

            new LoginController().procesarLogin(user, pass, this);
        });

        // Evento para abrir formulario de registro
        btnRegistrar.addActionListener((ActionEvent e) -> {
            new FrmRegistro().setVisible(true);
            this.dispose();
        });
    }

    // ══════════════════════════════════════════════════
    // CONFIGURACIÓN GENERAL DE LA VENTANA
    // ══════════════════════════════════════════════════
    
    /**
     * Ajusta tamaño, posición, cierre y propiedades visuales.
     */
    private void configurarVentana() {
        setTitle("Login — App Sistema");
        setSize(420, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
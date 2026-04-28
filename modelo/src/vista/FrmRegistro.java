/*
 * Clase FrmRegistro
 * ----------------------------------------------------
 * Esta clase representa la ventana gráfica encargada
 * de registrar nuevos usuarios dentro del sistema.
 * 
 * Pertenece a la capa Vista del patrón MVC.
 * Aquí se construyen todos los componentes visuales:
 * campos de texto, botones, carga de foto y eventos.
 */

package vista;

// Importamos el controlador que procesará el registro
import controlador.RegistroController;

// Librerías de Swing
import javax.swing.*;

// Librerías para diseño gráfico
import java.awt.*;

// Librerías para eventos
import java.io.*;
import java.nio.file.Files;

public class FrmRegistro extends JFrame {

    // ══════════════════════════════════════════════════
    // DECLARACIÓN DE COMPONENTES GRÁFICOS
    // ══════════════════════════════════════════════════
    
    private JTextField txtNombre, txtApellido, txtEmail, txtUsuario;
    private JPasswordField pswContrasena, pswConfirmar;
    private JLabel lblFotoPreview;
    private JButton btnSelFoto, btnGuardar, btnCancelar;

    // Variable donde se almacena la imagen convertida en bytes
    private byte[] fotoBytes;

    // ══════════════════════════════════════════════════
    // CONSTRUCTOR
    // ══════════════════════════════════════════════════
    
    /**
     * Constructor principal.
     * Inicializa componentes y configura propiedades de la ventana.
     */
    public FrmRegistro() {
        initComponents();
        configurarVentana();
    }

    // ══════════════════════════════════════════════════
    // MÉTODO PARA CREAR LOS COMPONENTES DEL FORMULARIO
    // ══════════════════════════════════════════════════
    
    private void initComponents() {

        // Panel principal con GridBagLayout para mejor acomodo
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 250, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(16, 30, 16, 30));

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5, 5, 5, 5);
        g.fill = GridBagConstraints.HORIZONTAL;

        // ═════════════════════════════════════
        // TÍTULO DEL FORMULARIO
        // ═════════════════════════════════════
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;

        JLabel titulo = new JLabel("Registro de Usuario", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(new Color(31, 78, 121));
        panel.add(titulo, g);

        // ═════════════════════════════════════
        // CREACIÓN DE CAMPOS DE TEXTO
        // ═════════════════════════════════════
        String[] labels = {
            "Nombre:", "Apellido:", "Email:", "Usuario:", "Contraseña:", "Confirmar:"
        };

        JComponent[] fields = {
            txtNombre = new JTextField(18),
            txtApellido = new JTextField(18),
            txtEmail = new JTextField(18),
            txtUsuario = new JTextField(18),
            pswContrasena = new JPasswordField(18),
            pswConfirmar = new JPasswordField(18)
        };

        g.gridwidth = 1;

        // Se agregan automáticamente con un ciclo
        for (int i = 0; i < labels.length; i++) {
            g.gridx = 0;
            g.gridy = i + 1;
            panel.add(new JLabel(labels[i]), g);

            g.gridx = 1;
            fields[i].setPreferredSize(new Dimension(190, 28));
            panel.add(fields[i], g);
        }

        // ═════════════════════════════════════
        // SECCIÓN PARA FOTO DE PERFIL
        // ═════════════════════════════════════
        g.gridx = 0;
        g.gridy = 7;
        panel.add(new JLabel("Foto:"), g);

        lblFotoPreview = new JLabel("Sin imagen", SwingConstants.CENTER);
        lblFotoPreview.setPreferredSize(new Dimension(80, 80));
        lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblFotoPreview.setBackground(Color.WHITE);
        lblFotoPreview.setOpaque(true);

        g.gridx = 1;
        panel.add(lblFotoPreview, g);

        g.gridy = 8;
        g.gridx = 1;

        btnSelFoto = new JButton("Seleccionar Foto");
        panel.add(btnSelFoto, g);

        // ═════════════════════════════════════
        // BOTONES DE ACCIÓN
        // ═════════════════════════════════════
        g.gridy = 9;
        g.gridx = 0;

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(55, 86, 35));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(btnGuardar, g);

        g.gridx = 1;

        btnCancelar = new JButton("Cancelar");
        panel.add(btnCancelar, g);

        // Agregamos el panel al JFrame
        add(panel);

        // ═════════════════════════════════════
        // EVENTOS DE LOS BOTONES
        // ═════════════════════════════════════

        // Botón para seleccionar foto
        btnSelFoto.addActionListener(e -> seleccionarFoto());

        // Botón para guardar usuario
        btnGuardar.addActionListener(e -> {
            new RegistroController().procesarRegistro(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtEmail.getText(),
                    txtUsuario.getText(),
                    new String(pswContrasena.getPassword()),
                    new String(pswConfirmar.getPassword()),
                    fotoBytes,
                    this
            );
        });

        // Botón cancelar regresa al login
        btnCancelar.addActionListener(e -> {
            new FrmLogin().setVisible(true);
            this.dispose();
        });
    }

    // ══════════════════════════════════════════════════
    // MÉTODO PARA SELECCIONAR FOTO DESDE EL EQUIPO
    // ══════════════════════════════════════════════════
    
    /**
     * Permite abrir el explorador de archivos para elegir
     * una imagen de perfil y convertirla en bytes.
     */
    private void seleccionarFoto() {

        JFileChooser fc = new JFileChooser();

        fc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Imágenes (jpg, png, gif)", "jpg", "jpeg", "png", "gif"));

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            File archivo = fc.getSelectedFile();

            try {
                // Convierte la imagen a arreglo de bytes
                fotoBytes = Files.readAllBytes(archivo.toPath());

                // Escala la imagen para mostrar preview
                ImageIcon icon = new ImageIcon(
                        new ImageIcon(fotoBytes).getImage().getScaledInstance(
                                80, 80, Image.SCALE_SMOOTH));

                lblFotoPreview.setIcon(icon);
                lblFotoPreview.setText("");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen.");
            }
        }
    }

    // ══════════════════════════════════════════════════
    // CONFIGURACIÓN GENERAL DE LA VENTANA
    // ══════════════════════════════════════════════════
    
    /**
     * Ajusta tamaño, posición, título y cierre del JFrame.
     */
    private void configurarVentana() {
        setTitle("Registro de Usuario");
        setSize(420, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
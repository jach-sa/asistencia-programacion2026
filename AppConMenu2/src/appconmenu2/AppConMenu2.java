package appconmenu2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppConMenu2 extends JFrame implements ActionListener {

    // Barra principal
    private JMenuBar menuBar;

    // Menus
    private JMenu menuVista, menuTamano, menuAyuda, subHerramientas;

    // Opciones menu Vista
    private JMenuItem miRojo, miAzul, miVerde, miBlancoFondo;

    // Nuevas opciones submenu Herramientas
    private JMenuItem miAmarillo, miGris;

    // Opciones menu Ventana
    private JMenuItem mi800, mi1024, miMaximizar, miSalir, miAcerca;

    // Etiqueta
    private JLabel lblInfo;

    public AppConMenu2() {
        setLayout(null);
        setTitle("Aplicacion con Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ================= BARRA DE MENU =================
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // ================= MENU VISTA =================
        menuVista = new JMenu("Vista");
        menuBar.add(menuVista);

        miRojo = new JMenuItem("Fondo Rojo");
        miAzul = new JMenuItem("Fondo Azul");
        miVerde = new JMenuItem("Fondo Verde");
        miBlancoFondo = new JMenuItem("Restaurar fondo");

        // Aceleradores de teclado
        miRojo.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        miAzul.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
        miVerde.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));

        miRojo.addActionListener(this);
        miAzul.addActionListener(this);
        miVerde.addActionListener(this);
        miBlancoFondo.addActionListener(this);

        menuVista.add(miRojo);
        menuVista.add(miAzul);
        menuVista.add(miVerde);
        menuVista.addSeparator();
        menuVista.add(miBlancoFondo);

        // ================= SUBMENU HERRAMIENTAS =================
        subHerramientas = new JMenu("Herramientas");

        miAmarillo = new JMenuItem("Fondo Amarillo");
        miGris = new JMenuItem("Fondo Gris");

        miAmarillo.addActionListener(this);
        miGris.addActionListener(this);

        subHerramientas.add(miAmarillo);
        subHerramientas.add(miGris);

        menuVista.addSeparator();
        menuVista.add(subHerramientas);

        // ================= MENU VENTANA =================
        menuTamano = new JMenu("Ventana");
        menuBar.add(menuTamano);

        mi800 = new JMenuItem("800 x 600");
        mi1024 = new JMenuItem("1024 x 768");
        miMaximizar = new JMenuItem("Maximizar");
        miSalir = new JMenuItem("Salir");

        mi800.addActionListener(this);
        mi1024.addActionListener(this);
        miMaximizar.addActionListener(this);
        miSalir.addActionListener(this);

        menuTamano.add(mi800);
        menuTamano.add(mi1024);
        menuTamano.add(miMaximizar);
        menuTamano.addSeparator();
        menuTamano.add(miSalir);

        // ================= MENU AYUDA =================
        menuAyuda = new JMenu("Ayuda");
        menuBar.add(menuAyuda);

        miAcerca = new JMenuItem("Acerca de...");
        miAcerca.addActionListener(this);
        menuAyuda.add(miAcerca);

        // ================= ETIQUETA =================
        lblInfo = new JLabel("Usa el menu para interactuar");
        lblInfo.setBounds(20, 20, 400, 30);
        add(lblInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        Container fondo = getContentPane();

        // ===== MENU VISTA =====
        if (src == miRojo)
            fondo.setBackground(new Color(220, 80, 80));

        else if (src == miAzul)
            fondo.setBackground(new Color(70, 130, 200));

        else if (src == miVerde)
            fondo.setBackground(new Color(80, 200, 120));

        else if (src == miBlancoFondo)
            fondo.setBackground(null);

        // ===== SUBMENU HERRAMIENTAS =====
        else if (src == miAmarillo)
            fondo.setBackground(Color.YELLOW);

        else if (src == miGris)
            fondo.setBackground(Color.LIGHT_GRAY);

        // ===== MENU VENTANA =====
        else if (src == mi800)
            setSize(800, 600);

        else if (src == mi1024)
            setSize(1024, 768);

        else if (src == miMaximizar)
            setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Confirmacion antes de salir
        else if (src == miSalir) {
            int op = JOptionPane.showConfirmDialog(this,
                    "¿Deseas salir del programa?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                dispose();
            }
        }

        // ===== MENU AYUDA =====
        else if (src == miAcerca) {
            JOptionPane.showMessageDialog(this,
                    "Practica de Menus con Swing\nVersion 2.0",
                    "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        AppConMenu2 app = new AppConMenu2();
        app.setBounds(150, 100, 600, 400);
        app.setVisible(true);
    }
}
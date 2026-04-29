/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appconmenu3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class AppConMenu3 extends JFrame implements ActionListener {

    // Barra principal del menu
    private JMenuBar menuBar;

    // Menus superiores
    private JMenu menuVista, menuTamano, menuAyuda, subHerramientas;

    // Opciones del menu Vista
    private JMenuItem miRojo, miAzul, miVerde, miBlancoFondo;

    // Opciones extra del submenu Herramientas
    private JMenuItem miMensaje, miTitulo;

    // Opciones del menu Ventana
    private JMenuItem mi800, mi1024, miMaximizar, miSalir, miAcerca;

    // Etiqueta informativa
    private JLabel lblInfo;

    public AppConMenu3() {
        setLayout(null);
        setTitle("Aplicacion con Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ==================== BARRA DE MENU ====================
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // ==================== MENU VISTA ====================
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

        // ==================== SUBMENU HERRAMIENTAS ====================
        // Se crea un submenu dentro de Vista con opciones adicionales
        subHerramientas = new JMenu("Herramientas");

        miMensaje = new JMenuItem("Mostrar mensaje");
        miTitulo = new JMenuItem("Cambiar titulo");

        miMensaje.addActionListener(this);
        miTitulo.addActionListener(this);

        subHerramientas.add(miMensaje);
        subHerramientas.add(miTitulo);

        menuVista.addSeparator();
        menuVista.add(subHerramientas);

        // ==================== MENU VENTANA ====================
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

        // ==================== MENU AYUDA ====================
        menuAyuda = new JMenu("Ayuda");
        menuBar.add(menuAyuda);

        miAcerca = new JMenuItem("Acerca de...");
        miAcerca.addActionListener(this);
        menuAyuda.add(miAcerca);

        // ==================== CONTENIDO ====================
        lblInfo = new JLabel("Usa el menu para interactuar");
        lblInfo.setBounds(20, 20, 400, 30);
        add(lblInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        Container fondo = getContentPane();

        // Cambiar colores de fondo
        if (src == miRojo)
            fondo.setBackground(new Color(220, 80, 80));

        else if (src == miAzul)
            fondo.setBackground(new Color(70, 130, 200));

        else if (src == miVerde)
            fondo.setBackground(new Color(80, 200, 120));

        else if (src == miBlancoFondo)
            fondo.setBackground(null);

        // Cambiar tamaños de ventana
        else if (src == mi800)
            setSize(800, 600);

        else if (src == mi1024)
            setSize(1024, 768);

        // Maximiza la ventana completamente
        else if (src == miMaximizar)
            setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Confirmacion antes de salir
        else if (src == miSalir) {
            int op = JOptionPane.showConfirmDialog(this,
                    "Deseas salir de la aplicacion?",
                    "Confirmacion",
                    JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

        // Ventana emergente de ayuda
        else if (src == miAcerca) {
            JOptionPane.showMessageDialog(this,
                    "Practica de Menus con Swing\nVersion 1.0",
                    "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        }

        // Opcion del submenu herramientas para mostrar mensaje
        else if (src == miMensaje) {
            JOptionPane.showMessageDialog(this,
                    "Bienvenido al submenu Herramientas");
        }

        // Opcion del submenu herramientas para cambiar titulo
        else if (src == miTitulo) {
            setTitle("Titulo cambiado desde Herramientas");
        }
    }

    public static void main(String[] args) {
        AppConMenu3 app = new AppConMenu3();
        app.setBounds(150, 100, 600, 400);
        app.setVisible(true);
    }
}
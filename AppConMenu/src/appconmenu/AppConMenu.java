/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appconmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class AppConMenu extends JFrame implements ActionListener {

    // Barra principal donde se colocaran todos los menus
    private JMenuBar menuBar;

    // Menus principales que apareceran en la barra superior
    private JMenu menuVista, menuTamano, menuAyuda;

    // Opciones del menu Vista para cambiar el color de fondo
    private JMenuItem miRojo, miAzul, miVerde, miBlancoFondo;

    // Opciones del menu Ventana para cambiar tamaño o salir
    private JMenuItem mi800, mi1024, miSalir, miAcerca;

    // Etiqueta informativa dentro de la ventana
    private JLabel lblInfo;

    public AppConMenu() {
        setLayout(null);
        setTitle("Aplicacion con Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ================= CREACION DE LA BARRA DE MENU =================
        // Se crea la barra horizontal y se agrega al JFrame
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // ================= MENU VISTA =================
        // Este menu servira para modificar el color de fondo
        menuVista = new JMenu("Vista");
        menuBar.add(menuVista);

        // Creamos las opciones del menu Vista
        miRojo = new JMenuItem("Fondo Rojo");
        miAzul = new JMenuItem("Fondo Azul");
        miVerde = new JMenuItem("Fondo Verde");
        miBlancoFondo = new JMenuItem("Restaurar fondo");

        // Activamos eventos para cada opcion
        miRojo.addActionListener(this);
        miAzul.addActionListener(this);
        miVerde.addActionListener(this);
        miBlancoFondo.addActionListener(this);

        // Agregamos las opciones dentro del menu Vista
        menuVista.add(miRojo);
        menuVista.add(miAzul);
        menuVista.add(miVerde);
        menuVista.addSeparator(); // Agrega una linea divisoria
        menuVista.add(miBlancoFondo);

        // ================= MENU VENTANA =================
        // Este menu servira para cambiar el tamaño o cerrar el programa
        menuTamano = new JMenu("Ventana");
        menuBar.add(menuTamano);

        // Creamos las opciones
        mi800 = new JMenuItem("800 x 600");
        mi1024 = new JMenuItem("1024 x 768");
        miSalir = new JMenuItem("Salir");

        // Activamos sus eventos
        mi800.addActionListener(this);
        mi1024.addActionListener(this);
        miSalir.addActionListener(this);

        // Agregamos al menu
        menuTamano.add(mi800);
        menuTamano.add(mi1024);
        menuTamano.addSeparator();
        menuTamano.add(miSalir);

        // ================= MENU AYUDA =================
        // Este menu mostrara informacion del programa
        menuAyuda = new JMenu("Ayuda");
        menuBar.add(menuAyuda);

        miAcerca = new JMenuItem("Acerca de...");
        miAcerca.addActionListener(this);
        menuAyuda.add(miAcerca);

        // ================= CONTENIDO DE LA VENTANA =================
        // Etiqueta que le indica al usuario que use el menu
        lblInfo = new JLabel("Usa el menu para interactuar");
        lblInfo.setBounds(20, 20, 400, 30);
        add(lblInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Capturamos que opcion fue seleccionada
        Object src = e.getSource();

        // Obtenemos el panel principal para poder cambiarle el fondo
        Container fondo = getContentPane();

        // ================= OPCIONES DEL MENU VISTA =================
        // Cambia el fondo a rojo
        if (src == miRojo)
            fondo.setBackground(new Color(220, 80, 80));

        // Cambia el fondo a azul
        else if (src == miAzul)
            fondo.setBackground(new Color(70, 130, 200));

        // Cambia el fondo a verde
        else if (src == miVerde)
            fondo.setBackground(new Color(80, 200, 120));

        // Regresa el fondo al color original
        else if (src == miBlancoFondo)
            fondo.setBackground(null);

        // ================= OPCIONES DEL MENU VENTANA =================
        // Cambia el tamaño a 800 x 600
        else if (src == mi800)
            setSize(800, 600);

        // Cambia el tamaño a 1024 x 768
        else if (src == mi1024)
            setSize(1024, 768);

        // Cierra completamente el programa
        else if (src == miSalir)
            System.exit(0);

        // ================= OPCION DEL MENU AYUDA =================
        // Muestra una ventana emergente con informacion del sistema
        else if (src == miAcerca) {
            JOptionPane.showMessageDialog(this,
                    "Practica de Menus con Swing\nVersion 1.0",
                    "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {

        // Se crea el objeto principal del programa
        AppConMenu app = new AppConMenu();

        // Se define tamaño y posicion inicial de la ventana
        app.setBounds(150, 100, 600, 400);

        // Se hace visible la ventana
        app.setVisible(true);
    }
}
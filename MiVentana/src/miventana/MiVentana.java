/*
 * Plantilla creada automáticamente por NetBeans
 */
package miventana;

// Librerías que se necesitan para la ventana y los eventos
import javax.swing.*;
import java.awt.event.*;

/*
 * Clase principal que crea una ventana
 */
public class MiVentana extends JFrame implements ActionListener {

    // Declaramos un botón y una etiqueta
    private JButton boton1;
    private JLabel label1;

    // Constructor de la ventana
    public MiVentana() {
        
        setLayout(null); // Se usará posición manual
        setTitle("Mi Aplicacion"); // Título de la ventana

        // Crear la etiqueta con un mensaje inicial
        label1 = new JLabel("Hola, Swing!");
        label1.setBounds(20, 20, 200, 30); // Posición y tamaño
        add(label1); // Agregar a la ventana

        // Crear el botón
        boton1 = new JButton("Click aqui");
        boton1.setBounds(20, 70, 130, 35); // Posición y tamaño
        
        boton1.addActionListener(this); // Detectar cuando se haga clic
        add(boton1); // Agregar botón a la ventana
    }

    // Método que se ejecuta cuando se presiona el botón
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Si el botón fue presionado
        if (e.getSource() == boton1) {
            label1.setText("Boton presionado!"); // Cambiar texto de la etiqueta
        }
    }

    // Método principal donde inicia el programa
    public static void main(String[] args) {
        
        MiVentana ventana = new MiVentana(); // Crear la ventana
        
        ventana.setBounds(100, 100, 320, 200); // Tamaño y posición
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar programa al salir
        ventana.setVisible(true); // Mostrar la ventana
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ventanaprincipal;
import javax.swing.*; // Librería para crear ventanas gráficas
/**
 *
 * @author jachr
 */
// Clase principal que hereda de JFrame
public class VentanaPrincipal extends JFrame {

    // Constructor de la ventana
    public VentanaPrincipal() {
        
        setLayout(null); // Se usa posición manual para los componentes
        
        setTitle("Mi Primera Aplicacion Swing"); // Título de la ventana
        
        setResizable(false); // Evita que el usuario cambie el tamaño
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al cerrar ventana
    }

    // Método principal donde inicia el programa
    public static void main(String[] args) {
        
        VentanaPrincipal ventana = new VentanaPrincipal(); // Crear objeto ventana

        // Obtener el ancho de la pantalla
        int screenW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;

        // Obtener el alto de la pantalla
        int screenH = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        // Colocar la ventana centrada con tamaño de 800x600
        ventana.setBounds((screenW - 800) / 2, (screenH - 600) / 2, 800, 600);

        ventana.setVisible(true); // Mostrar la ventana
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miventana2.pkg0;
import javax.swing.*;

public class MiVentana20 extends JFrame {

    public MiVentana20 () {
        setLayout(null);
        setTitle("Mi Primera Aplicacion Swing");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MiVentana20 ventana = new MiVentana20();

        int screenW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenH = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        // Nuevo tamaño 1024x768
        ventana.setBounds((screenW - 1024) / 2, (screenH - 768) / 2, 1024, 768);

        ventana.setVisible(true);
    }
}
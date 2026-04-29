/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miventana30;
import javax.swing.*;
/**
 *
 * @author jachr
 */
public class MiVentana30 extends JFrame {

     public MiVentana30() {
        setLayout(null);
        setTitle("Mi Primera Aplicacion Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MiVentana30 ventana = new MiVentana30();
//se quita la linea para ver que pasa
        int screenW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenH = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        ventana.setBounds((screenW - 1024) / 2, (screenH - 768) / 2, 1024, 768);

        ventana.setVisible(true);
    }
}


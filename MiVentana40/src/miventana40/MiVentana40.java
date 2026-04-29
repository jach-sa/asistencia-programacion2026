/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miventana40;
import javax.swing.*;
/**
 *
 * @author jachr
 */
public class MiVentana40 extends JFrame{

     public MiVentana40() {
        setLayout(null);
        setTitle("Mi Primera Aplicacion Swing");
        //Se cambia esta linea del codigo
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) {
        MiVentana40 ventana = new MiVentana40();

        int screenW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenH = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        ventana.setBounds((screenW - 1024) / 2, (screenH - 768) / 2, 1024, 768);

        ventana.setVisible(true);
    }
}
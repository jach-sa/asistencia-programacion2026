/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praformulario;
import javax.swing.*;
/**
 *
 * @author jachr
 */
public class PraFormulario extends JFrame {
private JLabel label1, label2, label3;

    public PraFormulario() {
        setLayout(null);

        // Creamos el primer JLabel
        label1 = new JLabel("Rojo");
        label1.setBounds(10,20,100,30);
        add(label1);

        // Creamos el segundo JLabel
        label2 = new JLabel("Verde");
        label2.setBounds(10,60,100,30);
        add(label2);

        // Creamos el tercer JLabel
        label3 = new JLabel("Azul");
        label3.setBounds(10,100,100,30);
        add(label3);
    }

    public static void main(String[] args) {
        PraFormulario formulario1 = new PraFormulario();
        formulario1.setBounds(0,0,300,200);
        formulario1.setVisible(true);
    }
}
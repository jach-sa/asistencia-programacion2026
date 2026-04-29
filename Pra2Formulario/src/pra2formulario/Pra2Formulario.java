/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pra2formulario;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author jachr
 */
public class Pra2Formulario  extends JFrame implements ActionListener{
   private JLabel label1;
    private JTextField textfield1;
    private JButton boton1;

    public Pra2Formulario() {
        setLayout(null);

        // Creamos el JLabel
        label1 = new JLabel("Usuario:");
        label1.setBounds(10,10,100,30);
        add(label1);

        // Creamos el JTextField
        textfield1 = new JTextField();
        textfield1.setBounds(120,10,150,30);
        add(textfield1);

        // Creamos el boton
        boton1 = new JButton("Aceptar");
        boton1.setBounds(10,60,100,30);
        boton1.addActionListener(this);
        add(boton1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            String cad = textfield1.getText();
            setTitle(cad);
        }
    }

    public static void main(String[] args) {
        Pra2Formulario formulario1 = new Pra2Formulario();
        formulario1.setBounds(0,0,300,150);
        formulario1.setVisible(true);
    }
}
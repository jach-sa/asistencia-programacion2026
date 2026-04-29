/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formularioregistro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class FormularioRegistro extends JFrame implements ActionListener {

    // Declaracion de etiquetas
    private JLabel lblNombre, lblApellido, lblEdad, lblTitulo;

    // Declaracion de cajas de texto
    private JTextField tfNombre, tfApellido, tfEdad;

    // Declaracion del boton
    private JButton btnRegistrar;

    public FormularioRegistro() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Titulo principal de la ventana
        lblTitulo = new JLabel("Formulario de Registro");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(100, 15, 280, 30);
        add(lblTitulo);

        // Etiqueta y campo para nombre
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 65, 100, 25);
        add(lblNombre);

        tfNombre = new JTextField();
        tfNombre.setBounds(130, 65, 220, 25);
        add(tfNombre);

        // Etiqueta y campo para apellido
        lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 105, 100, 25);
        add(lblApellido);

        tfApellido = new JTextField();
        tfApellido.setBounds(130, 105, 220, 25);
        add(tfApellido);

        // Etiqueta y campo para edad
        lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 145, 100, 25);
        add(lblEdad);

        tfEdad = new JTextField();
        tfEdad.setBounds(130, 145, 80, 25);
        add(tfEdad);

        // Boton para registrar datos
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(130, 195, 120, 35);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Verificamos si se presiono el boton registrar
        if (e.getSource() == btnRegistrar) {

            // Guardamos lo escrito en las cajas de texto
            String nombre = tfNombre.getText().trim();
            String apellido = tfApellido.getText().trim();
            String edadStr = tfEdad.getText().trim();

            // Validacion para que no queden campos vacios
            if (nombre.isEmpty() || apellido.isEmpty() || edadStr.isEmpty()) {
                setTitle("ERROR: Completa todos los campos");
                return;
            }

            try {
                // Convertimos la edad a numero entero
                int edad = Integer.parseInt(edadStr);

                // Mostramos los datos en el titulo de la ventana
                setTitle(nombre + " " + apellido + " - " + edad + " anios");

            } catch (NumberFormatException ex) {

                // Mensaje si la edad no es un numero
                setTitle("ERROR: La edad debe ser un numero entero");
            }
        }
    }

    public static void main(String[] args) {

        // Creamos el objeto de la ventana
        FormularioRegistro f = new FormularioRegistro();

        // Tamaño y posicion de la ventana
        f.setBounds(200, 200, 400, 290);

        // Hacemos visible la ventana
        f.setVisible(true);
    }
}
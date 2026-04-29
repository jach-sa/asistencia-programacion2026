/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formularioregistro2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioRegistro2 extends JFrame implements ActionListener {

    // Declaracion de etiquetas
    private JLabel lblNombre, lblApellido, lblEdad, lblTitulo, lblResultado;

    // Declaracion de cajas de texto
    private JTextField tfNombre, tfApellido, tfEdad;

    // Declaracion de botones
    private JButton btnRegistrar, btnLimpiar;

    public FormularioRegistro2() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Titulo principal
        lblTitulo = new JLabel("Formulario de Registro");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(100, 15, 280, 30);
        add(lblTitulo);

        // Etiqueta y campo nombre
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 65, 100, 25);
        add(lblNombre);

        tfNombre = new JTextField();
        tfNombre.setBounds(130, 65, 220, 25);
        add(tfNombre);

        // Etiqueta y campo apellido
        lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 105, 100, 25);
        add(lblApellido);

        tfApellido = new JTextField();
        tfApellido.setBounds(130, 105, 220, 25);
        add(tfApellido);

        // Etiqueta y campo edad
        lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 145, 100, 25);
        add(lblEdad);

        tfEdad = new JTextField();
        tfEdad.setBounds(130, 145, 80, 25);
        add(tfEdad);

        // Boton registrar
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(70, 195, 120, 35);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        // Boton limpiar
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(210, 195, 120, 35);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        // JLabel donde se mostrara el resultado
        lblResultado = new JLabel("Datos del registro apareceran aqui");
        lblResultado.setBounds(40, 245, 320, 25);
        add(lblResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Si se presiona registrar
        if (e.getSource() == btnRegistrar) {

            String nombre = tfNombre.getText().trim();
            String apellido = tfApellido.getText().trim();
            String edadStr = tfEdad.getText().trim();

            // Validacion de campos vacios
            if (nombre.isEmpty() || apellido.isEmpty() || edadStr.isEmpty()) {
                lblResultado.setText("ERROR: Completa todos los campos");
                return;
            }

            try {
                // Convertimos edad a entero
                int edad = Integer.parseInt(edadStr);

                // Mostramos resultado dentro del JLabel
                lblResultado.setText(nombre + " " + apellido + " - " + edad + " anios");

            } catch (NumberFormatException ex) {

                // Error si no se escribe numero en edad
                lblResultado.setText("ERROR: La edad debe ser un numero entero");
            }
        }

        // Si se presiona limpiar
        if (e.getSource() == btnLimpiar) {

            // Limpiamos cajas de texto
            tfNombre.setText("");
            tfApellido.setText("");
            tfEdad.setText("");

            // Restauramos mensaje del JLabel
            lblResultado.setText("Datos del registro apareceran aqui");
        }
    }

    public static void main(String[] args) {
        FormularioRegistro2 f = new FormularioRegistro2();
        f.setBounds(200, 200, 400, 330);
        f.setVisible(true);
    }
}
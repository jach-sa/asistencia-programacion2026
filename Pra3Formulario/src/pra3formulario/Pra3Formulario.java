package pra3formulario;

import javax.swing.*;
import java.awt.event.*;

public class Pra3Formulario extends JFrame implements ActionListener {

    private JLabel lblNombre, lblEdad, lblCiudad, lblResultado;
    private JTextField txtNombre, txtEdad, txtCiudad;
    private JButton btnAceptar, btnLimpiar;

    public Pra3Formulario() {
        setLayout(null);

        // Etiquetas
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 30);
        add(lblNombre);

        lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 60, 100, 30);
        add(lblEdad);

        lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setBounds(20, 100, 100, 30);
        add(lblCiudad);

        // Campos de texto
        txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 150, 30);
        add(txtNombre);

        txtEdad = new JTextField();
        txtEdad.setBounds(100, 60, 150, 30);
        add(txtEdad);

        txtCiudad = new JTextField();
        txtCiudad.setBounds(100, 100, 150, 30);
        add(txtCiudad);

        // Botón aceptar
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(20, 150, 100, 30);
        btnAceptar.addActionListener(this);
        add(btnAceptar);

        // Botón limpiar
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(150, 150, 100, 30);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        // JLabel resultado
        lblResultado = new JLabel("");
        lblResultado.setBounds(20, 200, 300, 30);
        add(lblResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAceptar) {

            String nombre = txtNombre.getText().trim();
            String edadTexto = txtEdad.getText().trim();
            String ciudad = txtCiudad.getText().trim();

            // Validar vacíos
            if (nombre.isEmpty() || edadTexto.isEmpty() || ciudad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No dejes campos vacíos");
                return;
            }

            try {
                int edad = Integer.parseInt(edadTexto);

                lblResultado.setText("Nombre: " + nombre + " | Edad: " + edad + " | Ciudad: " + ciudad);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La edad debe ser un número");
            }
        }

        if (e.getSource() == btnLimpiar) {
            txtNombre.setText("");
            txtEdad.setText("");
            txtCiudad.setText("");
            lblResultado.setText("");
        }
    }

    public static void main(String[] args) {
        Pra3Formulario formulario = new Pra3Formulario();
        formulario.setBounds(0, 0, 350, 300);
        formulario.setTitle("Practica JTextField");
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formulario.setVisible(true);
    }
}
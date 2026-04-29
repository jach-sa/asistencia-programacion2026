/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package editornotas2;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class EditorNotas2 extends JFrame implements ActionListener, DocumentListener {

    // Declaracion del area de texto
    private JTextArea areaNota;

    // Scroll para mover el area
    private JScrollPane scroll;

    // Caja de texto para buscar
    private JTextField tfBuscar;

    // Declaracion de botones
    private JButton btnContar, btnBuscar, btnLimpiar, btnMayusculas;

    // Etiquetas de estado
    private JLabel lblEstado, lblCaracteres;

    public EditorNotas2() {
        setLayout(null);
        setTitle("Editor de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Area de texto principal
        areaNota = new JTextArea();
        areaNota.setLineWrap(true);
        areaNota.setWrapStyleWord(true);
        areaNota.getDocument().addDocumentListener(this);

        // Scroll del area
        scroll = new JScrollPane(areaNota);
        scroll.setBounds(10, 10, 560, 280);
        add(scroll);

        // Campo de busqueda
        tfBuscar = new JTextField();
        tfBuscar.setBounds(10, 310, 200, 30);
        add(tfBuscar);

        // Boton buscar
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(220, 310, 100, 30);
        btnBuscar.addActionListener(this);
        add(btnBuscar);

        // Boton contar palabras
        btnContar = new JButton("Contar palabras");
        btnContar.setBounds(330, 310, 140, 30);
        btnContar.addActionListener(this);
        add(btnContar);

        // Boton limpiar
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(480, 310, 90, 30);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        // Boton mayusculas
        btnMayusculas = new JButton("Mayusculas");
        btnMayusculas.setBounds(220, 350, 120, 30);
        btnMayusculas.addActionListener(this);
        add(btnMayusculas);

        // Etiqueta de estado
        lblEstado = new JLabel("Listo.");
        lblEstado.setBounds(10, 390, 350, 25);
        add(lblEstado);

        // Etiqueta contador de caracteres
        lblCaracteres = new JLabel("Caracteres: 0");
        lblCaracteres.setBounds(400, 390, 150, 25);
        add(lblCaracteres);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = areaNota.getText();

        // Contar palabras
        if (e.getSource() == btnContar) {
            if (texto.trim().isEmpty()) {
                lblEstado.setText("El area esta vacia.");
            } else {
                String[] palabras = texto.trim().split("\\s+");
                lblEstado.setText("Total de palabras: " + palabras.length);
            }
        }

        // Buscar palabra
        if (e.getSource() == btnBuscar) {
            String termino = tfBuscar.getText().trim();

            if (termino.isEmpty()) {
                lblEstado.setText("Escribe algo en el campo de busqueda.");
                return;
            }

            if (texto.contains(termino)) {
                lblEstado.setText("Encontrado: '" + termino + "' en el texto.");
            } else {
                lblEstado.setText("No se encontro: '" + termino + "'");
            }
        }

        // Limpiar contenido
        if (e.getSource() == btnLimpiar) {
            areaNota.setText("");
            tfBuscar.setText("");
            lblEstado.setText("Listo.");
        }

        // Convertir a mayusculas
        if (e.getSource() == btnMayusculas) {
            areaNota.setText(texto.toUpperCase());
            lblEstado.setText("Texto convertido a mayusculas.");
        }
    }

    // Metodo para actualizar contador de caracteres
    public void actualizarContador() {
        int cantidad = areaNota.getText().length();
        lblCaracteres.setText("Caracteres: " + cantidad);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        actualizarContador();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        actualizarContador();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        actualizarContador();
    }

    public static void main(String[] args) {
        EditorNotas2 editor = new EditorNotas2();
        editor.setBounds(150, 100, 600, 470);
        editor.setVisible(true);
    }
}
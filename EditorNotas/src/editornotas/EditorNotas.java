/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package editornotas;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class EditorNotas extends JFrame implements ActionListener {

    // Declaracion del area de texto
    private JTextArea areaNota;

    // Scroll para mover el area de texto
    private JScrollPane scroll;

    // Caja de texto para buscar palabras
    private JTextField tfBuscar;

    // Declaracion de botones
    private JButton btnContar, btnBuscar, btnLimpiar;

    // Etiqueta para mostrar mensajes
    private JLabel lblEstado;

    public EditorNotas() {
        setLayout(null);
        setTitle("Editor de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos el area de texto
        areaNota = new JTextArea();
        areaNota.setLineWrap(true);
        areaNota.setWrapStyleWord(true);

        // Agregamos scroll al area
        scroll = new JScrollPane(areaNota);
        scroll.setBounds(10, 10, 560, 280);
        add(scroll);

        // Campo para escribir la palabra a buscar
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

        // Etiqueta inferior para mostrar resultados
        lblEstado = new JLabel("Listo.");
        lblEstado.setBounds(10, 360, 560, 25);
        add(lblEstado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Guardamos todo el texto escrito
        String texto = areaNota.getText();

        // Si se presiona contar palabras
        if (e.getSource() == btnContar) {
            if (texto.trim().isEmpty()) {
                lblEstado.setText("El area esta vacia.");
            } else {
                String[] palabras = texto.trim().split("\\s+");
                lblEstado.setText("Total de palabras: " + palabras.length);
            }
        }

        // Si se presiona buscar
        if (e.getSource() == btnBuscar) {
            String termino = tfBuscar.getText().trim();

            // Validamos que el campo buscar no este vacio
            if (termino.isEmpty()) {
                lblEstado.setText("Escribe algo en el campo de busqueda.");
                return;
            }

            // Verificamos si la palabra existe dentro del texto
            if (texto.contains(termino)) {
                lblEstado.setText("Encontrado: '" + termino + "' en el texto.");
            } else {
                lblEstado.setText("No se encontro: '" + termino + "'");
            }
        }

        // Si se presiona limpiar
        if (e.getSource() == btnLimpiar) {

            // Limpiamos el area y el campo de busqueda
            areaNota.setText("");
            tfBuscar.setText("");

            // Restauramos el mensaje inicial
            lblEstado.setText("Listo.");
        }
    }

    public static void main(String[] args) {

        // Creamos la ventana principal
        EditorNotas editor = new EditorNotas();

        // Tamaño y posicion
        editor.setBounds(150, 100, 600, 430);

        // Hacemos visible la ventana
        editor.setVisible(true);
    }
}
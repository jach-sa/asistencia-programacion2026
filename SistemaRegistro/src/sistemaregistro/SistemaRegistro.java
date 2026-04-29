/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaregistro;

import javax.swing.*;
import java.awt.event.*;

public class SistemaRegistro extends JFrame implements ActionListener {

    // Campos de texto
    private JLabel lblNombre, lblMatricula, lblPromedio, lblCarrera, lblTurno, lblServicios;
    private JTextField tfNombre, tfMatricula, tfPromedio;

    // ComboBox para carreras
    private JComboBox<String> cmbCarrera;

    // RadioButtons para turno
    private JRadioButton rMatutino, rVespertino, rNocturno;
    private ButtonGroup bgTurno;

    // CheckBox para servicios
    private JCheckBox chkBiblioteca, chkDeportes, chkCafeteria;

    // Boton registrar
    private JButton btnRegistrar;

    // Area donde se acumulan registros
    private JTextArea areaRegistros;
    private JScrollPane scroll;

    // Barra de menu
    private JMenuBar menuBar;
    private JMenu menuOpciones;
    private JMenuItem miNuevo, miLimpiar, miExportar, miSalir;

    public SistemaRegistro() {
        setLayout(null);
        setTitle("Sistema de Registro de Estudiantes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ==================== MENU ====================
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuOpciones = new JMenu("Opciones");
        menuBar.add(menuOpciones);

        miNuevo = new JMenuItem("Nuevo registro");
        miLimpiar = new JMenuItem("Limpiar lista");
        miExportar = new JMenuItem("Exportar");
        miSalir = new JMenuItem("Salir");

        miNuevo.addActionListener(this);
        miLimpiar.addActionListener(this);
        miExportar.addActionListener(this);
        miSalir.addActionListener(this);

        menuOpciones.add(miNuevo);
        menuOpciones.add(miLimpiar);
        menuOpciones.add(miExportar);
        menuOpciones.addSeparator();
        menuOpciones.add(miSalir);

        // ==================== CAMPOS DE TEXTO ====================
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 25);
        add(lblNombre);

        tfNombre = new JTextField();
        tfNombre.setBounds(120, 20, 180, 25);
        add(tfNombre);

        lblMatricula = new JLabel("Matricula:");
        lblMatricula.setBounds(20, 55, 100, 25);
        add(lblMatricula);

        tfMatricula = new JTextField();
        tfMatricula.setBounds(120, 55, 180, 25);
        add(tfMatricula);

        lblPromedio = new JLabel("Promedio:");
        lblPromedio.setBounds(20, 90, 100, 25);
        add(lblPromedio);

        tfPromedio = new JTextField();
        tfPromedio.setBounds(120, 90, 180, 25);
        add(tfPromedio);

        // ==================== COMBOBOX ====================
        lblCarrera = new JLabel("Carrera:");
        lblCarrera.setBounds(20, 125, 100, 25);
        add(lblCarrera);

        String carreras[] = {"Sistemas", "Industrial", "Electronica", "Mecatronica", "Administracion"};
        cmbCarrera = new JComboBox<>(carreras);
        cmbCarrera.setBounds(120, 125, 180, 25);
        add(cmbCarrera);

        // ==================== RADIOBUTTON TURNO ====================
        lblTurno = new JLabel("Turno:");
        lblTurno.setBounds(20, 160, 100, 25);
        add(lblTurno);

        bgTurno = new ButtonGroup();

        rMatutino = new JRadioButton("Matutino");
        rVespertino = new JRadioButton("Vespertino");
        rNocturno = new JRadioButton("Nocturno");

        rMatutino.setBounds(120, 160, 90, 25);
        rVespertino.setBounds(210, 160, 100, 25);
        rNocturno.setBounds(310, 160, 90, 25);

        rMatutino.setSelected(true);

        bgTurno.add(rMatutino);
        bgTurno.add(rVespertino);
        bgTurno.add(rNocturno);

        add(rMatutino);
        add(rVespertino);
        add(rNocturno);

        // ==================== CHECKBOX SERVICIOS ====================
        lblServicios = new JLabel("Servicios:");
        lblServicios.setBounds(20, 195, 100, 25);
        add(lblServicios);

        chkBiblioteca = new JCheckBox("Biblioteca");
        chkDeportes = new JCheckBox("Deportes");
        chkCafeteria = new JCheckBox("Cafeteria");

        chkBiblioteca.setBounds(120, 195, 100, 25);
        chkDeportes.setBounds(220, 195, 100, 25);
        chkCafeteria.setBounds(320, 195, 100, 25);

        add(chkBiblioteca);
        add(chkDeportes);
        add(chkCafeteria);

        // ==================== BOTON REGISTRAR ====================
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(180, 235, 120, 35);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        // ==================== AREA DE REGISTROS ====================
        areaRegistros = new JTextArea();
        areaRegistros.setEditable(false);

        scroll = new JScrollPane(areaRegistros);
        scroll.setBounds(20, 290, 540, 180);
        add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ==================== BOTON REGISTRAR ====================
        if (e.getSource() == btnRegistrar) {

            String nombre = tfNombre.getText().trim();
            String matricula = tfMatricula.getText().trim();
            String promedioStr = tfPromedio.getText().trim();

            if (nombre.isEmpty() || matricula.isEmpty() || promedioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
                return;
            }

            try {
                double promedio = Double.parseDouble(promedioStr);

                String carrera = cmbCarrera.getSelectedItem().toString();
                String turno = "";

                if (rMatutino.isSelected())
                    turno = "Matutino";
                else if (rVespertino.isSelected())
                    turno = "Vespertino";
                else if (rNocturno.isSelected())
                    turno = "Nocturno";

                String servicios = "";

                if (chkBiblioteca.isSelected())
                    servicios += "Biblioteca ";
                if (chkDeportes.isSelected())
                    servicios += "Deportes ";
                if (chkCafeteria.isSelected())
                    servicios += "Cafeteria ";

                if (servicios.equals(""))
                    servicios = "Ninguno";

                String registro = "Nombre: " + nombre +
                        " | Matricula: " + matricula +
                        " | Promedio: " + promedio +
                        " | Carrera: " + carrera +
                        " | Turno: " + turno +
                        " | Servicios: " + servicios + "\n";

                areaRegistros.append(registro);

                JOptionPane.showMessageDialog(this, "Registro realizado correctamente");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El promedio debe ser numerico");
            }
        }

        // ==================== MENU NUEVO REGISTRO ====================
        if (e.getSource() == miNuevo) {
            tfNombre.setText("");
            tfMatricula.setText("");
            tfPromedio.setText("");
            cmbCarrera.setSelectedIndex(0);
            rMatutino.setSelected(true);
            chkBiblioteca.setSelected(false);
            chkDeportes.setSelected(false);
            chkCafeteria.setSelected(false);
        }

        // ==================== MENU LIMPIAR LISTA ====================
        if (e.getSource() == miLimpiar) {
            areaRegistros.setText("");
        }

        // ==================== MENU EXPORTAR ====================
        if (e.getSource() == miExportar) {
            JOptionPane.showMessageDialog(this, "Exportacion simulada correctamente");
        }

        // ==================== MENU SALIR ====================
        if (e.getSource() == miSalir) {
            int op = JOptionPane.showConfirmDialog(this,
                    "Deseas salir del sistema?",
                    "Confirmacion",
                    JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SistemaRegistro s = new SistemaRegistro();
        s.setBounds(120, 80, 600, 530);
        s.setVisible(true);
    }
}

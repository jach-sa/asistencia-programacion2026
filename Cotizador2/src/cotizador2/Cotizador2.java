/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cotizador2;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class Cotizador2 extends JFrame implements ActionListener {

    // Etiquetas informativas
    private JLabel lblPlan, lblExtras, lblTotal;

    // RadioButtons para planes
    private JRadioButton rBasico, rProfesional, rEmpresarial;

    // Grupo para seleccionar solo un plan
    private ButtonGroup bgPlanes;

    // CheckBox para extras
    private JCheckBox chkSoporte, chkBackup, chkSeguridad;

    // Botones
    private JButton btnCotizar, btnLimpiar;

    public Cotizador2() {
        setLayout(null);
        setTitle("Cotizador de Servicios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ==================== PLANES ====================
        lblPlan = new JLabel("Selecciona tu plan:");
        lblPlan.setBounds(20, 15, 200, 25);
        add(lblPlan);

        bgPlanes = new ButtonGroup();

        rBasico = new JRadioButton("Basico $199/mes");
        rProfesional = new JRadioButton("Profesional $399/mes");
        rEmpresarial = new JRadioButton("Empresarial $799/mes");

        rBasico.setBounds(20, 45, 250, 25);
        rProfesional.setBounds(20, 75, 250, 25);
        rEmpresarial.setBounds(20, 105, 250, 25);

        rBasico.setSelected(true);

        bgPlanes.add(rBasico);
        bgPlanes.add(rProfesional);
        bgPlanes.add(rEmpresarial);

        add(rBasico);
        add(rProfesional);
        add(rEmpresarial);

        // ==================== EXTRAS ====================
        lblExtras = new JLabel("Servicios adicionales:");
        lblExtras.setBounds(20, 145, 220, 25);
        add(lblExtras);

        chkSoporte = new JCheckBox("Soporte 24/7 +$99");
        chkBackup = new JCheckBox("Backup diario +$49");
        chkSeguridad = new JCheckBox("Seguridad Plus +$79");

        chkSoporte.setBounds(20, 175, 250, 25);
        chkBackup.setBounds(20, 205, 250, 25);
        chkSeguridad.setBounds(20, 235, 250, 25);

        add(chkSoporte);
        add(chkBackup);
        add(chkSeguridad);

        // ==================== BOTONES ====================
        btnCotizar = new JButton("Ver cotizacion");
        btnCotizar.setBounds(20, 280, 160, 35);
        btnCotizar.addActionListener(this);
        add(btnCotizar);

        btnLimpiar = new JButton("Limpiar seleccion");
        btnLimpiar.setBounds(190, 280, 130, 35);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        // Etiqueta para total
        lblTotal = new JLabel("Total mensual: $0.00");
        lblTotal.setBounds(20, 330, 300, 30);
        add(lblTotal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ==================== BOTON COTIZAR ====================
        if (e.getSource() == btnCotizar) {

            int total = 0;
            String resumen = "Resumen de cotizacion:\n\n";

            // Validamos plan seleccionado
            if (rBasico.isSelected()) {
                total += 199;
                resumen += "Basico: $199\n";
            } else if (rProfesional.isSelected()) {
                total += 399;
                resumen += "Profesional: $399\n";
            } else if (rEmpresarial.isSelected()) {
                total += 799;
                resumen += "Empresarial: $799\n";
            }

            // Validamos extras marcados
            if (chkSoporte.isSelected()) {
                total += 99;
                resumen += "Soporte 24/7: $99\n";
            }

            if (chkBackup.isSelected()) {
                total += 49;
                resumen += "Backup diario: $49\n";
            }

            if (chkSeguridad.isSelected()) {
                total += 79;
                resumen += "Seguridad Plus: $79\n";
            }

            // Mostramos total abajo
            lblTotal.setText(String.format("Total mensual: $%,d MXN", total));

            // Agregamos total al resumen
            resumen += "\nTOTAL: $" + total + " MXN";

            // JOptionPane muestra una ventana emergente con el desglose completo
            JOptionPane.showMessageDialog(this, resumen);
        }

        // ==================== BOTON LIMPIAR ====================
        if (e.getSource() == btnLimpiar) {

            // Regresa el plan a basico
            rBasico.setSelected(true);

            // Desmarca todos los extras
            chkSoporte.setSelected(false);
            chkBackup.setSelected(false);
            chkSeguridad.setSelected(false);

            // Reinicia el total
            lblTotal.setText("Total mensual: $0.00");
        }
    }

    public static void main(String[] args) {
        Cotizador2 cot = new Cotizador2();
        cot.setBounds(200, 150, 350, 420);
        cot.setVisible(true);
    }
}

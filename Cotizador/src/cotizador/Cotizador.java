/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cotizador;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class Cotizador extends JFrame implements ActionListener {

    // ==================== COMPONENTES DE PLAN BASE ====================
    // Etiquetas informativas
    private JLabel lblPlan, lblExtras, lblTotal;

    // RadioButtons para elegir un solo plan
    private JRadioButton rBasico, rProfesional, rEmpresarial;

    // ButtonGroup para que solo uno pueda estar seleccionado
    private ButtonGroup bgPlanes;

    // ==================== COMPONENTES DE SERVICIOS EXTRA ====================
    // CheckBox para elegir varios extras al mismo tiempo
    private JCheckBox chkSoporte, chkBackup, chkSeguridad;

    // Boton para calcular la cotizacion
    private JButton btnCotizar;

    public Cotizador() {
        setLayout(null);
        setTitle("Cotizador de Servicios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ==================== SECCION PLANES ====================
        // Etiqueta superior para indicar que se seleccione un plan
        lblPlan = new JLabel("Selecciona tu plan:");
        lblPlan.setBounds(20, 15, 200, 25);
        add(lblPlan);

        // Se crea el grupo para coordinar los radio buttons
        bgPlanes = new ButtonGroup();

        // Se crean las opciones de plan
        rBasico = new JRadioButton("Basico $199/mes");
        rProfesional = new JRadioButton("Profesional $399/mes");
        rEmpresarial = new JRadioButton("Empresarial $799/mes");

        // Posiciones de cada radio button
        rBasico.setBounds(20, 45, 250, 25);
        rProfesional.setBounds(20, 75, 250, 25);
        rEmpresarial.setBounds(20, 105, 250, 25);

        // Se deja el plan basico marcado por defecto
        rBasico.setSelected(true);

        // Se agregan al ButtonGroup para que solo uno se pueda elegir
        bgPlanes.add(rBasico);
        bgPlanes.add(rProfesional);
        bgPlanes.add(rEmpresarial);

        // Se agregan a la ventana
        add(rBasico);
        add(rProfesional);
        add(rEmpresarial);

        // ==================== SECCION EXTRAS ====================
        // Etiqueta que indica servicios adicionales
        lblExtras = new JLabel("Servicios adicionales:");
        lblExtras.setBounds(20, 145, 220, 25);
        add(lblExtras);

        // Se crean los CheckBox de extras
        chkSoporte = new JCheckBox("Soporte 24/7 +$99");
        chkBackup = new JCheckBox("Backup diario +$49");
        chkSeguridad = new JCheckBox("Seguridad Plus +$79");

        // Posiciones
        chkSoporte.setBounds(20, 175, 250, 25);
        chkBackup.setBounds(20, 205, 250, 25);
        chkSeguridad.setBounds(20, 235, 250, 25);

        // Se agregan a la ventana
        add(chkSoporte);
        add(chkBackup);
        add(chkSeguridad);

        // ==================== BOTON COTIZAR ====================
        // Boton que calculara el costo total
        btnCotizar = new JButton("Ver cotizacion");
        btnCotizar.setBounds(20, 280, 160, 35);
        btnCotizar.addActionListener(this);
        add(btnCotizar);

        // Etiqueta donde se mostrara el total
        lblTotal = new JLabel("Total mensual: $0.00");
        lblTotal.setBounds(20, 330, 300, 30);
        add(lblTotal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Variable donde se ira acumulando el costo total
        int total = 0;

        // ==================== VALIDACION DEL PLAN BASE ====================
        // isSelected() retorna true si el radio button esta marcado

        if (rBasico.isSelected())
            total += 199;

        else if (rProfesional.isSelected())
            total += 399;

        else if (rEmpresarial.isSelected())
            total += 799;

        // ==================== VALIDACION DE EXTRAS ====================
        // JCheckBox permite sumar varios servicios al mismo tiempo

        if (chkSoporte.isSelected())
            total += 99;

        if (chkBackup.isSelected())
            total += 49;

        if (chkSeguridad.isSelected())
            total += 79;

        // Se muestra el total final en la etiqueta inferior
        lblTotal.setText(String.format("Total mensual: $%,d MXN", total));
    }

    public static void main(String[] args) {

        // Se crea el objeto principal del programa
        Cotizador cot = new Cotizador();

        // Tamaño y posicion de la ventana
        cot.setBounds(200, 150, 340, 420);

        // Se hace visible
        cot.setVisible(true);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class Calculadora extends JFrame implements ActionListener {

    // Declaracion de etiquetas
    private JLabel lblNum1, lblNum2, lblOp, lblResultado;

    // Declaracion de cajas de texto
    private JTextField tfNum1, tfNum2;

    // Lista desplegable para elegir la operacion
    private JComboBox<String> cmbOperacion;

    // Boton para calcular
    private JButton btnCalcular;

    public Calculadora() {
        setLayout(null);
        setTitle("Calculadora Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Etiqueta y caja para numero 1
        lblNum1 = new JLabel("Numero 1:");
        lblNum1.setBounds(20, 20, 100, 25);
        add(lblNum1);

        tfNum1 = new JTextField();
        tfNum1.setBounds(130, 20, 120, 25);
        add(tfNum1);

        // Etiqueta y caja para numero 2
        lblNum2 = new JLabel("Numero 2:");
        lblNum2.setBounds(20, 60, 100, 25);
        add(lblNum2);

        tfNum2 = new JTextField();
        tfNum2.setBounds(130, 60, 120, 25);
        add(tfNum2);

        // Etiqueta para la operacion
        lblOp = new JLabel("Operacion:");
        lblOp.setBounds(20, 100, 100, 25);
        add(lblOp);

        // Opciones del JComboBox
        String[] ops = { "Suma (+)", "Resta (-)", "Multiplicacion (*)", "Division (/)" };

        cmbOperacion = new JComboBox<>(ops);
        cmbOperacion.setBounds(130, 100, 180, 25);
        add(cmbOperacion);

        // Boton calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(130, 145, 120, 35);
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        // Etiqueta donde aparecera el resultado
        lblResultado = new JLabel("Resultado: ---");
        lblResultado.setBounds(20, 200, 320, 30);
        add(lblResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Convertimos a numeros lo que el usuario escribio
            double n1 = Double.parseDouble(tfNum1.getText().trim());
            double n2 = Double.parseDouble(tfNum2.getText().trim());

            // Guardamos la operacion seleccionada
            int opIndex = cmbOperacion.getSelectedIndex();

            double resultado = 0;

            // Evaluamos que operacion se eligio
            switch (opIndex) {
                case 0:
                    resultado = n1 + n2;
                    break;

                case 1:
                    resultado = n1 - n2;
                    break;

                case 2:
                    resultado = n1 * n2;
                    break;

                case 3:
                    if (n2 == 0) {
                        lblResultado.setText("Error: Division por cero");
                        return;
                    }
                    resultado = n1 / n2;
                    break;
            }

            // Mostramos el resultado con dos decimales
            lblResultado.setText(String.format("Resultado: %.2f", resultado));

        } catch (NumberFormatException ex) {

            // Mensaje si no se escriben numeros validos
            lblResultado.setText("Error: ingresa valores numericos validos");
        }
    }

    public static void main(String[] args) {

        // Creamos la ventana principal
        Calculadora c = new Calculadora();

        // Tamaño y posicion de la ventana
        c.setBounds(250, 200, 380, 280);

        // Hacemos visible la ventana
        c.setVisible(true);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora2;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jachr
 */
public class Calculadora2 extends JFrame implements ActionListener {

    // Declaracion de etiquetas
    private JLabel lblNum1, lblNum2, lblOp, lblResultado, lblProceso;

    // Declaracion de cajas de texto
    private JTextField tfNum1, tfNum2;

    // Lista desplegable
    private JComboBox<String> cmbOperacion;

    // Boton calcular
    private JButton btnCalcular;

    public Calculadora2() {
        setLayout(null);
        setTitle("Calculadora Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Etiqueta y campo numero 1
        lblNum1 = new JLabel("Numero 1:");
        lblNum1.setBounds(20, 20, 100, 25);
        add(lblNum1);

        tfNum1 = new JTextField();
        tfNum1.setBounds(130, 20, 120, 25);
        add(tfNum1);

        // Etiqueta y campo numero 2
        lblNum2 = new JLabel("Numero 2:");
        lblNum2.setBounds(20, 60, 100, 25);
        add(lblNum2);

        tfNum2 = new JTextField();
        tfNum2.setBounds(130, 60, 120, 25);
        add(tfNum2);

        // Etiqueta operacion
        lblOp = new JLabel("Operacion:");
        lblOp.setBounds(20, 100, 100, 25);
        add(lblOp);

        // Opciones del combo
        String[] ops = { "Suma (+)", "Resta (-)", "Multiplicacion (*)", "Division (/)", "Potencia (^)" };

        cmbOperacion = new JComboBox<>(ops);
        cmbOperacion.setBounds(130, 100, 180, 25);
        add(cmbOperacion);

        // Boton calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(130, 145, 120, 35);
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        // Etiqueta resultado
        lblResultado = new JLabel("Resultado: ---");
        lblResultado.setBounds(20, 200, 320, 25);
        add(lblResultado);

        // Etiqueta para mostrar la operacion completa
        lblProceso = new JLabel("Operacion completa: ---");
        lblProceso.setBounds(20, 230, 320, 25);
        add(lblProceso);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(tfNum1.getText().trim());
            double n2 = Double.parseDouble(tfNum2.getText().trim());

            int opIndex = cmbOperacion.getSelectedIndex();
            double resultado = 0;
            String signo = "";

            // Evaluamos la operacion seleccionada
            switch (opIndex) {
                case 0:
                    resultado = n1 + n2;
                    signo = "+";
                    break;

                case 1:
                    resultado = n1 - n2;
                    signo = "-";
                    break;

                case 2:
                    resultado = n1 * n2;
                    signo = "*";
                    break;

                case 3:
                    if (n2 == 0) {
                        lblResultado.setText("Error: Division por cero");
                        lblProceso.setText("Operacion completa: ---");
                        return;
                    }
                    resultado = n1 / n2;
                    signo = "/";
                    break;

                case 4:
                    resultado = Math.pow(n1, n2);
                    signo = "^";
                    break;
            }

            // Mostramos resultado
            lblResultado.setText(String.format("Resultado: %.2f", resultado));

            // Mostramos la operacion completa
            lblProceso.setText(String.format("Operacion completa: %.2f %s %.2f = %.2f", n1, signo, n2, resultado));

        } catch (NumberFormatException ex) {
            lblResultado.setText("Error: ingresa valores numericos validos");
            lblProceso.setText("Operacion completa: ---");
        }
    }

    public static void main(String[] args) {
        Calculadora2 c = new Calculadora2();
        c.setBounds(250, 200, 400, 320);
        c.setVisible(true);
    }
}
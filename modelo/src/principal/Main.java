/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import vista.FrmLogin;
import javax.swing.SwingUtilities;
public class Main {
 public static void main(String[] args) {
 // Ejecutar en el hilo de la interfaz gráfica (EDT)
 SwingUtilities.invokeLater(() -> {
 new FrmLogin().setVisible(true);
 });
 }
}
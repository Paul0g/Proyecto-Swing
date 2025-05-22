import javax.swing.*;
import GUI.Sesion;
import LigasYColas.Global;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Global.listaEmpleados.cargarDesdeArchivo("Empleados.txt");
        JFrame frame = new JFrame("Inicio de Sesión"); // ✅ Esto es un JFrame
        frame.setContentPane(new Sesion().getPanel()); // ✅ panel1 viene de tu .form
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);  // Tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar en pantalla
        frame.setVisible(true); // Mostrar ventana
    }
}
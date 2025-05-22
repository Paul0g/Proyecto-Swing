/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import GUI.InicioSesion;
import javax.swing.JFrame;

/**
 *
 * @author Papolo4
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(() -> {
            new GUI.Sesion().setVisible(true);
        });
    }
    
}

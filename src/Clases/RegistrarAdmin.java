package Clases;

import Clases.Administrador;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
public class RegistrarAdmin  extends JFrame {
    private JPanel panel;
    private JTextField nombreField;
    private JTextField correoField;
    private JPasswordField passField;
    private JPasswordField cofimarcontra;
    private JButton guardarButton;

    public RegistrarAdmin() {
        setTitle("Registrar Administrador");
        setSize(360, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel(null);
        add(panel);

        JLabel nombreLabel = new JLabel("Nombre completo:");
        nombreLabel.setBounds(20, 20, 120, 25);
        panel.add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(150, 20, 170, 25);
        panel.add(nombreField);

        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setBounds(20, 60, 120, 25);
        panel.add(correoLabel);

        correoField = new JTextField();
        correoField.setBounds(150, 60, 170, 25);
        panel.add(correoField);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(20, 100, 120, 25);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150, 100, 170, 25);
        panel.add(passField);

        JLabel confirmarLabel = new JLabel("Confirmar contraseña:");
        confirmarLabel.setBounds(20, 130, 140, 25);
        panel.add(confirmarLabel);

        cofimarcontra= new JPasswordField();
        cofimarcontra.setBounds(150, 130, 170, 25);
        panel.add(cofimarcontra);

        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(110, 170, 120, 30);
        panel.add(guardarButton);

        guardarButton.addActionListener(e -> guardarAdministrador());
    }

    private void guardarAdministrador() {
        String nombre = nombreField.getText().trim();
        String correo = correoField.getText().trim();
        String pass = new String(passField.getPassword()).trim();

        if (nombre.isEmpty() || correo.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        if (!correo.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Correo no válido.");
            return;
        }

        if (!pass.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            JOptionPane.showMessageDialog(this,
                    "La contraseña debe tener al menos 8 caracteres, una letra y un número.");
            return;
        }

        String confirmarPass = new String(cofimarcontra.getPassword()).trim();

        if (!pass.equals(confirmarPass)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        Administrador admin = new Administrador(correo, pass, nombre);

        try {
            FileWriter fw = new FileWriter("administradores.txt", true);
            fw.write(admin.getCorreo() + "," + admin.getContrasenaHash() + "," + admin.getNombreCompleto() + "\n");
            fw.close();
            JOptionPane.showMessageDialog(this, "Administrador registrado.");
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el usuario.");
        }
    }
}

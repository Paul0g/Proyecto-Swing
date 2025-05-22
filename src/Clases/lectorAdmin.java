package Clases;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lectorAdmin {
    private static final String RUTA_ARCHIVO = "administradores.txt";

    // Guarda un administrador en el archivo (agrega al final)
    public static void guardarAdministrador(Administrador admin) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            // Guarda como: correo,contrasenaHash,nombreCompleto
            String linea = admin.getCorreo() + "," + admin.getContrasenaHash() + "," + admin.getNombreCompleto();
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
        }
    }

    public static List<Administrador> cargarAdministradores() {
        List<Administrador> admins = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(RUTA_ARCHIVO))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",", 3);
                if (partes.length == 3) {
                    Administrador admin = new Administrador(partes[0], partes[1], partes[2]);
                    admins.add(admin);
                }
            }
        } catch (IOException e) {
        }
        return admins;
    }

    public static boolean validarLogin(String correo, String contrasena) {
        List<Administrador> admins = cargarAdministradores();
        for (Administrador admin : admins) {
            if (admin.getCorreo().equalsIgnoreCase(correo) && admin.verificarContrasena(contrasena)) {
                return true;
            }
        }
        return false;
    }
}

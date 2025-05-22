package Clases;

public class Administrador {
    private String correo;
    private String contrasenaHash;
    private String nombreCompleto;


    public Administrador(String usuario, String contrasena, String nombreCompleto) {
        this.correo = usuario;
        this.contrasenaHash = hashContrasena(contrasena);
        this.nombreCompleto = nombreCompleto;
    }



    private String hashContrasena(String contrasena) {

        return Integer.toString(contrasena.hashCode());
    }


    public String getCorreo() {
        return correo;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public boolean verificarContrasena(String contrasenaIngresada) {
        return this.contrasenaHash.equals(hashContrasena(contrasenaIngresada));
    }

    public static String hashPassword(String contrasena) {
        return Integer.toString(contrasena.hashCode());
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "usuario='" + correo + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
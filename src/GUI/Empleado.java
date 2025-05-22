package GUI;

    public class Empleado {
        private String id;
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String edad;
        private String sexo;
        private String direccion;
        private String telefono;
        private String puesto;
        private String departamento;
        private int horasTrabajadas;
        private double costoPorHora;


        public Empleado(String id, String nombre, String apellidoPaterno, String apellidoMaterno,
                        String edad, String sexo, String direccion, String telefono,
                        String puesto, String departamento,
                        int horasTrabajadas, double costoPorHora) {
            this.id = id;
            this.nombre = nombre;
            this.apellidoPaterno = apellidoPaterno;
            this.apellidoMaterno = apellidoMaterno;
            this.edad = edad;
            this.sexo = sexo;
            this.direccion = direccion;
            this.telefono = telefono;
            this.puesto = puesto;
            this.departamento = departamento;
            this.horasTrabajadas = horasTrabajadas;
            this.costoPorHora = costoPorHora;
        }

    

        public double calcularSueldo() {
            return horasTrabajadas * costoPorHora;
        }

        public String toCSV() {
            return String.join(",", id, nombre, apellidoPaterno, apellidoMaterno,
                    String.valueOf(edad), sexo, direccion, telefono, puesto,
                    departamento, String.valueOf(horasTrabajadas),
                    String.valueOf(costoPorHora), String.valueOf(calcularSueldo()));
        }

        public static Empleado fromCSV(String linea) {
            String[] p = linea.split(",");
            return new Empleado(
                    p[0],
                    p[1],
                    p[2],
                    p[3],
                    (p[4]),
                    p[5],
                    p[6],
                    p[7],
                    p[8],
                    p[9],
                    Integer.parseInt(p[10]),
                    Double.parseDouble(p[11])

            );
        }


        public String getId() { return id; }
        public String getNombre() {
            return nombre;
        }
        public String getPaterno(){
        return apellidoPaterno;}
        public String getMaterno(){
        return apellidoMaterno;}
        public String getedad(){
        return edad;}
        public String getsexo(){
        return sexo;}
        public String getDi(){
        return direccion;}
        public String gettel(){
        return telefono;}
        public String getPu(){
        return puesto;}
        public String getdepa(){
        return departamento;}
        public int getHorasTra(){
        return horasTrabajadas;}
        public double getCostoH(){
        return costoPorHora;}
    }




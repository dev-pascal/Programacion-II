public class Propietario {
    /*Atributos*/
    private int DNI;
    private String nombre;
    private String apellido;
    private String email;
    
    /*Constructores*/
    public Propietario (int DNI, String nombre, String apellido, String email) {
        this.DNI=DNI;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
    }
    public Propietario () {
    }
    /*Métodos set*/
        public void setDNI (int DNI) {
            this.DNI=DNI;
        }
        public void setEmail (String email) {
            this.email=email;
        }
        public void setNombre (String nombre) {
            this.nombre=nombre;
        }
        public void setApellido (String apellido) {
            this.apellido=apellido;
        }
    /*Métodos get*/
        public int getDNI () {
            return this.DNI;
        }
        public String getEmail () {
            return this.email;
        }
        public String getNombre () {
            return this.nombre;
        }
        public String getApellido () {
            return this.apellido;
        }
    public String toString () {
        return ("DATOS DE PROPIETARIO= DNI:"+this.getDNI()+"//Nombre:"+this.getNombre()+"//Apellido:"+this.getApellido()+"//Email:"+this.getEmail());
    }
}
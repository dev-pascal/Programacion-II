public class Responsable {
    /*Atributos*/
    private int DNI;
    private String nombre;
    private String apellido;
    
    /*Constructores*/
    public Responsable (int DNI, String nombre, String apellido) {
        this.DNI=DNI;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public Responsable () {
    }
    public void setDNI (int DNI) {
        this.DNI=DNI;
    }
    public void setNombre (String nombre) {
        this.nombre=nombre;
    }
    public void setApellido (String apellido) {
        this.apellido=apellido;
    }
    public int getDNI () {
        return this.DNI;
    }
    public String getNombre () {
        return this.nombre;
    }
    public String getApellido () {
        return this.apellido;
    }
    public String toString () {
        return ("DNI "+this.getDNI()+"// Apellido y Nombre: "+this.getApellido()+" "+this.getNombre());
    }
}
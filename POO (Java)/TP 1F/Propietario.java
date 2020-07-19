public class Propietario {
    /*Atributos*/
    private int CIT;
    private String nombre;
    private String apellido;
    
    /*Constructores*/
    public Propietario () {
    }
    public Propietario (int CIT, String nombre, String apellido) {
        this.CIT=CIT;
        this.nombre=nombre;
        this.apellido=apellido;
    }
        /*--métodos get--*/
    public int getCIT () {
        return this.CIT;
    }
    public String getNombre () {
        return this.nombre;
    }
    public String getApellido () {
        return this.apellido;
    }
        /*--métodos set--*/
    public void setCIT (int CIT) {
        this.CIT=CIT;
    }
    public void setNombre (String nombre) {
        this.nombre=nombre;
    }
    public void setApellido (String apellido) {
        this.apellido=apellido;
    }
    
    public String toString () {
        return ("CIT:"+this.CIT+"//Nombre:"+this.nombre+"//Apellido:"+this.apellido);
    }
}
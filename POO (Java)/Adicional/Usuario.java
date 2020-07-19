public abstract class Usuario {
    /*Atributos*/
    private int codigo;
    private String nombre;
    private String email;
    
    /*Constructores*/
    public Usuario (int codigo, String nombre, String email) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.email=email;
    }
    public Usuario () {
    }
        /*métodos get*/
    public int getCodigo () {
        return this.codigo;
    }
    public String getNombre () {
        return this.nombre;
    }
    public String getEmail () {
        return this.email;
    }
        /*métodos set*/
    public void setCodigo (int codigo) {
        this.codigo=codigo;
    }
    public void setNombre (String nombre) {
        this.nombre=nombre;
    }
    public void setEmail (String email) {
        this.email=email;
    }
    
    /*Método polimorfico*/
    public abstract double CalcularFacturacion ();
}
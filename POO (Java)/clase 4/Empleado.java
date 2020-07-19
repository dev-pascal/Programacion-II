public abstract class Empleado {
    /*Defino atributos*/
    private String nombre;
    private double sueldo;
    
    /*Defino constructores*/
    public Empleado (String nombre, double sueldo) {
        this.nombre=nombre;
        this.sueldo=sueldo;
    }
    public Empleado () {
    }
    public void setNombre (String nombre) {
        this.nombre=nombre;
    }
    public void setSueldo (double sueldo) {
        this.sueldo=sueldo;
    }
    public String getNombre () {
        return this.nombre;
    }
    public double getSueldo () {
        return this.sueldo;
    }
    public String toString () {
        return ("Nombre:"+this.nombre+"// Sueldo:"+this.sueldo);
    }
    
    /*Defino métodos no abstractos*/
    /*...*/
    
    /*Defino métodos abstractos*/
    public abstract double calcularSueldoACobrar(double sueldo);
}
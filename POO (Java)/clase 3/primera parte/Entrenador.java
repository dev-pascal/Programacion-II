import java.util.Scanner;
public class Entrenador {
    private String nombre;
    private double sueldo;
    private int cant;
    public Entrenador (String nombre, double sueldo, int cant){
        this.nombre=nombre;
        this.sueldo=sueldo;
        this.cant=cant;
    }
    public Entrenador () {
    }
    public String getNombre () {
        return nombre;
    }
    public double getSueldo () {
        return sueldo;
    }
    public int getCant () {
        return cant;
    }
    public void setNombre (String unNombre) {
        nombre=unNombre;
    }
    public void setSueldo (double unSueldo) {
        sueldo=unSueldo;
    }
    public void setCant (int unaCantidad) {
        cant=unaCantidad;
    }
    public double calcularSueldoACobrar () {
        double sueldo=0;
        if (this.cant!=0) {
            if ((this.cant>=1) && (this.cant<=4))
                sueldo=this.sueldo+5000;
            else
                if ((this.cant>=5) && (this.cant<=10))
                    sueldo=this.sueldo+30000;
                else
                    if (this.cant>10)
                        sueldo=this.sueldo+50000;
        }
        else
            sueldo=this.sueldo;
        return sueldo;
    }
}
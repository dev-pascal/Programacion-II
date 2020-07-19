public class Jugador extends Empleado {
    /*Atributos*/
    private int cant_partidos;
    private int cant_goles;
    
    /*Constructores*/

    public Jugador (String nombre, double sueldo, int cant_partidos, int cant_goles) {
        super(nombre,sueldo);
        this.cant_partidos=cant_partidos;
        this.cant_goles=cant_goles;
    }
    public Jugador (int cant_partidos, int cant_goles) {
        this.cant_partidos=cant_partidos;
        this.cant_goles=cant_goles;
    }
    public Jugador () {
    }
    public void setPartidos (int cant_partidos) {
        this.cant_partidos=cant_partidos;
    }
    public void setGoles (int cant_goles) {
        this.cant_goles=cant_goles;
    }
    public int getPartidos () {
        return this.cant_partidos;
    }
    public int getGoles () {
        return this.cant_goles;
    }
    
    public double calcularSueldoACobrar (double sueldo) {  
        double promedio=0;
        if (this.cant_goles!=0)
            promedio=this.cant_partidos/this.cant_goles;
        if (promedio>0.5)
            sueldo=sueldo*2;
        return sueldo;
    }
}
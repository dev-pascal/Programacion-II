public class Entrenador extends Empleado {
    /*Atributos*/
    private int cant_campeonatos;
    
    /*Constructores*/
    public Entrenador (int cant_campeonatos) {
        this.cant_campeonatos=cant_campeonatos;
    } 
    public Entrenador (String nombre, double sueldo, int cant_campeonatos) {
        super(nombre,sueldo);
        this.cant_campeonatos=cant_campeonatos;
    }
    public Entrenador () {
    }
    public void setCampeonatos (int cant_campeonatos) {
        this.cant_campeonatos=cant_campeonatos;
    }
    public int getCampeonatos () {
        return cant_campeonatos;
    }
    
    /*Metodos*/
    public double calcularSueldoACobrar (double sueldo) {
        if (this.cant_campeonatos!=0)
            if ((this.cant_campeonatos>=1) && (this.cant_campeonatos<=4))
                sueldo=sueldo+5000;
                else
                    if ((this.cant_campeonatos>=5) && (this.cant_campeonatos<=10))
                        sueldo=sueldo+30000;
                    else
                        if (this.cant_campeonatos>10)
                            sueldo=sueldo+50000;
        return sueldo;
    }
}
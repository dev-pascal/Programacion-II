public abstract class Vehículo {
    /*Atributos*/
    private int año;
    private double importe;
    private Propietario propietario;
    
    /*Constructores*/
    public Vehículo () {
    }
    public Vehículo (int año, double importe, Propietario propietario) {
        this.año=año;
        this.importe=importe;
        this.propietario=propietario;
    }
        /*--métodos get--*/
    public int getAño () {
        return this.año;
    }
    public double getImporte () {
        return this.importe;
    }
    public Propietario getPropietario () {
        return this.propietario;
    }
        /*--métodos set--*/
    public void setAño (int año) {
        this.año=año;
    }
    public void setImporte (double importe) {
        this.importe=importe;
    }
    public void setPropietario (Propietario propietario) {
        this.propietario=propietario;
    }
    
    /*Método polimórfico*/
    public abstract double CalcularImpuesto ();
}
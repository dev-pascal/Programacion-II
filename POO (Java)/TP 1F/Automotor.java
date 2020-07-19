public class Automotor extends Vehículo {
    /*Atributos*/
    private String patente;
    private double importeAdicional;
    private String descripcion;
    
    /*Constructores*/
    public Automotor () {
    }
    public Automotor (String patente, double importeAdicional, String descripcion, int año, double importe, Propietario propietario) {
        super(año,importe,propietario);
        this.patente=patente;
        this.importeAdicional=importeAdicional;
        this.descripcion=descripcion;
    }
        /*--métodos get--*/
    public String getPatente () {
        return this.patente;
    }
    public double getImporteAd () {
        return this.importeAdicional;
    }
    public String getDescripcion () {
        return this.descripcion;
    }
        /*--métodos set--*/
    public void setPatente (String patente) {
        this.patente=patente;
    }
    public void setImporteAd (double importeAdicional) {
        this.importeAdicional=importeAdicional;
    }
    public void setDescripcion (String descripcion) {
        this.descripcion=descripcion;
    }
    
    /*métodos polimórficos*/
    public String toString () {
        return ("Patente:"+this.patente+"//Año de fabricación:"+super.getAño());
    }
    public double CalcularImpuesto () {
        return (super.getImporte()+this.importeAdicional);
    }
}
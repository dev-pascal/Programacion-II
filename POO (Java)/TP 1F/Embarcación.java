public class Embarcación extends Vehículo {
    /*Atributos*/
    private int REY;
    private String tipoEmbarcación;
    private double eslora;
    private double tonelaje;
    private double valor;
    
    /*Constructores*/
    
    public Embarcación () {
    }
    public Embarcación (int REY, String tipoEmbarcación, double eslora, double tonelaje, double valor, int año, double importe, Propietario propietario) {
        super(año,importe,propietario);
        this.REY=REY;
        this.tipoEmbarcación=tipoEmbarcación;
        this.eslora=eslora;
        this.tonelaje=tonelaje;
        this.valor=valor;        
    }
        /*--métodos get--*/
    public int getREY () {
        return this.REY;
    }
    public String getTipo () {
        return this.tipoEmbarcación;
    }
    public double getEslora () {
        return this.eslora;
    }
    public double getTonelaje () {
        return this.tonelaje;
    }
    public double getValor () {
        return this.valor;
    }
        /*--métodos set--*/
    public void setREY (int REY) {
        this.REY=REY;
    }
    public void setTipo (String tipoEmbarcación) {
        this.tipoEmbarcación=tipoEmbarcación;
    }
    public void setEslora (double eslora) {
        this.eslora=eslora;
    }
    public void setTonelaje (double tonelaje) {
        this.tonelaje=tonelaje;
    }
    public void setValor (double valor) {
        this.valor=valor;
    }
    
    /*métodos polimórficos*/
    public String toString () {
        return ("Codigo REY:"+this.REY+"//Tipo de embarcación:"+this.tipoEmbarcación+"//Tonelaje:"+this.tonelaje);
    }
    public double CalcularImpuesto () {
        double impuesto=0;
        if (this.valor!=0) { 
            if (this.valor>6000)
                impuesto=(4*this.valor)/100;  
            else
                if ((this.valor>=6000) && (this.valor>=180000)) 
                    impuesto=(2*this.valor)/100;          
                else
                    if (this.valor>180000) 
                        impuesto=(5*this.valor)/100;
        }
        return impuesto;
    }
}
public class Departamento extends Inmueble {
    /*Atributos*/
    private double expensas;
    private boolean existeEncargado;
    /*Constructores*/
    public Departamento (String codigo, String direccion, double m2, String tipoVenta, Propietario propietario, double expensas, boolean existeEncargado) {
        super(codigo,direccion,m2,tipoVenta,propietario);
        this.expensas=expensas;
        this.existeEncargado=existeEncargado;
    }
    public Departamento () {
    }
        /*Métodos get*/
        public double getExpensas () {
            return this.expensas;
        }
        public boolean getEncargado () {
            return this.existeEncargado;
        }
        /*Métodos set*/
        public void setExpensas (double expensas) {
            this.expensas=expensas;
        }
        public void setEncargado (boolean existeEncargado) {
            this.existeEncargado=existeEncargado;
        }
    /*Método polimorfico*/
    public double CalcularValor () {
        double valor=0;
        boolean condicion1venta=(super.getTipoVenta()).equals("Venta");
        boolean condicion2venta=((super.getTipoVenta()).toUpperCase()).equals("VENTA");
        boolean condicion3venta=((super.getTipoVenta()).toLowerCase()).equals("venta");
        boolean condicion1al=(super.getTipoVenta()).equals("Alquiler");
        boolean condicion2al=((super.getTipoVenta()).toUpperCase()).equals("ALQUILER");
        boolean condicion3al=((super.getTipoVenta()).toLowerCase()).equals("alquiler");
        if ((condicion1venta) || (condicion2venta) || (condicion3venta))
            valor=super.getM2()*3000+this.getExpensas()*12;
        else
            if ((condicion1al) || (condicion2al) || (condicion3al))
                valor=super.getM2()*10+this.getExpensas()*2;
        return valor;
    }
    public String toString () {
        return ((super.ImprimirPadre())+"DEPARTAMENTO= Expensas:"+this.getExpensas()+"// Hay encargado? (tipo boolean):"+this.getEncargado());
    }   
}
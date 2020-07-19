public class Casa extends Inmueble {
    /*Atributos*/
    private double tamaño_lote;
    /*Constructores*/
    public Casa (String codigo, String direccion, double m2, String tipoVenta, Propietario propietario, double tamaño_lote) {
        super(codigo,direccion,m2,tipoVenta,propietario);
        this.tamaño_lote=tamaño_lote;
    }
    public Casa () {
    }
        /*Método set*/
        public void setTamañoLote (double tamaño_lote) {
            this.tamaño_lote=tamaño_lote;
        }
        /*Método get*/
        public double getTamañoLote () {
            return this.tamaño_lote;
        }
    /*Método polimorfico*/
    public double CalcularValor () {
        double valor=0;
        if (super.getTipoVenta()!=null) {
            boolean condicion1venta=(super.getTipoVenta()).equals("Venta");
            boolean condicion2venta=((super.getTipoVenta()).toUpperCase()).equals("VENTA");
            boolean condicion3venta=((super.getTipoVenta()).toLowerCase()).equals("venta");
            boolean condicion1al=(super.getTipoVenta()).equals("Alquiler");
            boolean condicion2al=((super.getTipoVenta()).toUpperCase()).equals("ALQUILER");
            boolean condicion3al=((super.getTipoVenta()).toLowerCase()).equals("alquiler");
            if ((condicion1venta) || (condicion2venta) || (condicion3venta))
                valor=this.getTamañoLote()*1000+super.getM2()*2500;
            else
                if ((condicion1al) || (condicion2al) || (condicion3al))
                    valor=super.getM2()*10;
        }
        return valor;
    }
    public String toString () {
        return ((super.ImprimirPadre())+"CASA= Tamaño lote:"+this.getTamañoLote());
    }
}
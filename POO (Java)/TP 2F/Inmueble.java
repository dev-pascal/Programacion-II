public abstract class Inmueble {
    /*Atributos*/
    private String codigo_inmueble;
    private String direccion;
    private double cant_m2;
    private String tipoVenta;
    private Propietario propietario;
    /*Constructores*/
    public Inmueble (String codigo_inmueble, String direccion, double cant_m2, String tipoVenta, Propietario propietario) {
        this.codigo_inmueble=codigo_inmueble;
        this.direccion=direccion;
        this.cant_m2=cant_m2;
        this.propietario=propietario;
    }
    public Inmueble () {
    }
        /*Métodos set*/
        public void setCodigo (String codigo_inmueble) {
            this.codigo_inmueble=codigo_inmueble;
        }
        public void setDireccion (String direccion) {
            this.direccion=direccion;
        }
        public void setM2 (double cant_m2) {
            this.cant_m2=cant_m2;
        }
        public void setTipoVenta (String tipoVenta) {
            this.tipoVenta=tipoVenta;
        }
        public void setPropietario (Propietario propietario) {
            this.propietario=propietario;
        }
        /*Métodos get*/
        public String getCodigo () {
            return this.codigo_inmueble;
        }
        public String getDireccion () {
            return this.direccion;
        }
        public double getM2 () {
            return this.cant_m2;
        }
        public String getTipoVenta () {
            return this.tipoVenta;
        }
        public Propietario getPropietario () {
            return this.propietario;
        }
    public String ImprimirPadre () {
        return ("DATOS DE INMUEBLE: Codigo inmueble: "+this.getCodigo()+"// Dirección:"+this.getDireccion()+"//Cantidad de metros cuadrados:"+this.getM2()+"//Tipo de venta:"+this.getTipoVenta()+this.propietario.toString());
    }
    /*Método polimorfico*/
    public abstract double CalcularValor ();
}
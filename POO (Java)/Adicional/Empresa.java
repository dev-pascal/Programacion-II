public class Empresa extends Usuario {
    /*Atributos*/
    private int [] ConjuntoNros;
    private double precio;
    private int cant_lineasfijas;
    /*Constructores*/
    public Empresa (int codigo, String nombre, String email, double precio, int cant_lineasfijas, int [] ConjuntoNros) {
        super(codigo,nombre,email);
        this.precio=precio;
        this.cant_lineasfijas=cant_lineasfijas;
        this.ConjuntoNros=ConjuntoNros;
    }
    public Empresa () {
    }
        /*Métodos get*/
        public int [] getConjunto () {
            return this.ConjuntoNros;
        }
        public double getPrecio () {
            return this.precio;
        }
        public int getLineas () {
            return this.cant_lineasfijas;
        }
        /*Métodos set*/
        public void setConjunto (int [] ConjuntoNros) {
            this.ConjuntoNros=ConjuntoNros;
        }
        public void setPrecio (double precio) {
            this.precio=precio;
        }
        public void setLineas (int cant_lineasfijas) {
            this.cant_lineasfijas=cant_lineasfijas;
        }
    /*Método polimorfico*/
    public double CalcularFacturacion () {
        double facturacion=((this.getPrecio())+this.getLineas())*250;
        return facturacion;
        }
}
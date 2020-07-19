public class Particular extends Usuario {
    /*Atributos*/
    private int numero_telefono;
    private String fecha_alta;
    private String nombre_plan;
    private double cargo_fijo;
    private boolean tieneMinutoslibre;
    private boolean tieneInternetlibre;
    /*Constructores*/
    public Particular (int codigo, String nombre, String email, int numero_telefono, String fecha_alta, String nombre_plan, double cargo_fijo, boolean tieneMinutoslibre, boolean tieneInternetlibre) {
        super(codigo,nombre,email);
        this.numero_telefono=numero_telefono;
        this.fecha_alta=fecha_alta;
        this.nombre_plan=nombre_plan;
        this.cargo_fijo=cargo_fijo;
        this.tieneMinutoslibre=tieneMinutoslibre;
        this.tieneInternetlibre=tieneInternetlibre;
    }
    public Particular () {
    }
        /*métodos get*/
    public int getTelefono () {
        return this.numero_telefono;
    }
    public String getFecha () {
        return this.fecha_alta;
    }
    public String getPlan () {
        return this.nombre_plan;
    }
    public double getCargo () {
        return this.cargo_fijo;
    }
    public boolean getMinutos () {
        return this.tieneMinutoslibre;
    }
    public boolean getInternet () {
        return this.tieneInternetlibre;
    }
        /*métodos set*/
    public void setTelefono (int numero_telefono) {
        this.numero_telefono=numero_telefono;
    }
    public void setFecha (String fecha_alta) {
        this.fecha_alta=fecha_alta;
    }
    public void setPlan (String nombre_plan) {
        this.nombre_plan=nombre_plan;
    }
    public void setCargo (double cargo_fijo) {
        this.cargo_fijo=cargo_fijo;
    }
    public void setMinutos (boolean tieneMinutoslibre) {
        this.tieneMinutoslibre=tieneMinutoslibre;
    }
    public void setInternet (boolean tieneInternetlibre) {
        this.tieneInternetlibre=tieneInternetlibre;
    }
    /*Método polimorfico*/
    public double CalcularFacturacion () {
        double facturacion=this.cargo_fijo;
        if (getMinutos()==true)
            facturacion=facturacion+150;
        if (getInternet()==true)
            facturacion=facturacion+150;
        return facturacion;
    }
}
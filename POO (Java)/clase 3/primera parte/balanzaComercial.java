public class balanzaComercial {
    private double monto;
    private int cant_items;
    public balanzaComercial (double monto, int cant) {
        this.monto=monto;
        this.cant_items=cant;
    }
    public balanzaComercial () {
    }
    public void iniciarCompra () {
        monto=0;
        cant_items=0;
    }
    public void registrarProducto (double pesoEnKg, double precioPorKg) {
        monto=monto+(pesoEnKg*precioPorKg);
        cant_items++;
    }
    public double devolverMontoAPagar () {
        return monto;
    }
    public String devolverResumenDeCompra () {
        return ("Total a pagar "+monto+" por la compra de "+cant_items);
    }
}
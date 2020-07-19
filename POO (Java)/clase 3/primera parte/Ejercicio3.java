import java.util.Scanner;
public class Ejercicio3 {
    public void main (String args []) {
        Scanner in= new Scanner (System.in);
        balanzaComercial balanza= new balanzaComercial();
        balanza.iniciarCompra();
        double peso_kg, precio_kg;
        System.out.println("Ingrese peso en kg del producto");
        peso_kg=in.nextDouble();
        System.out.println("Ingrese precio por kg del producto");
        precio_kg=in.nextDouble();
        while (peso_kg!=0) {
            balanza.registrarProducto(peso_kg, precio_kg);
            System.out.println("Ingrese peso en kg del producto");
            peso_kg=in.nextDouble();
            System.out.println("Ingrese precio por kg del producto");
            precio_kg=in.nextDouble();
        } 
        balanza.devolverResumenDeCompra();
        in.close();
    }
}
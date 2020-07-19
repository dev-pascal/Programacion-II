import java.util.Scanner;
public class Ejercicio2 {
    public void main (String args []) {
        Scanner in = new Scanner (System.in);
        String unNombre=in.next();
        double unSueldo=in.nextDouble();
        int unaCantidad=in.nextInt();
        Entrenador entrenador= new Entrenador (unNombre, unSueldo, unaCantidad);        
        in.close();
    }
}
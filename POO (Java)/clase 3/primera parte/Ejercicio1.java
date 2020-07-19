import java.util.Scanner;
public class Ejercicio1 {
    public void main (String [] args) {
        Scanner in= new Scanner (System.in);
        double a,b,c,area;
        System.out.println("Ingrese lado a del triangulo");
        a=in.nextDouble();
        System.out.println("Ingrese lado b del triangulo");
        b=in.nextDouble();
        System.out.println("Ingrese lado c del triangulo");
        c=in.nextDouble();
        Triangulo triangulo= new Triangulo();
        in.close();
        triangulo.setLados(a,b,c);
        System.out.println("Perimetro="+(a+b+c));
        System.out.println("Area="+(triangulo.calcularArea(a,b,c)));       
    }
}

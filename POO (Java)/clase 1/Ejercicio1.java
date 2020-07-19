import java.util.Scanner;
public class Ejercicio1
{
    public static void main(String[] args)
    {
        System.out.println("Ingrese longitud a del triángulo");
        Scanner in = new Scanner(System.in);
        double a= in.nextDouble();
        System.out.println("Ingrese longitud b del triángulo");
        double b= in.nextDouble();
        System.out.println("Ingrese longitud c del triángulo");
        double c= in.nextDouble();
        in.close();
        if ((a<(b+c)) & (b<(a+c)) & (c<(a+b))) 
            System.out.println("El triángulo es válido");
        else
            System.out.println("El triángulo no es válido");
    }
}
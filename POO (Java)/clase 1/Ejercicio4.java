import java.util.Scanner;
public class Ejercicio4 {    
    public static void main (String [] args) {
        Ejercicio3 factorial= new Ejercicio3();
        int num=1;
        String [] elem;
        elem=new String[1];
        while (num<10) {
            factorial.Factorial(num);
            num++;
        }
        System.out.println("En caso de querer solamente los factoriales de los numeros impares:");
        num=1;
        while ((num<10) && ((num%2)!=0)) {
            factorial.Factorial(num);
            num=num+2;
        }
    } 
}
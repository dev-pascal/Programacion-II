import java.util.Scanner;
public class Ejercicio1 {
    public void main (String args []) {
        Scanner in= new Scanner (System.in);
        String nombre=in.next();
        int DNI=in.nextInt();
        int edad=in.nextInt();
        Persona persona= new Persona (nombre,DNI,edad);
        persona.toString();
    }
}

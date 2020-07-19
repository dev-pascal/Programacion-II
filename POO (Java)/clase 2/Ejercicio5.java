import java.util.Scanner;
public class Ejercicio5 {
    public void main (String args []) {
        int i;
        String [] vector= new String [10];
        Scanner in = new Scanner (System.in);
        for (i=0; i<10; i++) {
            System.out.println("Ingrese palabra");
            vector[i]=in.next();
        }
        in.close();
        for (i=0; i<10; i++) {
            System.out.print(vector[i].charAt(0));
        }
    }
}

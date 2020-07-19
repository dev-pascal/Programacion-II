import java.util.Scanner;
public class Ejercicio3 {
    public static int Factorial (int N) {        
        int Factorial=1;        
        int num=N;
        while (N!=0) {
            Factorial=Factorial*N;
            N--;
        }
        System.out.println(num+"!="+Factorial);
        N=Factorial;
        return N;
    }
    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        int N= in.nextInt();
        Factorial(N);
    }
}
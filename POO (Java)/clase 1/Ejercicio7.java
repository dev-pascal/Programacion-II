import java.util.Scanner;
public class Ejercicio7 {
    public void main (String [] args) {
        int [] Banco = new int [4];
        Scanner in = new Scanner(System.in);
        System.out.println("Indique qué operación desea realizar");
        int operacion= in.nextInt();
        Banco[operacion]++;
        while (operacion!=999) {
            System.out.println("Indique qué operación desea realizar");
            operacion=in.nextInt();
            Banco[operacion]++;
        }
        in.close();
        int i;
        int max=-1;
        int maxinfo=-1;
        System.out.println("Cantidad de personas atendidas en cada operación");
        for (i=0;i<4;i++) {
            System.out.println("Operación 1:"+Banco[i]);
            if (Banco[i]>max) {
                max=Banco[i];
                maxinfo=i;
            }
        }
        System.out.println("Operación más solicitada: "+maxinfo);
    }
}

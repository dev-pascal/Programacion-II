import java.util.Scanner;
public class Ejercicio6 {
    public static void main (String args []) {
        int [][] matriz;
        matriz = new int[9][9];
        int i,j;
        int pares=0;
        //Inicializo matriz
        for (i=0;i<9;i++)
            for (j=0;j<9;j++) {
                matriz[i][j]=pares;
                pares=pares+2;
            }
            
        System.out.println("Contenido de la matriz");
        for (i=0;i<9;i++)
            for (j=0;j<9;j++)
                System.out.println("Pos("+i+","+j+")="+matriz[i][j]);
                
        System.out.println("Contenido de la fila 2");
        for (j=0;j<9;j++)
            System.out.println(matriz[2][j]);
            
        System.out.println("Contenido de la columna 0");
        for (i=0;i<9;i++)
            System.out.println(matriz[i][0]);
            
        System.out.println("Contenido de la columna 3");
        for (i=0;i<9;i++)
            System.out.println(matriz[i][3]);
        
        int [] vector = new int [9];    
        int suma;
        for (j=0;j<9;) {
            suma=0;
            for (i=0;i<9;i++)
                suma=suma+matriz[i][j];
            i=j;
            vector[i]=suma;
            j++;
        }
        
        Scanner in = new Scanner (System.in);
        int entero= in.nextInt();
        boolean exito=false;
        j=0;
        while ((!exito) && (i<9)) {
            if (matriz[i][j]==entero)
                exito=true;
            while ((!exito) && (j<9)) {
                if (matriz[i][j]==entero)
                    exito=true;
                j++;
            }
            i++;
        }
        if (exito==false)
            System.out.println("No se encontró el elemento");
        in.close();
    }
}
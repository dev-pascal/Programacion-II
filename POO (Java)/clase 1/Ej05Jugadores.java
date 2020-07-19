import java.util.Scanner;
public class Ej05Jugadores
{
    public static void main(String[] args)
    {
        //Paso 1: Declarar la variable vector de alturas
        double [] alturas;
        //Paso 2: Declarar indice y promedio (iniciarlo)
        int i=0;
        double promedio=0;
        //Paso 3: Declarar y crear el scanner
        Scanner in = new Scanner(System.in);
        //Paso 4: Crear el vector para 15 valores
        alturas = new double[15];
        //Paso 5: Ingresar 15 numeros, cargarlos en el vector, ir calculando la suma
        double suma=0;
        for (i=0;i<15;) {
            alturas[i]=in.nextDouble();
            suma=suma+alturas[i];
            i++;
        }
        //Paso 6: Calcular el promedio
        promedio=suma/15;
        //Paso 7: Recorrer el vector, contar los números que son mayores que el promedio
        int cant=0;
        for (i=0;i<15;) {
            if (alturas[i]>promedio)
                cant++;
            i++;
        }
        System.out.println("Altura promedio:"+promedio);
        System.out.println("Cantidad de jugadores con altura por encima del promedio:"+cant);        
    }
}

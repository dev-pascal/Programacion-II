import java.util.Scanner;
public class Ejercicio2 {
    public void main (String args []) {
        Scanner in=new Scanner(System.in);
        Persona vector []= new Persona [15];
        int i;
        for (i=0;i<15;i++) {
            System.out.println("Ingrese DNI");
            int DNI=in.nextInt();
            System.out.println("Ingrese edad");
            int edad=in.nextInt();
            String nombre=in.next();
            Persona persona =new Persona(nombre,DNI,edad);
            vector[i]=persona;
        }    
        in.close();
        System.out.println("Cantidad de personas mayores de 65 años: "+setCantidad(vector));
        System.out.println("Representación de la persona con menor DNI:");
        System.out.println(setMinimo(vector));
    }
    public int setCantidad (Persona vector[]) {
        int i;
        int cant=0;
        for (i=0;i<15;i++) {
            if (vector[i].getEdad()>65)
                cant++;
        }
        return cant;
    }
   
    public String setMinimo (Persona vector[]) {
        int i;
        int min=9999;
        String min_info="";
        for (i=0;i<15;i++) {
            if (min>vector[i].getDNI()) {
                min=vector[i].getDNI();
                min_info=toString();
            }
        }
        return min_info;
    }
    

}    
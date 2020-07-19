import java.util.Scanner;
public class ProgramaEditorial {
    public static Ejemplar Cargar () {   
        Scanner in= new Scanner(System.in);
        
        Ejemplar ejemplar=null;
        System.out.println("Ejemplar (Clase Padre)");
        System.out.println("Ingrese codigo identificatorio");
        String codigo=in.next(); 
        if (!(codigo.equals("0"))) {
            System.out.println("Ingrese cantidad de paginas");
            int cant_paginas=in.nextInt();
            System.out.println("Ingrese resumen");
            String resumen=in.next();
            System.out.println("Ingrese año");
            int año=in.nextInt();

            System.out.println("Responsable");
            System.out.println("Ingrese DNI");
            int DNI=in.nextInt();
            System.out.println("Ingrese nombre");
            String nombre_res=in.next();
            System.out.println("Ingrese apellido");
            String apellido=in.next();
            Responsable responsable= new Responsable (DNI, nombre_res,apellido);
        
            System.out.println("Escriba 1 si es libro, o 2 si es revista");
            int det=in.nextInt();
        
            if (det==1) {
                System.out.println("Libro (Clase hija)");
                System.out.println("Ingrese titulo");
                String titulo=in.next();
                System.out.println("Ingrese cantidad de capitulos");
                int capitulos=in.nextInt();
                System.out.println("Ingrese si el mismo es edición de Bolsillo, si lo es ingresar 'true' sino 'false' (sin las comillas)");
                boolean esBolsillo=in.nextBoolean();
                ejemplar=new Libro(titulo,capitulos,esBolsillo,codigo,cant_paginas,resumen,año,responsable);
            }
            else
                if (det==2) {
                    System.out.println("Revista (Clase hija)");
                    System.out.println("Ingrese nombre");
                    String nombre=in.next();
                    System.out.println("Ingrese cantidad de articulos");
                    int cant_art=in.nextInt();
                    System.out.println("Ingrese un número de volumen");
                    int nro_vol=in.nextInt();
                    ejemplar=new Revista(nombre,cant_art,nro_vol,codigo,cant_paginas,resumen,año,responsable);
                }
        }
        in.close();
        return ejemplar;
    }
    public static void main (String args []) {
        Ejemplar [] ejemplar= new Ejemplar [1000];
        int i=0;
        /*El corte del loop será cuando el usuario ingrese un codigo identificatorio 0
          del Ejemplar o cuando se llegue a los 1000 ejemplares.*/
        boolean exito=false;
        while ((i<1000) && (!exito)) {
            ejemplar[i]=Cargar();
            if (ejemplar[i]==null)
                exito=true;
            else
                i++;
        }
        int j;
        /*Imprimo el listado*/
        for (j=0;j<i;j++) {
            if (ejemplar[j]!=null)
                ejemplar[j].Imprimir();
        }
        /*Publico los ejemplares*/
        for (j=0;j<i;j++) {
            if (ejemplar[j]!=null)
                ejemplar[j].Publicar();
        }
    }
}
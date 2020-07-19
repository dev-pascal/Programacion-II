import java.util.Scanner;
public class Programa {
    public static Usuario Cargar () {
        Usuario usuario=null;
        Scanner in= new Scanner (System.in);
        System.out.println("Ingrese código de usuario");
        int codigo=in.nextInt();
        if (codigo!=0) {
            System.out.println("Ingrese nombre");
            String nombre=in.next();
            System.out.println("Ingrese email");
            String email=in.next();
            System.out.println("Ingrese 1 si es particular, o 2 si es una empresa");
            int det=in.nextInt();
            if (det==1) {
                System.out.println("Ingrese numero de telefono");
                int numero_telefono=in.nextInt();
                System.out.println("Ingrese fecha de alta");
                String fecha_alta=in.next();
                System.out.println("Ingrese nombre del plan");
                String nombre_plan=in.next();
                System.out.println("Ingrese cargo fijo");
                double cargo_fijo=in.nextDouble();
                System.out.println("Ingrese si tiene el servicio minutos libres, si es así, escriba true o de lo contrario, false");
                boolean tieneMinutoslibre=in.nextBoolean();
                System.out.println("Ingrese si tiene el servicio internet libre, si es así, escriba true o de lo contrario, false");
                boolean tieneInternetlibre=in.nextBoolean();
                usuario= new Particular (codigo,nombre,email,numero_telefono,fecha_alta,nombre_plan,cargo_fijo,tieneMinutoslibre,tieneInternetlibre); 
            }
            else
                if (det==2) {
                     System.out.println("Ingrese precio");
                     double precio=in.nextDouble();
                     System.out.println("Ingrese cantidad de lineas fijas");
                     int cant_lineas=in.nextInt();
                     System.out.println("Conjunto de números de la flota de líneas telefónicas móviles, puede escribir a lo sumo 50 numeros, o hasta ingresar el telefono numero -1");
                     int numero=0;
                     int cant=0;
                     int [] conjunto= new int [50];
                     while ((numero!=-1) && (cant<50)) {
                         System.out.println("Ingrese numero");
                         numero=in.nextInt();
                         if (numero!=-1) {
                            conjunto[cant]=numero;
                            cant++;
                         } 
                     }
                     usuario= new Empresa(codigo,nombre,email,precio,cant_lineas,conjunto);
                }
        }
        in.close();
        return usuario;
    }
    public static void main (String args []) {
        int cant=0;
        boolean exito=false;
        Usuario [] usuario= new Usuario [100];
        while ((cant<100) && (!exito)) {
            usuario[cant]=Cargar();
            if (usuario[cant]==null)
                exito=true;
        }
        int i;
        for (i=0;i<cant;i++) {
            System.out.println(usuario[i].CalcularFacturacion());
        }
        
    }
}
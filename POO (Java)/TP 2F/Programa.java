import java.util.Scanner;
public class Programa {
    public static Inmueble Cargar () {
        Inmueble inmueble=null;
        Scanner in= new Scanner (System.in);
        System.out.println("--Datos de Inmueble--");
        System.out.println("Ingrese código de inmueble (alfanumérico)");
        String codigo=in.next();
        if (!(codigo.equals("0"))) {
            System.out.println("Ingrese dirección");
            String direccion=in.next();
            System.out.println("Ingrese cantidad de metros cuadrados del inmueble");
            double cant_m2=in.nextDouble();
            System.out.println("Escriba el tipo de venta del inmueble, escriba 'Venta' (sin comillas) si el mismo está en venta, o 'Alquiler' si el mismo está en alquiler.");
            String tipoVenta=in.next();
            System.out.println("--Datos de Propietario--");
            System.out.println("Ingrese DNI");
            int DNI= in.nextInt();
            System.out.println("Ingrese nombre");
            String nombre= in.next();
            System.out.println("Ingrese apellido");
            String apellido= in.next();
            System.out.println("Ingrese email");
            String email= in.next();
            Propietario propietario= new Propietario (DNI,nombre,apellido,email);
            System.out.println("Escriba 'Casa' (sin comillas) si el inmueble es una casa, o 'Departamento' (sin comillas) si el inmueble es un departamento.");
            String tipoInmueble=in.next();
            if ((tipoInmueble.equals("Casa")) || (tipoInmueble.toUpperCase().equals("CASA")) || (tipoInmueble.toLowerCase().equals("casa"))) {
                System.out.println("--Datos de Casa--");
                System.out.println("Ingrese tamaño del lote (en metros cuadrados)");
                double tamaño_lote=in.nextDouble();             
                inmueble= new Casa (codigo,direccion,cant_m2,tipoVenta,propietario,tamaño_lote);
            }
            else
                if ((tipoInmueble.equals("Departamento")) || (tipoInmueble.toUpperCase().equals("DEPARTAMENTO")) || (tipoInmueble.toLowerCase().equals("departamento"))) {
                    System.out.println("--Datos de Dpto--");
                    System.out.println("Ingrese el valor de las expensas");
                    double expensas=in.nextDouble();
                    System.out.println("Ingrese si existe un encargado o no del consorcio en boolean. Es decir, si existe, ingrese 'true' (sin comillas), de lo contrario ingrese 'false' (sin comillas)'");
                    boolean encargado=in.nextBoolean();
                    inmueble= new Departamento (codigo,direccion,cant_m2,tipoVenta,propietario,expensas,encargado);
                }    
        }
        in.close();
        return inmueble;
    }
    public static void main (String args []) {
        int cant=0;
        boolean exito=false;
        Inmueble [] inmueble= new Inmueble [100];
        System.out.println("Cargue a lo sumo 100 inmuebles, si en un momento desea dejar de leer inmuebles antes de los 100 inmuebles, ingrese el código de inmueble 0.");
        while ((cant<100) && (!exito)) {
            inmueble[cant]=Cargar();
            if (inmueble[cant]==null)
                exito=true;
            else
                cant++;
        }
        int i;
        System.out.println("Inmobiliaria UNLP: ");
        for (i=0;i<cant;i++)
            if (inmueble[i]!=null)
                System.out.println((inmueble[i].toString())+"Valor: $"+(inmueble[i].CalcularValor()));
    }
}
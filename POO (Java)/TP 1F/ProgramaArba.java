import java.util.Scanner;
public class ProgramaArba {
    public static Vehículo Cargar () {
        Vehículo auto=null;
        Scanner in= new Scanner (System.in);
        /*---VEHÍCULO (Clase Padre)---*/
        System.out.println("Ingrese año");
        int año=in.nextInt();
        if (año!=0) {
            System.out.println("Ingrese importe");
            double importe=in.nextDouble();
            /*---PROPIETARIO---*/
            System.out.println("Ingrese CIT");
            int CIT=in.nextInt();   
            System.out.println("Ingrese nombre");
            String nombre=in.next();
            System.out.println("Ingrese apellido");
            String apellido=in.next();
            Propietario propietario= new Propietario (CIT,nombre,apellido);
            
            System.out.println("Escriba 1 si es Automotor, o 2 si es Embarcación"); 
            int det=in.nextInt();
            if (det==1) {
                /*---AUTOMOTOR (Clase hija)---*/
                System.out.println("Ingrese patente");
                String patente=in.next();
                System.out.println("Ingrese importe adicional");
                double importeAdicional=in.nextDouble();
                System.out.println("Ingrese descripción");
                String descripcion=in.next();
                auto= new Automotor(patente,importeAdicional,descripcion,año,importe,propietario);
                }
            else
                if (det==2) {
                    /*---EMBARCACIÓN (Clase hija)---*/
                    System.out.println("Ingrese código REY");
                    int REY=in.nextInt();
                    System.out.println("Ingrese tipo de embarcación, 1 si es lancha, 2 si es crucero o 3 si es velero");
                    int tipo=in.nextInt();
                    String tipoEmbarcación="";
                    if (tipo==1)
                        tipoEmbarcación="Lancha";
                    else
                        if (tipo==2)
                            tipoEmbarcación="Crucero";
                        else
                            if (tipo==3)
                                tipoEmbarcación="Velero";
                    System.out.println("Ingrese eslora");
                    double eslora=in.nextDouble();
                    System.out.println("Ingrese tonelaje");
                    double tonelaje=in.nextDouble();
                    System.out.println("Ingrese valor declarado de la embarcación");
                    double valor=in.nextDouble();
                    auto= new Embarcación (REY,tipoEmbarcación,eslora,tonelaje,valor,año,importe,propietario);
                }
        }
        in.close();
        return auto;
    }
    public static void main (String args []) {
        Vehículo [] vehículo= new Vehículo [1000];
        int cant=0;
        boolean exito=false;
        Scanner in= new Scanner(System.in);
        while ((cant<1000) && (!exito)) {
            vehículo[cant]=Cargar();
            if (vehículo[cant]==null)
                exito=true;
        }
        
        /*Hago la impresión del listado de todos los vehículos existentes*/
        int i;
        if (vehículo[0]!=null)
            for (i=0;i<cant;i++)
                System.out.println(vehículo[i].toString());
        
        /*Calculo el monto a pagar en diciembre*/
        double monto_diciembre=0;
        if (vehículo[0]!=null)
            for (i=0;i<cant;i++)
                if (vehículo[i].getAño()==2019)
                    monto_diciembre=monto_diciembre+vehículo[i].CalcularImpuesto();
                
        System.out.println("El costo del impuesto a pagar en diciembre del 2019 es: $"+monto_diciembre);
        }
    }

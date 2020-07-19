import java.util.Scanner;
public class Ejercicio3 {
    public void Cargar (Micro micro) {
        Scanner in = new Scanner (System.in);
        System.out.println("Ingrese número de asiento");
        int nro_asiento=in.nextInt();
        while ((nro_asiento!=-1) || (micro.getAsientos()!=20)) {
            if (micro.validarAsiento(nro_asiento)==true)
                if (micro.getEstado(nro_asiento)==false) {
                    micro.ocuparAsiento(nro_asiento);
                    System.out.println("Se ha ocupado con éxito el asiento");
                }
                else {
                    System.out.println("El asiento que usted ingresó está ocupado");
                    System.out.println("El asiento más próximo que está desocupado es:"+micro.devuelvoPrimero(micro.getRegistro()));
                }
            micro.setAsientos(micro.getAsientos());
            System.out.println("Ingrese número de asiento");
            nro_asiento=in.nextInt();    
        }
        in.close();
    }
    public void main (String args []) {
        Micro micro=new Micro("ABC123", "Mar del Plata", "5:00 a.m");
        Cargar(micro);
        System.out.println("Cantidad de asientos ocupados del micro: "+micro.getAsientos());
    }
}
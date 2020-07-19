import java.util.Scanner;
public class Ejercicio4 {
    public void main (String args []) {
        Scanner in= new Scanner (System.in);
        Flota flota=new Flota();
        System.out.println("Ingrese patente");
        String patente=in.next();
        int cant_micros=0;
        String destino,horaSalida;
        while ((patente!="ZZZ000") ||(cant_micros!=15)) {
            System.out.println("Ingrese destino");
            destino=in.nextLine();
            System.out.println("Ingrese horario de salida");
            horaSalida=in.nextLine();
            Micro micro=new Micro(patente,destino,horaSalida);
            flota.agregarMicro(micro);
            cant_micros++;
            System.out.println("Ingrese patente");
            patente=in.next();
        }
        System.out.println("Ingrese patente");
        patente=in.next();
        Micro microAux=flota.buscarPorPatente(patente);
        if (patente==microAux.getPatente())
            flota.eliminarMicro(microAux);
        System.out.println("Ingrese destino");
        destino=in.nextLine();
        microAux=flota.buscarPorDestino(destino);
        if (destino==microAux.getDestino()) {
            System.out.println(microAux.getPatente());
            System.out.println(microAux.getHora());
        }
        in.close();
    }
}
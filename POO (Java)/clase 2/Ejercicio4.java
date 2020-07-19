import java.util.Scanner;
public class Ejercicio4 {
   public void main (String args []) {
        Scanner in = new Scanner (System.in);        
        Partido [] partidos=new Partido[325];
        int i;
        for (i=0;i<325;i++) {
            System.out.println("Ingrese cantidad de goles local");
            int golesLocal=in.nextInt();
            System.out.println("Ingrese cantidad de goles visitante");
            int golesVisitante=in.nextInt();
            System.out.println("Ingrese nombre de visitante");
            String visitante=in.next();
            System.out.println("Ingrese nombre del local");
            String local=in.next();
            Partido partido=new Partido(local,visitante,golesLocal,golesVisitante);
            partidos[i]=partido;
            
        }
        int cant_River=0;
        int cant_Boca=0;
        int cant_Empate=0;
        Partido p;
        for (i=0;i<325;i++) {
            p=partidos[i];
            cant_River=p.cantRiver(p,cant_River);
            cant_Boca=p.cantBoca(p,cant_Boca);
            cant_Empate=p.cantEmpate(p,cant_Empate);
        }
        System.out.println("Cantidad de partidos ganados por River:"+cant_River);
        System.out.println("Cantidad de goles que realizó Boca jugando de local:"+cant_Boca);
        double porcentaje=(cant_Empate*100)/325;
        System.out.println("Porcentaje de partidos finalizados con empate:"+porcentaje);
    }
}
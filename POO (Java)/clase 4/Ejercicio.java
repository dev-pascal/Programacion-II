import java.util.Scanner;
public class Ejercicio {
    public void main (String args []) {
        Scanner in= new Scanner (System.in);
        System.out.println("Ingrese sueldo básico");
        double sueldo=in.nextDouble();
        System.out.println("----JUGADOR----");
        Empleado jugador=new Jugador();
        System.out.println("Ingrese nombre");
        String nombre=in.next();
        System.out.println("Ingrese cantidad de partidos");
        int cant_partidos=in.nextInt();
        System.out.println("Ingrese cantidad de goles");
        int cant_goles=in.nextInt();
        jugador=new Jugador(cant_partidos,cant_goles);
        double sueldo_jugador=jugador.calcularSueldoACobrar(sueldo);
        jugador=new Jugador(nombre,sueldo_jugador,cant_partidos,cant_goles);

        
        System.out.println("----ENTRENADOR----");
        Empleado entrenador= new Entrenador();
        System.out.println("Ingrese nombre");
        nombre=in.next();
        System.out.println("Ingrese cantidad de campeonatos ganados");
        int cant_campeonatos=in.nextInt();
        entrenador= new Entrenador (cant_campeonatos);
        double sueldo_entrenador=entrenador.calcularSueldoACobrar(sueldo);
        entrenador= new Entrenador(nombre,sueldo_entrenador,cant_campeonatos);
        
        System.out.println("----");
        System.out.println("Jugador:");
        System.out.println(jugador.toString());
        System.out.println("----");
        System.out.println("Entrenador:");
        System.out.println(entrenador.toString());
    }
}
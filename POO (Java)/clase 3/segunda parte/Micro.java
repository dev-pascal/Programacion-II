import java.util.Scanner;
public class Micro {
    private String patente;
    private String destino;
    private String horaSalida;
    private boolean [] registroAsientos;
    private int cantOcupado;
    public Micro (String unaPatente, String unDestino, String unaHora) {
        patente=unaPatente;
        destino=unDestino;
        horaSalida=unaHora;
        cantOcupado=0;
        registroAsientos=new boolean [20];
    }
    public Micro () {
    }
    public boolean [] getRegistro () {
        return registroAsientos;
    }
    public String getPatente () {
        return patente;
    }
    public String getDestino () {
        return destino;
    }
    public String getHora () {
        return horaSalida;
    }
    public int getAsientos () {
        return cantOcupado;
    } 
    public boolean estaLleno () {
        int i=0;
        boolean resultado=true;
        for (i=0; i<20; i++) {
            if (registroAsientos[i]!=true)
                resultado=false;
        }
        return resultado;
    }
    public void setPatente (String unaPatente) {
        patente=unaPatente;
    }
    public void setDestino (String unDestino) {
        destino=unDestino;
    }
    public void setHora (String unaHora) {
        horaSalida=unaHora;
    }
    public void setAsientos (int unAsiento) {
        cantOcupado=cantOcupado+unAsiento;
    }
    public boolean validarAsiento (int nro_asiento) {
        boolean resultado=false;
        if ((nro_asiento>=1) && (nro_asiento<=20))
            resultado=true;
        return resultado;
    }
    public boolean getEstado (int nro_asiento) {
        return (registroAsientos[nro_asiento]);
    }
    public void ocuparAsiento (int nro_asiento) {
        registroAsientos[nro_asiento]=true;
    }
    public void liberarAsiento (int nro_asiento) {
        registroAsientos[nro_asiento]=false;
    }
    public int devuelvoPrimero (boolean [] vector) {
        int nro=0;
        boolean exito=false;
        while ((nro!=20) && (!exito)) {
            if (registroAsientos[nro]==false)
                exito=true;
            else
                nro++;
        }
        if (exito=false)
            nro=0;
        return nro;
    }
}
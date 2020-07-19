public class Flota {
    private Micro [] Flotas;
    public Flota () { //constructor que crea una flota vacía
        int i;
        for (i=0;i<15;i++) {
            Flotas[i]=null;
        }
    }
    //implementación de métodos
    public boolean estaCompleta () {
        int i;
        int cant=0;
        boolean exito=false;
        for (i=0;i<15;i++) {
            if (Flotas[i]!=null)
                cant++;
        }
        if (cant==15)
            exito=true;
        return exito;
    }
    public void agregarMicro (Micro micro) {
        int i=0;
        while (Flotas[i]!=null) {
            i++;
        }
        Flotas[i]=micro;
    }
    public void eliminarMicro (Micro micro) {
        int i=0;
        while (Flotas[i]!=micro) {
            i++;
        }
        Flotas[i]=null;
    }
    public Micro buscarPorPatente (String patente) {
        int i=0;
        boolean exito=false;
        Micro microResultado,microBusqueda;
        microBusqueda=Flotas[i];
        while (((microBusqueda.getPatente())!=patente) && (!exito) && (i!=15))  {
            microBusqueda=Flotas[i];
            if ((microBusqueda.getPatente())==patente)
                exito=true;
            else    
                i++;
        }
        if (exito==true)
            microResultado=Flotas[i];
        else
            microResultado=null;
        return microResultado;
    }
    public Micro buscarPorDestino (String destino) {
        int i=0;
        boolean exito=false;
        Micro microResultado,microBusqueda;
        microBusqueda=Flotas[i];
        while (((microBusqueda.getDestino())!=destino) && (!exito) && (i!=15))  {
            microBusqueda=Flotas[i];
            if ((microBusqueda.getDestino())==destino)
                exito=true;
            else    
                i++;
        }
        if (exito==true)
            microResultado=Flotas[i];
        else
            microResultado=null;
        return microResultado;
    }
    
    
}
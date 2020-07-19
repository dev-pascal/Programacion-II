public class Revista extends Ejemplar {
    /*Atributos*/
    private String nombre;
    private int cant_art;
    private int nro_vol;
    
    /*Constructores*/
    public Revista (String nombre, int cant_art, int nro_vol, String codigo, int paginas, String resumen, int año, Responsable responsable) {
        super(codigo,paginas,resumen,año,responsable);
        this.nombre=nombre;
        this.cant_art=cant_art;
        this.nro_vol=nro_vol;
    }
    public Revista () {
    }
    public String getNombre () {
        return this.nombre;
    }
    public int getArt () {
        return this.cant_art;
    }
    public int getNroVol() {
        return nro_vol;
    }
    public void setNombre (String nombre) {
        this.nombre=nombre;
    }
    public void setArt (int cant_art) {
        this.cant_art=cant_art;
    }
    public void setNroVol (int nro_vol) {
        this.nro_vol=nro_vol;
    }
    /*métodos polimórficos*/
    public String Imprimir () {
        return ("Nombre: "+this.nombre+"// Número de volumen: "+this.getNroVol());
    }
    public void Publicar () {
        super.setAño(2019);
        this.setNroVol(Generador.getNroVolumen());
    }
}
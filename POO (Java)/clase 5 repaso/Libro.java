public class Libro extends Ejemplar{
    /*Atributos*/
    private String titulo;
    private int capitulos;
    private boolean esBolsillo;
    
    /*Constructores*/
    public Libro () {
    }
    public Libro (String titulo,int capitulos,boolean esBolsillo, String codigo, int paginas, String resumen, int año, Responsable responsable) {
        super(codigo,paginas,resumen,año,responsable); 
        this.titulo=titulo;
        this.capitulos=capitulos;
        this.esBolsillo=esBolsillo;
    }
    public void setTitulo (String titulo) {
        this.titulo=titulo;
    }
    public void setCapitulos (int capitulos) {
        this.capitulos=capitulos;
    }
    public void setBolsillo (boolean esBolsillo) {
        this.esBolsillo=esBolsillo;
    }
    public String getTitulo () {
        return this.titulo;
    }
    public int getCapitulos () {
        return this.capitulos;
    }
    public boolean getBolsillo () {
        return this.esBolsillo;
    }
    /*métodos polimórficos*/
    public String Imprimir () {
        return ("Codigo identificatorio: "+super.getCodigo()+this.titulo+"// Nombre del responsable:"+super.getResponsable().getNombre());
    }
    public void Publicar () {
        if (this.getBolsillo()==true) {
            this.setTitulo("//Título: "+this.titulo+" - de Bolsillo");
        }
    }
}
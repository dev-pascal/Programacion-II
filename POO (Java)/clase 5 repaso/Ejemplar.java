public abstract class Ejemplar {
    /*Atributos*/
    private String codigo_identificatorio;
    private int cant_paginas;
    private String resumen;
    private int año;
    private Responsable responsable;
    
    /*Constructores*/
    public Ejemplar () {
    } 
    public Ejemplar (String codigo, int paginas, String resumen, int año) {
        this.codigo_identificatorio=codigo;
        this.cant_paginas=paginas;
        this.resumen=resumen;
        this.año=año;
    }
    public Ejemplar (String codigo, int paginas, String resumen, int año, Responsable responsable) {
        this(codigo,paginas,resumen,año);
        this.responsable=responsable;
    }
    public void setCodigo (String codigo) {
        this.codigo_identificatorio=codigo;
    }
    public void setPaginas (int paginas) {
        this.cant_paginas=paginas;
    }
    public void setResumen (String resumen) {
        this.resumen=resumen;
    }
    public void setAño (int año) {
        this.año=año;
    }
    public void setResponsable (Responsable responsable) {
        this.responsable=responsable;
    }
    public Responsable getResponsable () {
        return responsable;
    }
    public String getCodigo () {
        return this.codigo_identificatorio;
    }
    public int getPaginas () {
        return this.cant_paginas;
    }
    public String getResumen () {
        return this.resumen;
    }
    public int getAño () {
        return this.año;
    }
    public abstract String Imprimir ();
    public abstract void Publicar ();
}
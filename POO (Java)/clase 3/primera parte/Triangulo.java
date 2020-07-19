import java.util.Scanner;
public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String color_relleno;
    private String color_linea;
    public Triangulo (double l1, double l2, double l3, String relleno, String linea) {
        lado1=l1;
        lado2=l2;
        lado3=l3;
        color_relleno=relleno;
        color_linea=linea;
    }
    public Triangulo() {}
    public void setLados (double l1, double l2, double l3) {
        lado1=l1;
        lado2=l2;
        lado3=l3;
    }
    public void setColores (String relleno, String linea) {
        color_relleno=relleno;
        color_linea=linea;
    }
    public double getLado1 () {
        return lado1;
    }
    public double getLado2 () {
        return lado2;
    }
    public double getLado3 () {
        return lado3;
    }
    public String getRelleno () {
        return color_relleno;
    }
    public String getLinea () {
        return color_linea;
    }
    public double calcularArea (double a, double b, double c) {
        double s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}


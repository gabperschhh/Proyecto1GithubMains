/**
* Esta clase contiene todos los detalles de los ataques, se relaciona con elemento y pokemon 
*@author Benjamín Hernández, Julian Barrantes y Gabriel Pérez
*@Version 1.0
*/
public class Ataque{
    private String nombre;
    private Elemento elemento;
    private int potencia;
    private int PPMaximo;
    private int PPActual;
    private int precision;

    public Ataque(String nombre, Elemento elemento, int potencia, int PPMaximo, int PPActual,
    int precision) {
    this.nombre = nombre; 
    this.elemento = elemento;
    this.potencia = potencia;
    this.PPMaximo = PPMaximo;
    this.PPActual = PPActual;
    this.precision = precision;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public Elemento getElemento() {
        return elemento;
    }
    public int getPotencia() {
        return potencia;
    }
    public int getPPMaximo() {
        return PPMaximo;
    }
    public int getPPActual() {
        return PPActual;
    }
    public int getPrecision() {
        return precision;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public void setPPMaximo(int PPMaximo) {
        this.PPMaximo = PPMaximo;
    }
    public void setPPActual(int PPActual) {
        this.PPActual = PPActual;
    }
    public void setPrecision(int precision) {
        this.precision = precision;
    }
}
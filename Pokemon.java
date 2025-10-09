/**
*Esta clase tiene todos los detalles de un Pokemon y una lista de elementos y otra de ataques tiene relación con la clase Stat, Elemento, Ataque, Inicializar y Main
*@author Benjamin Hernández, Julian Barrantes y Gabriel perez
*@Version 1.0
*/
public class Pokemon{
    private String nombre;
    private int nivel;
    private Stat stats;
    private Elemento[] elementos = new Elemento[2];
    private Ataque[] ataques = new Ataque[4];
    private boolean debilitado; 

    public Pokemon(String nombre, int nivel, Stat stats, Elemento[] elementos, 
    Ataque[] ataques, boolean debilitado) {
    this.nombre = nombre;
    this.nivel = nivel;
    this.stats = stats;
    this.elementos = elementos;
    this.ataques = ataques;
    this.debilitado = debilitado;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public int getNivel() {
        return nivel;
    }
    public Stat getStats() {
        return stats;
    }
    public Elemento[] getElementos() {
        return elementos;
    }
    public Ataque[] getAtaques() {
        return ataques;
    }
    public boolean isDebilitado() { 
        return debilitado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setStats(Stat stats) {
        this.stats = stats;
    }

    public void setElementos(Elemento[] elementos) {
        this.elementos = elementos;
    }

    public void setAtaques(Ataque[] ataques) {
        this.ataques = ataques;
    }

    public void setDebilitado(boolean debilitado) {
        this.debilitado = debilitado;
    }
}
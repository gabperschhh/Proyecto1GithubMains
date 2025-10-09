/**
*Esta clase tiene los detalles de un entrenador y una lista de Pokemon, tiene relación con Pokemon, Inicializar y Main
*@author Benjamin Hernández, Julian Barrantes y Gabriel perez
*@Version 1.0
*/
public class Entrenador{
    String nombre;
    boolean esJugador;
    Pokemon[] pokemones = new Pokemon[3];

    public Entrenador(String nombre, boolean esJugador, Pokemon[] pokemones){
        this.nombre = nombre;
        this.esJugador = esJugador;
        this.pokemones = pokemones; 
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre(){
        return nombre;
    }
    public boolean isJugador(){
        return esJugador;
    }
    public Pokemon[] getPokemones(){
        return pokemones;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setJugador(boolean esJugador){
        this.esJugador = esJugador;
    }
    public void setPokemones(Pokemon[] pokemones){
        this.pokemones = pokemones;
    }

}

/**
* Esta clase Crea los gimnasios y utiliza listas de entrenadores, tiene relación con  Entrenador, con inicializar y Main
*@author Benjamín Hernández, Julian Barrantes y Gabriel Pérez
*@Version 1.0
*/
public class Gimnasio{
    String nombre;
    Entrenador[] entrenadores = new Entrenador[6];

    public Gimnasio(String nombre, Entrenador[] entrenadores){
        this.nombre = nombre;
        this.entrenadores = entrenadores;
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre(){
        return nombre;
    }
    public Entrenador[] getEntrenadores(){
        return entrenadores;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEntrenadores(Entrenador[] entrenadores){
        this.entrenadores = entrenadores;
    }
}
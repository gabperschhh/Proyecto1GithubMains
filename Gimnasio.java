public class Gimnasio{
    String nombre;
    Entrenador[] entrenadores = new Entrenador[6];

    public Gimnasio(String nombre, Entrenador[] entrenadores){
        this.nombre = nombre;
        this.entrenadores = entrenadores;
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
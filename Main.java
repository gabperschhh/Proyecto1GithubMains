public class Main{
    public static void main(String[] args) {
        Batalla b = new Batalla();
        Inicializar i = new Inicializar();
        int indiceNPC = 0;
        i.inicializarElementos();
        i.inicializarAtaques(); 
        i.inicializarPokemones();
        i.inicializarEntrenadores();
        Entrenador jugador = i.inicializarJugador();
        i.inicializarGimnasios();
        Entrenador npc = i.poolEntrenadores[indiceNPC];
        b.cicloBatalla(jugador, npc);
    }
}
public class Main{
    public static void main(String[] args) {
        Batalla b = new Batalla();
        Inicializar i = new Inicializar();
        i.inicializarElementos();
        i.inicializarAtaques();
        i.inicializarPokemones();
        i.inicializarEntrenadores();
        Entrenador jugador = i.inicializarJugador();
        i.inicializarGimnasio();
        Entrenador npc = i.poolEntrenadores[0];
        b.cicloBatalla(jugador, npc);
    }
}
public class Main{
    public static void main(String[] args) {
        Batalla b = new Batalla();
        Inicializar i = new Inicializar();
        int indiceNPC = 0;
        i.inicializarElementos();
        i.inicializarAtaques(); 
        i.inicializarPokemonesJugador();
        i.inicializarPokemonesNPC();
        i.inicializarEntrenadores();
        i.inicializarGimnasios();
        Entrenador jugadorOriginal = i.inicializarJugador();

        while(indiceNPC < 4){
            Pokemon[] pokemonesJugador = new Pokemon[3];
            for(int j = 0; j < 3; j++){
                Pokemon original = jugadorOriginal.getPokemones()[j];
                pokemonesJugador[j] = crearNuevoPokemon(original);
            }
            Entrenador jugador = new Entrenador(jugadorOriginal.getNombre(), true, pokemonesJugador);

            Entrenador npcOriginal = i.poolEntrenadores[indiceNPC];

            Pokemon[] pokemonesNPC = new Pokemon[3];
            for (int j = 0; j < 3; j++) {
                Pokemon original = npcOriginal.getPokemones()[j];
                pokemonesNPC[j] = crearNuevoPokemon(original);
            }
            Entrenador npc = new Entrenador(npcOriginal.getNombre(), false, pokemonesNPC);

            b.cicloBatalla(jugador, npc);
            indiceNPC ++;
            System.out.println("Avanzas hacia la siguiente batalla...");
        }
    }

    public static Pokemon crearNuevoPokemon(Pokemon original) {
        Stat stats = original.getStats(); 
        Stat nuevoStats = new Stat(stats.getHP(), stats.getHPActual(), stats.getATK(), stats.getDEF(), stats.getSPD());
        Ataque[] nuevosAtaques = new Ataque[original.getAtaques().length];
        for (int k = 0; k < nuevosAtaques.length; k++) {
            Ataque a = original.getAtaques()[k];
            nuevosAtaques[k] = new Ataque(a.getNombre(), a.getElemento(), a.getPotencia(), a.getPPMaximo(), a.getPPMaximo(), a.getPrecision()); // PPActual = PPMaximo
        }
        return new Pokemon(original.getNombre(), original.getNivel(), nuevoStats, original.getElementos(), nuevosAtaques, false); 
    }
}
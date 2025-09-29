public class Inicializar{
    static Elemento[] poolElementos = new Elemento[6];
    static Ataque[] poolAtaques = new Ataque[10];
    static Pokemon[] poolPokemones = new Pokemon[10];
    static Entrenador[] poolEntrenadores = new Entrenador[6];
    
    static Stat statsCharizard = new Stat(138, 80, 78, 94);

    public static Elemento[] inicializarElementos(){
        poolElementos[0] = new Elemento("Planta", new String[]{"Fuego", "Volador"}, new String[]{"Agua"});
        poolElementos[1] = new Elemento("Fuego", new String[]{"Agua"}, new String[]{"Planta"});
        poolElementos[2] = new Elemento("Agua", new String[]{"Electrico", "Planta"}, new String[]{"Fuego"});
        poolElementos[3] = new Elemento("Electrico", new String[]{}, new String[]{"Agua" , "Volador"});
        poolElementos[4] = new Elemento("Normal", new String[]{}, new String[]{});
        poolElementos[5] = new Elemento("Volador", new String[]{"Electrico"}, new String[]{"Planta"});
        return poolElementos;
    }

    public static Ataque[] inicializarAtaques(){
        poolAtaques[0] = new Ataque("Lanzallamas", poolElementos[1], 90, 15, 15, 100);
        poolAtaques[1] = new Ataque("Cuchillada", poolElementos[4], 70, 20, 20, 100);
        poolAtaques[2] = new Ataque("Ataque Ala", poolElementos[5], 60, 35, 35, 100);
        poolAtaques[3] = new Ataque("Nitrocarga", poolElementos[1], 50, 20, 20, 100);
        return poolAtaques;
    }

    public static Pokemon[] inicializarPokemones(){
        poolPokemones[0] = new Pokemon("Charizard", 50, statsCharizard, new Elemento[]{poolElementos[1], poolElementos[5]}, new Ataque[]{poolAtaques[0], poolAtaques[1], poolAtaques[2], poolAtaques[3]}, false );
        return poolPokemones;
    }

    public static Entrenador[] inicializarEntrenadores(){
        poolEntrenadores[0] = new Entrenador("Rodrigo Li", false, new Pokemon[]{poolPokemones[0]});
        return poolEntrenadores;
    }

    public static Gimnasio inicializarGimnasio(){
        Gimnasio gimnasio = new Gimnasio("Edificio Embrujado ECCI",new Entrenador[]{poolEntrenadores[0]});
        return gimnasio;
    }

}
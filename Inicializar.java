import java.util.Scanner;
public class Inicializar{
    static Elemento[] poolElementos = new Elemento[7];
    static Ataque[] poolAtaques = new Ataque[14];
    static Pokemon[] poolPokemones = new Pokemon[10];
    static Entrenador[] poolEntrenadores = new Entrenador[4];

    static Stat statsCharizard = new Stat(138, 102, 81, 94);
    static Stat statsInfernape = new Stat(136, 98, 68, 101);
    static Stat statsPikachu = new Stat(106, 80, 60, 112);
    static Stat statsGreninja = new Stat(132, 142, 68, 123);
    static Stat statsVenusaur = new Stat(140, 94, 94, 80);
    static Stat statsBlastoise = new Stat(139, 81, 99, 74);
    static Stat statsSnorlax = new Stat(220, 103, 63, 31);
    static Stat statsLucario = new Stat(130, 108, 67, 90);
    static Stat statsNoivern = new Stat(145, 91, 76, 121);
    static Stat statsDecidueye = new Stat(138, 100, 94, 70);

    public static Elemento[] inicializarElementos(){
        poolElementos[0] = new Elemento("Planta", new String[]{"Fuego", "Volador"}, new String[]{"Agua"});
        poolElementos[1] = new Elemento("Fuego", new String[]{"Agua"}, new String[]{"Planta"});
        poolElementos[2] = new Elemento("Agua", new String[]{"Electrico", "Planta"}, new String[]{"Fuego"});
        poolElementos[3] = new Elemento("Electrico", new String[]{}, new String[]{"Agua" , "Volador"});
        poolElementos[4] = new Elemento("Normal", new String[]{"Lucha"}, new String[]{});
        poolElementos[5] = new Elemento("Volador", new String[]{"Electrico"}, new String[]{"Planta", "Lucha"});
        poolElementos[6] = new Elemento("Lucha", new String[]{"Volador"}, new String[]{"Normal"});
        return poolElementos;
    }

    public static Ataque[] inicializarAtaques(){
        poolAtaques[0] = new Ataque("Lanzallamas", poolElementos[1], 90, 15, 15, 100);
        poolAtaques[1] = new Ataque("Nitrocarga", poolElementos[1], 50, 20, 20, 100);
        poolAtaques[2] = new Ataque("Cuchillada", poolElementos[4], 70, 20, 20, 100);
        poolAtaques[3] = new Ataque("Golpe cuerpo", poolElementos[4], 85, 15, 15, 100);
        poolAtaques[4] = new Ataque("Ataque Ala", poolElementos[5], 60, 35, 35, 100);
        poolAtaques[5] = new Ataque("Acrobata", poolElementos[5], 110, 15, 15, 100);
        poolAtaques[6] = new Ataque("Hoja Aguda", poolElementos[0], 90, 15, 15, 100);
        poolAtaques[7] = new Ataque("Latigo Cepa", poolElementos[0], 70, 35, 35, 100);
        poolAtaques[8] = new Ataque("Pistola Agua", poolElementos[2], 70, 25, 25, 100);
        poolAtaques[9] = new Ataque("Escaldar", poolElementos[2], 80, 15, 15, 100);
        poolAtaques[10] = new Ataque("Impactrueno", poolElementos[3], 50, 30, 30, 100);
        poolAtaques[11] = new Ataque("Puño Trueno", poolElementos[3], 90, 15, 15, 100);
        poolAtaques[12] = new Ataque("Palmeo", poolElementos[6], 60, 10, 10, 100);
        poolAtaques[13] = new Ataque("Esfera Aural", poolElementos[6], 80, 20, 20, 100);
        return poolAtaques;
    }

    public static Pokemon[] inicializarPokemones(){
        poolPokemones[0] = new Pokemon("Charizard", 50, statsCharizard, new Elemento[]{poolElementos[1], poolElementos[5]}, new Ataque[]{poolAtaques[0], poolAtaques[1], poolAtaques[2], poolAtaques[4]}, false );
        poolPokemones[1] = new Pokemon("Infernape", 50, statsInfernape, new Elemento[]{poolElementos[1], poolElementos[6]}, new Ataque[]{poolAtaques[0], poolAtaques[1], poolAtaques[12], poolAtaques[11]}, false );
        poolPokemones[2] = new Pokemon("Pikachu", 50, statsPikachu, new Elemento[]{poolElementos[3]}, new Ataque[]{poolAtaques[10], poolAtaques[11], poolAtaques[5], poolAtaques[12]}, false );
        poolPokemones[3] = new Pokemon("Greninja", 50, statsGreninja, new Elemento[]{poolElementos[2]}, new Ataque[]{poolAtaques[8], poolAtaques[9], poolAtaques[5], poolAtaques[2]}, false );
        poolPokemones[4] = new Pokemon("Venusaur", 50, statsVenusaur, new Elemento[]{poolElementos[0]}, new Ataque[]{poolAtaques[6], poolAtaques[7], poolAtaques[3], poolAtaques[2]}, false );
        poolPokemones[5] = new Pokemon("Blastoise", 50, statsBlastoise, new Elemento[]{poolElementos[2]}, new Ataque[]{poolAtaques[8], poolAtaques[9], poolAtaques[3], poolAtaques[13]}, false );
        poolPokemones[6] = new Pokemon("Snorlax", 50, statsSnorlax, new Elemento[]{poolElementos[4]}, new Ataque[]{poolAtaques[3], poolAtaques[4], poolAtaques[12], poolAtaques[10]}, false );
        poolPokemones[7] = new Pokemon("Lucario", 50, statsLucario, new Elemento[]{poolElementos[6]}, new Ataque[]{poolAtaques[12], poolAtaques[13], poolAtaques[2], poolAtaques[11]}, false );
        poolPokemones[8] = new Pokemon("Noivern", 50, statsNoivern, new Elemento[]{poolElementos[5]}, new Ataque[]{poolAtaques[4], poolAtaques[5], poolAtaques[1], poolAtaques[2]}, false );
        poolPokemones[9] = new Pokemon("Decidueye", 50, statsDecidueye, new Elemento[]{poolElementos[0], poolElementos[5]}, new Ataque[]{poolAtaques[6], poolAtaques[7], poolAtaques[4], poolAtaques[2]}, false );
        return poolPokemones;
    }

    public static Entrenador[] inicializarEntrenadores(){
        poolEntrenadores[0] = new Entrenador("Guarda ECCI", false, new Pokemon[]{poolPokemones[2], poolPokemones[8], poolPokemones[5]});
        poolEntrenadores[1] = new Entrenador("Conserje ECCI", false, new Pokemon[]{poolPokemones[1], poolPokemones[6], poolPokemones[7]});
        poolEntrenadores[2] = new Entrenador("Asistente ECCI", false, new Pokemon[]{poolPokemones[4], poolPokemones[2], poolPokemones[9]});
        poolEntrenadores[3] = new Entrenador("Lider Prof. Rodrigo Li", false, new Pokemon[]{poolPokemones[6], poolPokemones[7], poolPokemones[0]});
        return poolEntrenadores;
    }

    public static Entrenador inicializarJugador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido!");
        System.out.println("Ingresa tu nombre: ");
        String nombre = scanner.next();
        System.out.println("Elige tu primer pokemon:");
        for (int i = 0; i < poolPokemones.length; i++) {
            System.out.println(i + ") " + poolPokemones[i].getNombre() +poolPokemones[i].getNivel() + poolPokemones[i].getElementos() + poolPokemones[i].getAtaques());
        }
        int pk1 = scanner.nextInt();
        System.out.println("Elige tu segundo pokemon (puedes repetir pero no te recomiendo eso :P ):");
        for (int i = 0; i < poolPokemones.length; i++) {
            System.out.println(i + ") " + poolPokemones[i].getNombre() + poolPokemones[i].getNivel() + poolPokemones[i].getElementos() + poolPokemones[i].getAtaques());
        }
        int pk2 = scanner.nextInt();
        System.out.println("Elige tu tercer pokemon (puedes repetir pero no te recomiendo eso :P ):");
        for (int i = 0; i < poolPokemones.length; i++) {
            System.out.println(i + ") " + poolPokemones[i].getNombre() + poolPokemones[i].getNivel() + poolPokemones[i].getElementos() + poolPokemones[i].getAtaques());
        }
        int pk3 = scanner.nextInt();
        Entrenador jugador = new Entrenador(nombre, true , new Pokemon[]{poolPokemones[pk1], poolPokemones[pk2], poolPokemones[pk3]});
        return jugador;
    }

    public static Gimnasio inicializarGimnasio(){
        Gimnasio gimnasio = new Gimnasio("Edificio Embrujado ECCI",new Entrenador[]{poolEntrenadores[0], poolEntrenadores[1], poolEntrenadores[2], poolEntrenadores[3]});
        return gimnasio;
    }

}
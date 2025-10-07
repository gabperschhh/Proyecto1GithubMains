import java.util.Arrays;
import java.util.Scanner;
public class Inicializar{
    static Elemento[] poolElementos = new Elemento[7];
    static Ataque[] poolAtaques = new Ataque[14];
    static Pokemon[] poolPokemonesNPC = new Pokemon[10];
    static Pokemon[] poolPokemonesJugador = new Pokemon[10];
    static Entrenador[] poolEntrenadores = new Entrenador[4];
    static Gimnasio[] poolGimnasios = new Gimnasio[3];

    static Stat statsCharizardNPC = new Stat(138, 138, 102, 81, 94);
    static Stat statsInfernapeNPC = new Stat(136, 136, 98, 68, 101);
    static Stat statsPikachuNPC = new Stat(106, 106, 80, 60, 112);
    static Stat statsGreninjaNPC = new Stat(132, 132, 142, 68, 123);
    static Stat statsVenusaurNPC = new Stat(140, 140, 94, 94, 80);
    static Stat statsBlastoiseNPC = new Stat(139, 139, 81, 99, 74);
    static Stat statsSnorlaxNPC = new Stat(220, 220, 103, 63, 31);
    static Stat statsLucarioNPC = new Stat(130, 130, 108, 67, 90);
    static Stat statsNoivernNPC = new Stat(145, 145, 91, 76, 121);
    static Stat statsDecidueyeNPC = new Stat(138, 138, 100, 94, 70);

    static Stat statsCharizardJ = new Stat(138, 138, 102, 81, 94);
    static Stat statsInfernapeJ = new Stat(136, 136, 98, 68, 101);
    static Stat statsPikachuJ = new Stat(106, 106, 80, 60, 112);
    static Stat statsGreninjaJ = new Stat(132, 132, 142, 68, 123);
    static Stat statsVenusaurJ = new Stat(140, 140, 94, 94, 80);
    static Stat statsBlastoiseJ = new Stat(139, 139, 81, 99, 74);
    static Stat statsSnorlaxJ = new Stat(220, 220, 103, 63, 31);
    static Stat statsLucarioJ = new Stat(130, 130, 108, 67, 90);
    static Stat statsNoivernJ = new Stat(145, 145, 91, 76, 121);
    static Stat statsDecidueyeJ = new Stat(138, 138, 100, 94, 70);

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

    public static Pokemon[] inicializarPokemonesNPC(){
        poolPokemonesNPC[0] = new Pokemon("Charizard", 50, statsCharizardNPC, new Elemento[]{poolElementos[1], poolElementos[5]}, new Ataque[]{poolAtaques[0], poolAtaques[1], poolAtaques[2], poolAtaques[4]}, false );
        poolPokemonesNPC[1] = new Pokemon("Infernape", 50, statsInfernapeNPC, new Elemento[]{poolElementos[1], poolElementos[6]}, new Ataque[]{poolAtaques[0], poolAtaques[1], poolAtaques[12], poolAtaques[11]}, false );
        poolPokemonesNPC[2] = new Pokemon("Pikachu", 50, statsPikachuNPC, new Elemento[]{poolElementos[3]}, new Ataque[]{poolAtaques[10], poolAtaques[11], poolAtaques[5], poolAtaques[12]}, false );
        poolPokemonesNPC[3] = new Pokemon("Greninja", 50, statsGreninjaNPC, new Elemento[]{poolElementos[2]}, new Ataque[]{poolAtaques[8], poolAtaques[9], poolAtaques[5], poolAtaques[2]}, false );
        poolPokemonesNPC[4] = new Pokemon("Venusaur", 50, statsVenusaurNPC, new Elemento[]{poolElementos[0]}, new Ataque[]{poolAtaques[6], poolAtaques[7], poolAtaques[3], poolAtaques[2]}, false );
        poolPokemonesNPC[5] = new Pokemon("Blastoise", 50, statsBlastoiseNPC, new Elemento[]{poolElementos[2]}, new Ataque[]{poolAtaques[8], poolAtaques[9], poolAtaques[3], poolAtaques[13]}, false );
        poolPokemonesNPC[6] = new Pokemon("Snorlax", 50, statsSnorlaxNPC, new Elemento[]{poolElementos[4]}, new Ataque[]{poolAtaques[3], poolAtaques[4], poolAtaques[12], poolAtaques[10]}, false );
        poolPokemonesNPC[7] = new Pokemon("Lucario", 50, statsLucarioNPC, new Elemento[]{poolElementos[6]}, new Ataque[]{poolAtaques[12], poolAtaques[13], poolAtaques[2], poolAtaques[11]}, false );
        poolPokemonesNPC[8] = new Pokemon("Noivern", 50, statsNoivernNPC, new Elemento[]{poolElementos[5]}, new Ataque[]{poolAtaques[4], poolAtaques[5], poolAtaques[1], poolAtaques[2]}, false );
        poolPokemonesNPC[9] = new Pokemon("Decidueye", 50, statsDecidueyeNPC, new Elemento[]{poolElementos[0], poolElementos[5]}, new Ataque[]{poolAtaques[6], poolAtaques[7], poolAtaques[4], poolAtaques[2]}, false );
        return poolPokemonesNPC;
    }

    public static Pokemon[] inicializarPokemonesJugador(){
        poolPokemonesJugador[0] = new Pokemon("Charizard", 50, statsCharizardJ, new Elemento[]{poolElementos[1], poolElementos[5]}, new Ataque[]{poolAtaques[0], poolAtaques[1], poolAtaques[2], poolAtaques[4]}, false );
        poolPokemonesJugador[1] = new Pokemon("Infernape", 50, statsInfernapeJ, new Elemento[]{poolElementos[1], poolElementos[6]}, new Ataque[]{poolAtaques[0], poolAtaques[1], poolAtaques[12], poolAtaques[11]}, false );
        poolPokemonesJugador[2] = new Pokemon("Pikachu", 50, statsPikachuJ, new Elemento[]{poolElementos[3]}, new Ataque[]{poolAtaques[10], poolAtaques[11], poolAtaques[5], poolAtaques[12]}, false );
        poolPokemonesJugador[3] = new Pokemon("Greninja", 50, statsGreninjaJ, new Elemento[]{poolElementos[2]}, new Ataque[]{poolAtaques[8], poolAtaques[9], poolAtaques[5], poolAtaques[2]}, false );
        poolPokemonesJugador[4] = new Pokemon("Venusaur", 50, statsVenusaurJ, new Elemento[]{poolElementos[0]}, new Ataque[]{poolAtaques[6], poolAtaques[7], poolAtaques[3], poolAtaques[2]}, false );
        poolPokemonesJugador[5] = new Pokemon("Blastoise", 50, statsBlastoiseJ, new Elemento[]{poolElementos[2]}, new Ataque[]{poolAtaques[8], poolAtaques[9], poolAtaques[3], poolAtaques[13]}, false );
        poolPokemonesJugador[6] = new Pokemon("Snorlax", 50, statsSnorlaxJ, new Elemento[]{poolElementos[4]}, new Ataque[]{poolAtaques[3], poolAtaques[4], poolAtaques[12], poolAtaques[10]}, false );
        poolPokemonesJugador[7] = new Pokemon("Lucario", 50, statsLucarioJ, new Elemento[]{poolElementos[6]}, new Ataque[]{poolAtaques[12], poolAtaques[13], poolAtaques[2], poolAtaques[11]}, false );
        poolPokemonesJugador[8] = new Pokemon("Noivern", 50, statsNoivernJ, new Elemento[]{poolElementos[5]}, new Ataque[]{poolAtaques[4], poolAtaques[5], poolAtaques[1], poolAtaques[2]}, false );
        poolPokemonesJugador[9] = new Pokemon("Decidueye", 50, statsDecidueyeJ, new Elemento[]{poolElementos[0], poolElementos[5]}, new Ataque[]{poolAtaques[6], poolAtaques[7], poolAtaques[4], poolAtaques[2]}, false );
        return poolPokemonesJugador;
    }

    public static Entrenador[] inicializarEntrenadores(){
        poolEntrenadores[0] = new Entrenador("Guarda ECCI", false, new Pokemon[]{poolPokemonesNPC[2], poolPokemonesNPC[8], poolPokemonesNPC[5]});
        poolEntrenadores[1] = new Entrenador("Conserje ECCI", false, new Pokemon[]{poolPokemonesNPC[1], poolPokemonesNPC[6], poolPokemonesNPC[7]});
        poolEntrenadores[2] = new Entrenador("Asistente ECCI", false, new Pokemon[]{poolPokemonesNPC[4], poolPokemonesNPC[2], poolPokemonesNPC[9]});
        poolEntrenadores[3] = new Entrenador("Lider Prof. Rodrigo Li", false, new Pokemon[]{poolPokemonesNPC[6], poolPokemonesNPC[7], poolPokemonesNPC[0]});
        return poolEntrenadores;
    }

    public static Entrenador inicializarJugador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido!");
        System.out.println("Ingresa tu nombre: ");
        String nombre = scanner.next();
        System.out.println("Elige tu primer pokemon:");
        for (int i = 0; i < poolPokemonesJugador.length; i++) {
            System.out.println(i + ") " + poolPokemonesJugador[i].getNombre() + "| Nivel: " + poolPokemonesJugador[i].getNivel() + "| Tipo(s)"+ Arrays.toString(poolPokemonesJugador[i].getElementos()) + "| Movimientos: " + Arrays.toString(poolPokemonesJugador[i].getAtaques()));
        }
        int pk1 = scanner.nextInt();
        System.out.println("Elige tu segundo pokemon (NO se puede repetir):");
        for (int i = 0; i < poolPokemonesJugador.length; i++) {
            System.out.println(i + ") " + poolPokemonesJugador[i].getNombre() + "| Nivel: " + poolPokemonesJugador[i].getNivel() + "| Tipo(s)"+ Arrays.toString(poolPokemonesJugador[i].getElementos()) + "| Movimientos: " + Arrays.toString(poolPokemonesJugador[i].getAtaques()));
        }
        int pk2 = scanner.nextInt();
        System.out.println("Elige tu tercer pokemon (NO se puede repetir):");
        for (int i = 0; i < poolPokemonesJugador.length; i++) {
            System.out.println(i + ") " + poolPokemonesJugador[i].getNombre() + "| Nivel: " + poolPokemonesJugador[i].getNivel() + "| Tipo(s)"+ Arrays.toString(poolPokemonesJugador[i].getElementos()) + "| Movimientos: " + Arrays.toString(poolPokemonesJugador[i].getAtaques()));
        }
        int pk3 = scanner.nextInt();
        Entrenador jugador = new Entrenador(nombre, true , new Pokemon[]{poolPokemonesJugador[pk1], poolPokemonesJugador[pk2], poolPokemonesJugador[pk3]});
        return jugador;
    }

    public static Gimnasio[] inicializarGimnasios() {
        poolGimnasios[0] = new Gimnasio("Edificio Embrujado ECCI", new Entrenador [] {poolEntrenadores[0], poolEntrenadores[1]}); 
        poolGimnasios[1] = new Gimnasio ("Asocia abandonada", new Entrenador[]{poolEntrenadores[2]});
        poolGimnasios[2] = new Gimnasio ("Anexo ECCI", new Entrenador[]{poolEntrenadores[3]});
        return poolGimnasios;
    }
    
    public void mostrarEntrenadores(Entrenador[] poolEntrenadores, int index, boolean[] combate){
        if (index == 0 || combate[index - 1]){
            System.out.println("Iniciaste combate con " + poolEntrenadores[index].getNombre());
            combate[index] = true;
        }
        else{
            System.out.println("bro, no te saltes entrenadores, sigue el guion >:V, vence a " + poolEntrenadores[index - 1].getNombre() + "para poder enfrentarte a " + poolEntrenadores[index].getNombre());
            //Para enfrentarlos en orden y todo siga su curso, equilibrado diria Thanos.
        }
    }
}
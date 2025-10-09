/**
*Genera cuatro combates Pokemon entre un jugador y la IA
*@author Benjamin Hernández, Julian Barrantes y Gabriel perez
*@Version 1.0
*/
import java.util.Random;
import java.util.Scanner;
public class Batalla{

    public static void limpiarPantalla() { //me quedo de un curso viejo, lo puse para que se
    //vea mas cool :D
        try {
            String terminal = "exec", opcion = "", comando = "clear";
            String OS = System.getProperty("os.name");
            if (OS.contains("Windows")) {
                terminal = "cmd";
                opcion = "/c";
                comando = "cls";
            }
            new ProcessBuilder(terminal, opcion, comando).inheritIO().start().waitFor();
        } catch (Exception ex) {
            // Si falla, hacer una limpieza básica
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
    /**
*Define si el pokemon es débil contra el elemento 
*@param tipoAtaque
*@param debilidades
*@return true si es debil contra el elemento; false en caso contrario
*/
    private static boolean esDebilidad(String tipoAtaque, String[] debilidades){
        for (String d : debilidades){   
            if (d.equalsIgnoreCase(tipoAtaque)) { 
                return true;
            }
        } 
        return false;
    }
    /**
*Define si el pokemon es fuerte contra el elemento 
*@param tipoAtaque
*@param fortalezas
*@return true si es fuerte contra el elemento; false en caso contrario
*/
    private static boolean esFortaleza(String tipoAtaque, String[] fortalezas){
        for (String f : fortalezas){   
            if (f.equalsIgnoreCase(tipoAtaque)) {
                return true;
            }
        }
        return false;
    }
    /**
*Muestra la efectividad de un ataque de un Pokemon a otro dependiendo del elemento 
*@param tipoAtaque
*@param fortalezas
*@param debilidades
*@return 2.0 si es débil contra el elemento; 0.5 si es fuerte; 1.0 si no es ninguna
*/
    public static double obtenerEfectividad(String tipoAtaque, String[] debilidades, String[] fortalezas){
        double efectividad = 1.0;
        if (esDebilidad(tipoAtaque, debilidades) == true){
            return 2.0;
        } else if (esFortaleza(tipoAtaque, fortalezas)){
            return 0.5;
        }
        return 1.0;
        //no hay manera que se de un x4, casualidad o causalidad? shhhhh
    }
/**
*Define si un ataque es critico o no mediante probabilidad 
*@param random
*@param prob
*@return true si es critico; false en caso contrario
*/
    public boolean esCritico(){
        Random random = new Random();
        int prob = random.nextInt(100) + 1; //como genera de 0 a 99 le sumamos uno para que sea entre 1 a 100, es como lo mismo pero queda mejor xd
        if (prob <= 33){
            return true;
        }
        return false;
    }
    /**
*Calcula el daño que se hace mediante la efectividad del ataque
*@param nivelAtacante 
*@param potenciaAtaque
*@param ataque 
*@param defensa
*@param daño
*@return (int) daño
*/
    public int calcularDaño(Pokemon atacante, Pokemon defensor, Ataque ataqueUsado, boolean esCritico, double efectividadTotal){
        int nivelAtacante = atacante.getNivel();
        int potenciaAtaque = ataqueUsado.getPotencia();
        int ataque = atacante.getStats().getATK();
        int defensa = defensor.getStats().getDEF();
        double daño = ((2.0 * nivelAtacante / 5 + 2) * potenciaAtaque * ataque / defensa) / 50 + 2;
        //formula mas parecida que encontre respecto a como se calcula en los juegos

        daño *= efectividadTotal;
        
        if (esCritico == true){
            daño *= 2;
        }

        daño *= (0.85 + Math.random() * 0.15); //en los juegos hay un elemento aleatorio de potencia en cada ataque
        //fue la formula mas parecida que encontre a la del juego

        return (int) daño; //reconvierte a int
    }
    /**
*Se comparan las velocidades para saber quién empieza
*@param poke1
*@param poke2
*@return poke1 si la velocidad del pokemon del jugador es mayor; poke2 en caso contrario
*/
    public Pokemon compararVelocidades(Pokemon poke1, Pokemon poke2){
        if(poke1.getStats().getSPD() > poke2.getStats().getSPD()){
            return poke1;
        }else if (poke1.getStats().getSPD() < poke2.getStats().getSPD()){
            return poke2;
        }
        return poke1;
    }
    /**
*Define como ataca la IA
*@param rand
*@param ataque
*@return ataque
*/
    public int ataqueIA(){
        Random rand = new Random();
        int ataque = rand.nextInt(4);
        return ataque;
    }
    /**
*Define como ataca el jugador 
*@param ataqueUsado
*@param atacante 
*@param defensor
*@param tipoAtaque
*@param efectividadTotal
*@param poke1
*@param poke2
*@param ppActual
*@param nuevoPP
*@param nuevoHP
*@param esCritico
*@throws <Error> si ya no quedan más pp para usar
*/
    public void atacar(Ataque ataqueUsado, Pokemon atacante, Pokemon defensor, String tipoAtaque, double efectividadTotal, Pokemon poke1, Pokemon poke2){
        Scanner s = new Scanner(System.in);
        try {
            if(ataqueUsado.getPPActual() > 0){
                boolean esCritico = esCritico();

                int daño = calcularDaño(atacante, defensor, ataqueUsado, esCritico, efectividadTotal);

                int ppActual = ataqueUsado.getPPActual();
                int nuevoPP = ppActual - 1;
                ataqueUsado.setPPActual(nuevoPP);

                int hpActual = defensor.getStats().getHPActual();
                int nuevoHP = hpActual - daño;
                defensor.getStats().setHPActual(nuevoHP);

                System.out.println(atacante.getNombre() + " ha usado " + ataqueUsado + "!");
                s.nextLine();

                if(defensor == poke2){
                    System.out.println("El " + defensor.getNombre() + " rival perdió " + daño + " de vida.");
                    s.nextLine();
                }

                if(defensor == poke1){
                    System.out.println("Tu " + defensor.getNombre() + " perdió " + daño + " de vida.");
                    s.nextLine();
                }

                if(efectividadTotal == 2.0){
                    System.out.println("Es supereficaz!");
                    s.nextLine();
                }else if(efectividadTotal == 0.5){
                    System.out.println("Es poco eficaz...");
                    s.nextLine();
                }
                if(esCritico == true){
                    System.out.println("Un golpe crítico");
                    s.nextLine();
                }
                if(defensor.getStats().getHPActual() <= 0){
                    defensor.setDebilitado(true);
                    defensor.getStats().setHPActual(0);
                    if(defensor == poke1){
                        System.out.println("Tu " + defensor.getNombre() + " se ha debilitado");
                    }
                    if (defensor == poke2){
                        System.out.println("El " + defensor.getNombre() + " rival se ha debilitado");
                    }
                    s.nextLine();
                }

            }
        } catch (Exception e) {
            if(ataqueUsado.getPPActual() == 0){
                System.out.println("No hay PP!");
            }
        }
    }
    /**
 * Comprueba si alguno de los Pokémon activos en el campo está debilitado (HP <= 0).
 * @param Poke1 Pokémon activo jugador.
 * @param Poke2 Pokémon activo NPC.
 * @param jugador El objeto Entrenador del jugador. (no se usa internamente)
 * @param npc El objeto Entrenador del NPC. (tampoco se usa pero igual)
 * @return true si Poke1 o Poke2 están debilitados y necesitan ser cambiados; false en caso contrario.
 */
    public boolean comprobarSalud(Pokemon Poke1 , Pokemon Poke2, Entrenador jugador, Entrenador npc){
        if(Poke1.isDebilitado() == true){
            return true;
        } else if (Poke2.isDebilitado() == true){
            return true;
        }
        return false;
    }
    /**
 * Recorre el equipo del jugador para verificar si todos sus Pokémon están debilitados.
 * @param jugador El Entrenador con su equipo.
 * @return true si TODOS los Pokémon del jugador están debilitados (el jugador pierde la batalla); false si aún le queda alguno.
 */
    public boolean comprobarPokemonesJugador(Entrenador jugador){
        Pokemon[] pokemones = jugador.getPokemones();
        for(int i = 0 ; i < pokemones.length; i++){
            if(!pokemones[i].isDebilitado()){
                return false;
            }
        }
        return true;
    }
    /**
 * Recorre el equipo del NPC para verificar si todos sus Pokémon están debilitados.
 * @param npc El Entrenador del NPC con su equipo de Pokémon.
 * @return true si TODOS los Pokémon del NPC están debilitados (pierde); false si aún le queda alguno.
 */
    public boolean comprobarPokemonesNPC(Entrenador npc){
        Pokemon[] pokemones = npc.getPokemones();
        for(int i = 0 ; i < pokemones.length; i++){
            if(!pokemones[i].isDebilitado()){
                return false;
            }
        }
        return true;
    }
    /**
 * Muestra la lista de Pokémon del jugador y manipula la interacción para seleccionar y validar un cambio de Pokémon activo.
 * @param poke1 El Pokémon que está actualmente en batalla (para validación de no repetición).
 * @param jugador El Entrenador del jugador.
 * @return El Pokémon recién elegido y válido para ingresar al campo de batalla.
 */
    public Pokemon cambiarPokemonJugador(Pokemon poke1, Entrenador jugador){
        Scanner scan = new Scanner(System.in);
        Pokemon pokemonElegido = null;
        boolean cambioValido = false;
        Pokemon[] pokemonesJugador = jugador.getPokemones();
        System.out.println("\n--- Lista de Pokémon ---");
        for (int i = 0; i < pokemonesJugador.length; i++) {
            Pokemon p = pokemonesJugador[i];
            System.out.println(i + ". " + p.getNombre() + " (HP: " + p.getStats().getHPActual() + "/" + p.getStats().getHP() + ")");
        }
        while(cambioValido != true){
            try{
                System.out.print("\n¿A qué Pokémon quieres cambiar? Ingresa el número: ");
                int opcionPokemon = scan.nextInt();
                if (opcionPokemon < 0 || opcionPokemon >= pokemonesJugador.length) {
                    System.out.println("Opción inválida. No existe un Pokémon con ese número.");
                } else {
                    pokemonElegido = pokemonesJugador[opcionPokemon];

                    if (pokemonElegido == poke1) {
                        System.out.println("Ya estás usando ese Pokémon. No puedes cambiar al mismo.");
                    } else if (pokemonElegido.getStats().getHPActual() <= 0) {
                        System.out.println("Ese Pokémon está debilitado y no puede combatir.");
                    } else {
                        cambioValido = true;
                    }
                }
            
            } catch (Exception e){
                System.out.println("Entrada inválida. Debes escribir un número.");
                scan.nextLine();
            }
        } 
        System.out.println("\n¡Cambiaste a " + pokemonElegido.getNombre() + "!");
        scan.nextLine();
        limpiarPantalla();
        return pokemonElegido;
    }
    /**
 * Implementa lógica para que el NPC cambie de Pokémon.
 * Elige el primer Pokémon de su lista que NO esté debilitado.
 * @param Poke2 Pokémon activo del NPC (el debilitado).
 * @param npc Entrenador NPC.
 * @return El primer Pokémon disponible del equipo del NPC.
 */
    public Pokemon cambiarPokemonNPC(Pokemon Poke2, Entrenador npc){
        Scanner x = new Scanner(System.in);
        Pokemon[] pokemonesNPC = npc.getPokemones();
        Pokemon pokemonElegido = null;
        for(int i = 0; i < pokemonesNPC.length; i++){
            if(pokemonesNPC[i].isDebilitado() == false){
                pokemonElegido = pokemonesNPC[i];
            }
        }
        System.out.println(npc.getNombre() + " escoge a " + pokemonElegido);
        x.nextLine();
        return pokemonElegido;
    }
    /**
 * Método que ejecuta el ciclo de combate.
 * Controla la prioridad de ataque por velocidad.
 * y la lógica de finalización de batalla.
 * @param jugador El Entrenador controlado por el usuario.
 * @param npc El Entrenador rival (NPC).
 * @return true si el jugador gana la batalla; false si el jugador pierde la batalla.
 */
    public boolean cicloBatalla(Entrenador jugador, Entrenador npc){
        Scanner sc = new Scanner(System.in);
        int indiceJugador = 0;
        int indiceNPC = 0;
        Pokemon poke1 = jugador.getPokemones()[indiceJugador]; //pokemon activo
        Pokemon poke2 = npc.getPokemones()[indiceNPC]; 
        boolean enCombate = true;
        Ataque ataqueUsado;
        int opcion;
        Pokemon atacante;
        Pokemon defensor;
        String tipoAtaque;
        int derrotas = 0;
        int victorias= 0;

        System.out.println("Te enfrentas a " + npc.getNombre());
        sc.nextLine();
        System.out.println(npc.getNombre() + " inicia con " + poke2.getNombre() + "!");
        sc.nextLine();

        while(enCombate){
            if(compararVelocidades(poke1, poke2) == poke1){
                System.out.println("HP de tu " + poke1.getNombre() + ": " + poke1.getStats().getHPActual() +" / "+ poke1.getStats().getHP());
                System.out.println("HP del " + poke2.getNombre() + " rival: " + poke2.getStats().getHPActual() + " / " + poke2.getStats().getHP());
                System.out.println("Que quieres hacer?");
                for (int i = 0; i < poke1.getAtaques().length; i++){
                    Ataque ataqueDisponible = poke1.getAtaques()[i];
                    System.out.println((i + 1) + ") " + poke1.getAtaques()[i] + " | " + ataqueDisponible.getPotencia() + " | " + ataqueDisponible.getPPActual() + "/" + ataqueDisponible.getPPMaximo() + " | " + ataqueDisponible.getElemento() );
                }
                System.out.println("5) Cambiar Pokemon");
                opcion = sc.nextInt();
                opcion -= 1;
                if (opcion <= 3){
                    ataqueUsado = poke1.getAtaques()[opcion];
                    atacante = poke1;
                    defensor = poke2;
                    tipoAtaque = ataqueUsado.getElemento().getNombre();
                    double efectividadTotal = 1.0;
                    
                    for (Elemento elemDef : poke2.getElementos()) {
                        if (elemDef != null) {
                            efectividadTotal *= obtenerEfectividad(tipoAtaque, elemDef.getDebilidades(), elemDef.getFortalezas());
                        }
                    }

                    atacar(ataqueUsado, atacante, defensor, tipoAtaque, efectividadTotal, poke1, poke2);
                    if(comprobarPokemonesNPC(npc) == true){
                        System.out.println("Has ganado la batalla contra " + npc.getNombre() + "!");
                        sc.nextLine();
                        return true;
                        
                    } else{
                        if(comprobarSalud(poke1, poke2, jugador, npc) == true){
                            poke2 = cambiarPokemonNPC(poke2, npc);
                        }
                    }

                } else if(opcion == 4){
                    poke1 = cambiarPokemonJugador(poke1, jugador);
                } else{
                    System.out.println("Opcion no valida");
                }

                int ataqueNPC = ataqueIA();
                ataqueUsado = poke2.getAtaques()[ataqueNPC];
                atacante = poke2;
                defensor = poke1;
                tipoAtaque = ataqueUsado.getElemento().getNombre();

                double efectividadTotal = 1.0;
                for (Elemento elemDef : poke1.getElementos()) {
                        if (elemDef != null) {
                            efectividadTotal *= obtenerEfectividad(tipoAtaque, elemDef.getDebilidades(), elemDef.getFortalezas());
                        }
                }
                atacar(ataqueUsado, atacante, defensor, tipoAtaque, efectividadTotal, poke1, poke2);

                if(comprobarPokemonesJugador(jugador) == true){
                    System.out.println("Has perdido la batalla contra " + npc.getNombre() + "!");
                    derrotas ++;
                    sc.nextLine();
                    return false;
                } else{
                    if(comprobarSalud(poke1, poke2, jugador, npc) == true){
                        poke1 = cambiarPokemonJugador(poke1, jugador);
                    }
                }
                limpiarPantalla();

            }else if (compararVelocidades(poke1, poke2) == poke2){

                System.out.println("HP de tu " + poke1.getNombre() + ": " + poke1.getStats().getHPActual() +" / "+ poke1.getStats().getHP());
                System.out.println("HP del " + poke2.getNombre() + " rival: " + poke2.getStats().getHPActual() + " / " + poke2.getStats().getHP());

                System.out.println("Que quieres hacer?");
                for (int i = 0; i < poke1.getAtaques().length; i++){
                    Ataque ataqueDisponible = poke1.getAtaques()[i];
                    System.out.println((i + 1) + ") " + poke1.getAtaques()[i] + " | " + ataqueDisponible.getPotencia() + " | " + ataqueDisponible.getPPActual() + "/" + ataqueDisponible.getPPMaximo() + " | " + ataqueDisponible.getElemento() );
                }
                System.out.println("5) Cambiar Pokemon");
                opcion = sc.nextInt();

                int ataqueNPC = ataqueIA();
                ataqueUsado = poke2.getAtaques()[ataqueNPC];
                atacante = poke2;
                defensor = poke1;
                tipoAtaque = ataqueUsado.getElemento().getNombre();

                double efectividadTotal = 1.0;
                for (Elemento elemDef : poke1.getElementos()) {
                        if (elemDef != null) {
                            efectividadTotal *= obtenerEfectividad(tipoAtaque, elemDef.getDebilidades(), elemDef.getFortalezas());
                        }
                }
                atacar(ataqueUsado, atacante, defensor, tipoAtaque, efectividadTotal, poke1, poke2);

                if(comprobarPokemonesJugador(jugador) == true){
                    System.out.println("Has perdido la batalla contra " + npc.getNombre() + "!");
                    derrotas ++;
                    sc.nextLine();
                    return false;
                } else{
                    if(comprobarSalud(poke1, poke2, jugador, npc) == true){
                        poke1 = cambiarPokemonJugador(poke1, jugador);
                        System.out.println("Que quieres hacer?");
                        for (int i = 0; i < poke1.getAtaques().length; i++){
                            Ataque ataqueDisponible = poke1.getAtaques()[i];
                            System.out.println((i + 1) + ") " + poke1.getAtaques()[i] + " | " + ataqueDisponible.getPotencia() + " | " + ataqueDisponible.getPPActual() + "/" + ataqueDisponible.getPPMaximo() + " | " + ataqueDisponible.getElemento() );
                        }
                        System.out.println("5) Cambiar Pokemon");
                    }
                }
                
                opcion -= 1;
                if (opcion <= 3){
                    ataqueUsado = poke1.getAtaques()[opcion];
                    atacante = poke1;
                    defensor = poke2;
                    tipoAtaque = ataqueUsado.getElemento().getNombre();
                    efectividadTotal = 1.0;
                    
                    for (Elemento elemDef : poke2.getElementos()) {
                        if (elemDef != null) {
                            efectividadTotal *= obtenerEfectividad(tipoAtaque, elemDef.getDebilidades(), elemDef.getFortalezas());
                        }
                    }


                    atacar(ataqueUsado, atacante, defensor, tipoAtaque, efectividadTotal, poke1, poke2);
                    if(comprobarPokemonesNPC(npc) == true){
                        System.out.println("Has ganado la batalla contra " + npc.getNombre() + "!");
                        victorias ++;
                        sc.nextLine();
                        return true;
                    } else{
                        if(comprobarSalud(poke1, poke2, jugador, npc) == true){
                            poke2 = cambiarPokemonNPC(poke2, npc);
                        }
                    }
                } else if(opcion == 4){
                    poke1 = cambiarPokemonJugador(poke1, jugador);
                } else{
                    System.out.println("Opcion no valida");
                }
                limpiarPantalla();
            }
        }
        return false; //deberia ser inalcanzable xd
    }
}
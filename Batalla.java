import java.util.Random;
public class Batalla{

    private static boolean esDebilidad(String tipoAtaque, String[] debilidades){
        for (String d : debilidades){   
            if (d.equalsIgnoreCase(tipoAtaque)) { 
                return true;
            }
        } 
        return false;
    }

    private static boolean esFortaleza(String tipoAtaque, String[] fortalezas){
        for (String f : fortalezas){   
            if (f.equalsIgnoreCase(tipoAtaque)) {
                return true;
            }
        }
        return false;
    }

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

    public boolean esCritico(){
        Random random = new Random();
        int prob = random.nextInt(100) + 1; //como genera de 0 a 99 le sumamos uno para que sea entre 1 a 100, es como lo mismo pero queda mejor xd
        if (prob <= 33){
            return true;
        }
        return false;
    }

    public int calcularDaño(Pokemon atacante, Pokemon defensor, Ataque ataqueUsado, boolean esCritico){
        int nivelAtacante = atacante.getNivel();
        int potenciaAtaque = ataqueUsado.getPotencia();
        int ataque = atacante.getStats().getATK();
        int defensa = defensor.getStats().getDEF();
        double daño = ((2.0 * nivelAtacante / 5 + 2) * potenciaAtaque * ataque / defensa) / 50 + 2;
        //formula mas parecida que encontre respecto a como se calcula en los juegos
        String tipoAtaque = ataqueUsado.getElemento().getNombre();

        double efectividad = 1.0;
        for (Elemento elemDef : defensor.getElementos()) {
            if (elemDef != null) {
                efectividad *= obtenerEfectividad(tipoAtaque, elemDef.getDebilidades(), elemDef.getFortalezas());
            }
        }
        daño *= efectividad;
        
        if (esCritico() == true){
            daño *= 2;
        }

        daño *= (0.85 + Math.random() * 0.15); //en los juegos hay un elemento aleatorio de potencia en cada ataque
        //fue la formula mas parecida que encontre a la del juego

        return (int) daño; //reconvierte a int
    }

    public Pokemon compararVelocidades(Pokemon poke1, Pokemon poke2){
        if(poke1.getStats().getSPD() > poke2.getStats().getSPD()){
            return poke1;
        }else if (poke1.getStats().getSPD() < poke2.getStats().getSPD()){
            return poke2;
        }
        return poke1;
    }

    public void cicloBatalla(Entrenador jugador, Entrenador npc){
        Pokemon poke1 = jugador.getPokemones()[0]; //pokemon activo
        Pokemon poke2 = npc.getPokemones()[0]; 
        boolean enCombate = true;

        while(enCombate = true){
            System.out.println(compararVelocidades(poke1, poke2));
        }
    }
}
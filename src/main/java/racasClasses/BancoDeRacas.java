
package racasClasses;

import java.util.HashMap;
import java.util.Map;


public final class BancoDeRacas {
    public static Map<Integer, Raca> mapRacas = new HashMap<>();
    //alterar pra protected -> mudar para o package do Menu
    
    public BancoDeRacas() {
        BancoDeRacas.mapRacas.put(1, this.getElfo());
        BancoDeRacas.mapRacas.put(2, this.getAnao());
        BancoDeRacas.mapRacas.put(3, this.getMinotauro());
        BancoDeRacas.mapRacas.put(4, this.getGoblin());
    }
    
    public  Raca getElfo(){
        return new Raca("elfo", true, false, 0, 2, -2, 4, 0, 0);      
    }
    public Raca getAnao(){
        return new Raca("anao", false, true, 0, -2, 4, 0, 2, 0);
    }
    public Raca getMinotauro(){
        return new Raca("minotauro", false, false, 4, 0, 2, 0, -2, 0);
    }
    public Raca getGoblin(){
        return new Raca("goblin", false, false, 0, 4, 0, 2, 0, -2);
    }

    public static void ImprimeRacas(){
        System.out.println("RACAS:");
        System.out.println("Elfo");
        System.out.println("Anao");
        System.out.println("Minotauro");
        System.out.println("Goblin");
    }
    
   public static void EscolheRacas(){
       System.out.println("1- Elfo");
       System.out.println("Atributos: -2 em Constituição, +4 em inteligência, +2 em destreza ");
       System.out.println("Poderes: ");//ainda a acrescentar
       System.out.println(" ");
       System.out.println("2- Anao");
       System.out.println("Atributos: -2 em Destreza, +4 em Constituição,+2 em Sabedoria");
       System.out.println("Poderes: ");//ainda a acrescentar
       System.out.println(" ");
       System.out.println("3- Minotauro");
       System.out.println("Atributos: -2 em Sabedoria, +4 em Força,+2 em Constituição");
       System.out.println("Poderes: ");//ainda a acrescentar
       System.out.println(" ");
       System.out.println("4- Anao");
       System.out.println("Atributos: -2 em Carisma, +4 em Destreza,+2 em Inteligência");
       System.out.println("Poderes: ");//ainda a acrescentar
       System.out.println(" ");
   }
}

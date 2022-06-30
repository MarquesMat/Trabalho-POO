
package racasClasses;


public class BancoDeRacas {
        
        
        public static Raca getElfo(){
        return new Raca("elfo", true, false);
        
        }
        public static Raca getAnao(){
            return new Raca("anao", false, true);
        }
        public static Raca getMinotauro(){
            return new Raca("minotauro", false, false);
        }
        public static Raca getGoblin(){
            return new Raca("goblin", false, false);
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


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
        
        System.out.println("1 - Elfo(-2 CON, +4 INT, +2 DES)");
        System.out.println("2 - Anao(+4 CON, +2 SAB, -2 DES)");
        System.out.println("3 - Minotauro(+4 FOR, +2 CON, -2 SAB)");
        System.out.println("4 - Goblin(+4 DES, +2 INT, -2 CAR)");
    }
       
}

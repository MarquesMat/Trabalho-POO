
package racasClasses;


public class BancoDeClasses {
    public static Classe getGuerreiro(){
        return new Classe("guerreiro", 20, 5, 3, true, true, true);
}
    public static Classe getBruxo(){
        return new Classe("bruxo", 8, 2, 6, false, false, false);
    }
    public static Classe getClerigo(){
        return new Classe("clerigo", 16, 4, 5, true, true, false);
    }
    
    public static Classe getCacador(){
        return new Classe("cacador", 16, 4, 4, false, true, true);
    }
    public static void ImprimeClasses(){
        System.out.println("CLASSES:");
        System.out.println("1 - Guerreiro(20 de pv, +5pv por nivel, 3 de mana por nivel)");
        System.out.println("2 - Bruxo(8 de pv, +2pv por nivel, 6 de mana por nivel)");
        System.out.println("3 - Clerigo(16 de pv, +4pv por nivel, 5 de mana por nivel)");
        System.out.println("4 - Cacador(16 de pv, +4pv por nivel, 4 de mana por nivel");
    }

    
}

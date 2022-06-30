
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
        System.out.println("Guerreiro");
        System.out.println("Bruxo");
        System.out.println("Clerigo");
        System.out.println("Cacador");
    }

    public static void EscolheClasses(){
        System.out.println("1 - Guerreiro");
        System.out.println("Status: 20 de pontos de vida base, + 5 pontos de vida por nível, 3 pontos de mana por nível");
        System.out.println("");
        System.out.println("2 - Bruxo");
        System.out.println("Status: 8 de pontos de vida base, + 2 pontos de vida por nível, 6 pontos de mana por nível");
        System.out.println("");
        System.out.println("3- Clerigo");
        System.out.println("Status: 16 de pontos de vida base, + 4 pontos de vida por nível, 5 pontos de mana por nível");
        System.out.println("");
        System.out.println("4- Cacador");
        System.out.println("Status: 16 de pontos de vida base, + 4 pontos de vida por nível, 4 pontos de mana por nível");
        System.out.println("");
    }
}

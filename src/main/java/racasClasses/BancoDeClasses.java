
package racasClasses;

import ficha.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public final class BancoDeClasses {
    public static Map<Integer, Classe> mapClasses = new HashMap<>();
    //alterar pra protected -> mudar para o package do Menu
    
    public BancoDeClasses() {
        BancoDeClasses.mapClasses.put(1, this.getGuerreiro());
        BancoDeClasses.mapClasses.put(2, this.getBruxo());
        BancoDeClasses.mapClasses.put(3, this.getClerigo());
        BancoDeClasses.mapClasses.put(4, this.getCacador());
    }
    
    public Classe getGuerreiro(){
        return new Classe("guerreiro", 20, 5, 3, true, true, true);
    }
    public Classe getBruxo(){
        return new Classe("bruxo", 8, 2, 6, false, false, false);
    }
    public Classe getClerigo(){
        return new Classe("clerigo", 16, 4, 5, true, true, false);
    }
    public Classe getCacador(){
        return new Classe("cacador", 16, 4, 4, false, true, true);
    }
    
    public static void ImprimeClasses(){
        System.out.println("CLASSES:");
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
    
     public static void Confere(){
        Scanner teclado = new Scanner(System.in);
        int confere;
        System.out.println("Voce confirma?");
        System.out.println("1 - Sim");
        System.out.println("2 - Escolher outra classe");
        confere = teclado.nextInt();

        switch(confere){
            case 1 -> {}
            case 2 -> { EscolheClasses(); }
            default -> { System.out.println("Esta opcao e invalida. Escolha outra opcao.\n"); Confere(); }
        }
  }

    public static void EscolheClasses(){
        Scanner teclado = new Scanner(System.in);
        ImprimeClasses();
        System.out.println("5 - Voltar para o menu.\n");
        System.out.print("ESCOLHA SUA CLASSE: ");
        
        int op;
        op = teclado.nextInt();
        
        switch(op){
            case 1 -> {
                System.out.println("Voce escolheu a opcao 1.");
                System.out.println("Sua classe e: GUERREIRO.\n");
                Confere();
            }
            case 2 -> {
                System.out.println("Voce escolheu a opcao 2.");
                System.out.println("Sua classe e: BRUXO.\n");
                Confere();

            }
            case 3 -> {
                System.out.println("Voce escolheu a opcao 3.");
                System.out.println("Sua classe e: CLERIGO.\n");
                Confere();

            }
            case 4 -> {
                System.out.println("Voce escolheu a opcao 4.");
                System.out.println("Sua classe e: CACADOR.\n");
                Confere();

            }
            
            case 5 -> { }
            
            default -> {
                System.out.println("Esta nao é uma opcao valida. Escolha outra opcao.\n");
                EscolheClasses();
            }
        }
        
    }
}

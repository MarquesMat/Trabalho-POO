package racasClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public final class BancoDeClasses {
    public static Map<Integer, Classe> mapClasses = new HashMap<>();
    
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
        System.out.println("\nCLASSES:");
        System.out.println("1 - Guerreiro");
        System.out.println("Status: 20 de pontos de vida base, + 5 pontos de vida por nível, 3 pontos de mana por nível");
        System.out.println("\n2 - Bruxo");
        System.out.println("Status: 8 de pontos de vida base, + 2 pontos de vida por nível, 6 pontos de mana por nível");
        System.out.println("\n3- Clerigo");
        System.out.println("Status: 16 de pontos de vida base, + 4 pontos de vida por nível, 5 pontos de mana por nível");
        System.out.println("\n4- Cacador");
        System.out.println("Status: 16 de pontos de vida base, + 4 pontos de vida por nível, 4 pontos de mana por nível");
    }
    
    public static void ImprimeClassesSimples(){
        System.out.println("\nCLASSES:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Bruxo");
        System.out.println("3- Clerigo");
        System.out.println("4- Cacador");
    }
    
    public static boolean Confere(){
        Scanner teclado = new Scanner(System.in);
        int confere;
        System.out.println("Voce confirma?");
        System.out.println("1 - Sim");
        System.out.println("2 - Escolher outra classe");
        confere = teclado.nextInt();

        while(true){
            switch(confere){
                case 1 -> { 
                    System.out.println("Sua classe foi escolhida.\n");
                    return true;
                }
                case 2 -> {
                    return false;
                }
                default -> {
                    System.out.println("Esta opcao eh invalida.\nEscolha SIM(1) ou NAO (2): ");
                    confere = teclado.nextInt();
                }
            }
        }
    }

    public static int EscolheClasses(){
        Scanner teclado = new Scanner(System.in);
        ImprimeClassesSimples();
        System.out.println("5 - Voltar para o menu\n");
        System.out.print("ESCOLHA SUA CLASSE: ");
        int op = teclado.nextInt();
        if(op > 0 && op <5) {
            System.out.printf("Voce escolheu a opcao %d.", op);
            System.out.printf("\nSua classe eh: %s.\n", mapClasses.get(op).nome);
            if(Confere()) return op;
            return EscolheClasses();
        } else if(op == 5) {
            System.out.println("\nVoltando para o menu...");
            return 0;
        } else {
            System.out.println("Esta nao eh uma opcao valida. Escolha outra opcao.\n");
            return EscolheClasses();
        }
    }
}

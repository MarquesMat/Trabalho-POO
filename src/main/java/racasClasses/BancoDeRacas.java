package racasClasses;

import conferir.Conferir;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public final class BancoDeRacas implements Conferir {
    public static Map<Integer, Raca> mapRacas = new HashMap<>();
    
    public BancoDeRacas() {
        BancoDeRacas.mapRacas.put(1, this.getElfo());
        BancoDeRacas.mapRacas.put(2, this.getAnao());
        BancoDeRacas.mapRacas.put(3, this.getMinotauro());
        BancoDeRacas.mapRacas.put(4, this.getGoblin());
    }
    
    public  Raca getElfo(){
        return new Raca("elfo", 1, true, false, 0, 2, -2, 4, 0, 0);      
    }
    public Raca getAnao(){
        return new Raca("anao", 2, false, true, 0, -2, 4, 0, 2, 0);
    }
    public Raca getMinotauro(){
        return new Raca("minotauro", 3, false, false, 4, 0, 2, 0, -2, 0);
    }
    public Raca getGoblin(){
        return new Raca("goblin", 4, false, false, 0, 4, 0, 2, 0, -2);
    }

    public static void ImprimeRacas(){
       System.out.println("\nRACAS:");
       System.out.println("1- Elfo");
       System.out.println("Atributos: -2 em Constituição, +4 em inteligência, +2 em destreza ");
       System.out.println("Poder: Rapido como o vento: ganhe mais 2 quadrados de deslocamento e mais um ponto de mana.");
       System.out.println("\n2- Anao");
       System.out.println("Atributos: -2 em Destreza, +4 em Constituição,+2 em Sabedoria");
       System.out.println("Poder: Devagar e sempre: perca 2 quadrados de deslocamento, mas ganhe mais 3 pontos de vida e ignore penalidades de armaduras.");
       System.out.println("\n3- Minotauro");
       System.out.println("Atributos: -2 em Sabedoria, +4 em Força,+2 em Constituição");
       System.out.println("Poder: Couro duro: ganhe um bonus de +1 na Defesa.");
       System.out.println("\n4- Goblin");
       System.out.println("Atributos: -2 em Carisma, +4 em Destreza,+2 em Inteligência");
       System.out.println("Poder: Peste esguia: ganhe um bonus de +1 no Ataque.");
    }
    
    public static void ImprimeRacasSimples(){
       System.out.println("\nRACAS:");
       System.out.println("1- Elfo");
       System.out.println("2- Anao");
       System.out.println("3- Minotauro");
       System.out.println("4- Goblin");
    }
        
   public static int EscolheRacas(){
        int op = 0;
        // tratamento de exceção InputMismatchException:
        try{
                Scanner teclado = new Scanner(System.in);
                ImprimeRacasSimples();
                System.out.println("5 - Voltar para o menu.\n");
                System.out.print("ESCOLHA SUA RACA: ");
                op = teclado.nextInt();
                
        }catch(InputMismatchException e){}
        
        if(op > 0 && op < 5) {
            System.out.printf("Voce escolheu a opcao %d.", op);
            System.out.printf("\nSua raca eh: %s.\n", BancoDeRacas.mapRacas.get(op).nome);
            if(Conferir.Confere()){ return op;}
            else return EscolheRacas();
        } else if(op == 5) {
            System.out.println("Voltando para o menu...");
            return 0;
        } else {
            System.out.println("Opcao invalida. Por favor, digite uma opcao valida.");
            return EscolheRacas();
        }
    }
}


package racasClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import ficha.Menu;

public final class BancoDeRacas {
    public static Map<Integer, Raca> mapRacas = new HashMap<>();
    //alterar pra protected -> mudar para o package do Menu
    
    public BancoDeRacas() {
        BancoDeRacas.mapRacas.put(1, this.getElfo());
        BancoDeRacas.mapRacas.put(2, this.getAnao());
        BancoDeRacas.mapRacas.put(3, this.getMinotauro());
        BancoDeRacas.mapRacas.put(4, this.getGoblin());
    }
    
    public Raca getElfo(){
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
       System.out.println("4- Goblin");
       System.out.println("Atributos: -2 em Carisma, +4 em Destreza,+2 em Inteligência");
       System.out.println("Poderes: ");//ainda a acrescentar
       System.out.println(" ");
    }
    
  public static void Confere(){
      Scanner teclado = new Scanner(System.in);
      int confere;
      System.out.println("Voce confirma?");
      System.out.println("1 - Sim");
      System.out.println("2 - Escolher outra raca");
      confere = teclado.nextInt();
      
      switch(confere){
          case 1 -> {}
          case 2 -> { EscolheRacas(); }
          default -> { System.out.println("Esta opcao e invalida. Escolha outra opcao.\n"); Confere(); }
      }
      
  }
    
   public static void EscolheRacas(){
        Scanner teclado = new Scanner(System.in);
        ImprimeRacas();
        System.out.println("5 - Voltar para o menu.\n");
        System.out.print("ESCOLHA SUA RACA: ");
        
        int op;
        op = teclado.nextInt();
        
        switch(op){
            case 1 -> {
                System.out.println("Voce escolheu a opcao 1.");
                System.out.println("Sua raca e: ELFO.\n");
                Confere();
              
            }
            case 2 -> {
                System.out.println("Voce escolheu a opcao 2.");
                System.out.println("Sua raca e: ANAO.\n");
                Confere();
            }
            case 3 -> {
                System.out.println("Voce escolheu a opcao 3.");
                System.out.println("Sua raca e: MINOTAURO.\n");
                Confere();
            }
            case 4 -> {
                System.out.println("Voce escolheu a opcao 4.");
                System.out.println("Sua raca e: GOBLIN.\n");
                Confere();
            }
            
            case 5 ->{ }
            
            default -> {
                System.out.println("Esta opcao e invalida. Escolha outra opcao.\n");
                EscolheRacas();
                
            }
        }
        
    }
   }


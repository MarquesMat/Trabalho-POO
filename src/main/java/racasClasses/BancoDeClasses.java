package racasClasses;

import conferir.Conferir;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public final class BancoDeClasses implements Conferir {
    public static Map<Integer, Classe> mapClasses = new HashMap<>();
    
    public BancoDeClasses() {
        BancoDeClasses.mapClasses.put(1, this.getGuerreiro());
        BancoDeClasses.mapClasses.put(2, this.getBruxo());
        BancoDeClasses.mapClasses.put(3, this.getClerigo());
        BancoDeClasses.mapClasses.put(4, this.getCacador());
    }
    
    public Classe getGuerreiro(){
        return new Classe("guerreiro", 5, 1, 20, 5, 3, true, true, true);
    }
    public Classe getBruxo(){
        return new Classe("bruxo", 6, 5, 8, 2, 6, false, false, false);
    }
    public Classe getClerigo(){
        return new Classe("clerigo", 7, 3, 16, 4, 5, true, true, false);
    }
    public Classe getCacador(){
        return new Classe("cacador", 8, 3, 16, 4, 4, false, true, true);
    }
    
    public static void ImprimeClasses(){
        System.out.println("\nCLASSES:");
        System.out.println("1 - Guerreiro");
        System.out.println("Status: 20 de pontos de vida base, + 5 pontos de vida por nível, 3 pontos de mana por nível");
        System.out.println("Poder: Ataque especial: Ganhe +4 no proximo ataque. (1 PM)");
        System.out.println("\n2 - Bruxo");
        System.out.println("Status: 8 de pontos de vida base, + 2 pontos de vida por nível, 6 pontos de mana por nível");
        System.out.println("Poder: Bola de fogo: Cause 3d6 pontos de dano. (5 PM)");
        System.out.println("\n3- Clerigo");
        System.out.println("Status: 16 de pontos de vida base, + 4 pontos de vida por nível, 5 pontos de mana por nível");
        System.out.println("Poder: Curar ferimentos: Ganhe 2d8 PV. (3 PM)");
        System.out.println("\n4- Cacador");
        System.out.println("Status: 16 de pontos de vida base, + 4 pontos de vida por nível, 4 pontos de mana por nível");
        System.out.println("Poder: Marca do cacador: Aumente a margem de critico em 2. (3 PM)");
    }
    
    public static void ImprimeClassesSimples(){
        System.out.println("\nCLASSES:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Bruxo");
        System.out.println("3- Clerigo");
        System.out.println("4- Cacador");
    }
    
    public static int EscolheClasses(){
        int op = 0;
        // tratamento de exceção InputMismatchException:
        try{
                Scanner teclado = new Scanner(System.in);
                ImprimeClassesSimples();
                System.out.println("5 - Voltar para o menu.\n");
                System.out.print("ESCOLHA SUA CLASSE: ");
                op = teclado.nextInt();
                
        }catch(InputMismatchException e){}
        
        if(op > 0 && op <5) {
            System.out.printf("Voce escolheu a opcao %d.", op);
            System.out.printf("\nSua classe eh: %s.\n", mapClasses.get(op).nome);
            if(Conferir.Confere()) return op;
            return EscolheClasses();
        } else if(op == 5) {
            System.out.println("\nVoltando para o menu...");
            return 0;
        } else {
            System.out.println("Opcao invalida. Por favor, digite uma opcao valida.");
            return EscolheClasses();
        }
    }
}

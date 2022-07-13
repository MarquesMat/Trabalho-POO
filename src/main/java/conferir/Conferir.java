package conferir;

import static ficha.Menu.menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface Conferir {
    public static boolean Confere(){
        
        while(true){
            int confere;
            // tratamento de exceção InputMismatchException:
             try{
                Scanner teclado = new Scanner(System.in);
                System.out.println("Voce confirma?");
                System.out.println("1 - Sim");
                System.out.println("2 - Escolher outra opcao");
                confere = teclado.nextInt();
                
             }catch(InputMismatchException e){
                System.out.println("Opcao invalida. Por favor, digite uma opcao valida.");
                continue;}
        
            switch(confere){
                case 1 -> { 
                    System.out.println("Sua opcao foi confirmada.\n");
                    return true;
                }
                case 2 -> {
                    return false;
                }
                default -> {
                    System.out.println("Opcao invalida. Por favor, digite uma opcao valida.");
                    
                }
            }
        }
    }
}

package conferir;

import java.util.Scanner;

public interface Conferir {
    public static boolean Confere(){
        Scanner teclado = new Scanner(System.in);
        int confere;
        System.out.println("Voce confirma?");
        System.out.println("1 - Sim");
        System.out.println("2 - Escolher outra opcao");
        confere = teclado.nextInt();

        while(true){
            switch(confere){
                case 1 -> { 
                    System.out.println("Sua opcao foi confirmada.\n");
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
}

package ficha;
import java.util.Scanner;

import racasClasses.*;

public class Menu {
    
    public static void menu() {
        //opções de imprimir classes raças e escolher 
        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Imprimir Racas");
        System.out.println("2 - Imprimir Classes");
        System.out.println("3 - Escolher Raca");
        System.out.println("4 - Escolher Classe");
        System.out.println("5 - Rolar Dados");
        System.out.println("6 - Fechar");
    }
    
    
    
    public static void exec() {
        System.out.println("----- Bem Vindo(a) ao menu -----");
        Scanner teclado = new Scanner(System.in);
        
        
        int op, a;    
        do{
            menu();
            op = teclado.nextInt();
            
            switch(op){
                case  1 -> { 
                    BancoDeRacas.ImprimeRacas();
                }
                case 2 -> {
                    BancoDeClasses.ImprimeClasses();
          
                } 
                case 3 -> {
                    System.out.println("ESCOLHA SUA RACA:");
                    BancoDeRacas.EscolheRacas();
                    
                   
                    
                    
                    
                }
                case 4 -> {
                    System.out.println("ESCOLHA SUA CLASSE:");
                    BancoDeClasses.EscolheClasses();
                    
                    
                    
                }
                
                case 5 ->{
                    Dados.execut();
                }
                
            } 
           
        }while(op != 6 );
                  
    }
}

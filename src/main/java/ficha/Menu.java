package ficha;
import equipamentos.BancoDeArmaduras;
import equipamentos.BancoDeArmas;
import java.util.Scanner;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;

import racasClasses.*;

public class Menu {
    
    public static void menu() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Imprimir Racas");
        System.out.println("2 - Imprimir Classes");
        System.out.println("3 - Escolher Raca");
        System.out.println("4 - Escolher Classe");
        System.out.println("5 - Rolar Dados");
        System.out.println("6 - Fechar");
    }
    
    public static void equipamentos() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Imprimir Armas");
        System.out.println("2 - Imprimir Armaduras");
        System.out.println("3 - Escolher Arma");
        System.out.println("4 - Escolher Armadura");
        System.out.println("5 - Fechar");
    }
    
    public static void exec() {
        System.out.println("----- Bem Vindo(a) ao menu -----");
        Scanner teclado = new Scanner(System.in);
        int verifica[] = new int[3];
        for(int i=0; i<3; i++) verifica[i] = 0;
        int op, x;
        String nome;
        List numeros = new ArrayList<Integer>();
        do{
            menu();
            op = teclado.nextInt();
            switch(op){
                case 1 -> BancoDeRacas.ImprimeRacas();
                case 2 -> BancoDeClasses.ImprimeClasses();
                case 3 -> {
                    x = BancoDeRacas.EscolheRacas();
                    if(x != 0) {
                        Personagem.setRaca(BancoDeRacas.mapRacas.get(x));
                        verifica[0] = 1;
                    }
                }
                case 4 -> {
                    x = BancoDeClasses.EscolheClasses();
                    if(x != 0) {
                        Personagem.setClasse(BancoDeClasses.mapClasses.get(x));
                        verifica[1] = 1;
                    }
                }
                case 5 -> {
                    if(verifica[2] == 0) {
                        numeros = Dados.execut();
                        verifica[2] = 1;
                    } else {
                        Dados.definirAtributos(numeros);
                    }
                    
                }
                case 6 -> {
                    op = 0;
                    if(verifica[0] == 0) System.out.println("\nOpa! Voce precisa escolher uma raca antes de continuar.");
                    else if(verifica[1] == 0) System.out.println("\nOpa! Voce precisa escolher uma classe antes de continuar.");
                    else if(verifica[2] == 0) System.out.println("\nOpa! Voce precisa rolar os dados antes de continuar.");
                    else op = 6;
                }
                default ->{
                    System.out.println("Esta não é uma opção válida. Escolha outra opcao");
                }       
            }
        }while(op != 6 );
        teclado.nextLine();
        System.out.println("\n\n---Muito bem! Agora, vamos para a parte mais dificil: a escolha de um nome!---");
        System.out.print("\nDigite o nome do seu presonagem: ");
        nome = teclado.nextLine();
        Personagem.setNome(nome);
    }
    
    public static void exec2() {
        System.out.println("\n\n---Voce esta quase pronto para o combate, mas o caminho é muito perigoso, não vá sem escolher os equipamentos adequados!---");
        Scanner teclado = new Scanner(System.in);
        int verifica[] = new int[2];
        for(int i=0; i<2; i++) verifica[i] = 0;
        int op, x;
        do {
            equipamentos();
            op = teclado.nextInt();
            switch(op) {
                case 1 -> BancoDeArmas.ImprimeArmas();
                case 2 -> BancoDeArmaduras.ImprimeArmaduras();
                case 3 -> {
                    x = BancoDeArmas.EscolheArmas(Personagem.getClasse().getArmasMarcias());
                    if(x != 0) {
                        Personagem.setArma(BancoDeArmas.mapArmas.get(x));
                        verifica[0] = 1;
                    }
                }
                case 4 -> {
                    if(!Personagem.getClasse().getArmLeve()){
                        System.out.println("\n---Arcanistas não podem vestir armaduras---\n");
                        Personagem.setArmadura(null);
                        verifica[1] = 1;
                    } else {
                        x = BancoDeArmaduras.EscolheArmaduras(Personagem.getClasse().getArmPesada());
                        if(x != 0) {
                            Personagem.setArmadura(BancoDeArmaduras.mapArmaduras.get(x));
                            verifica[1] = 1;
                        }
                    }
                }
                case 5 -> {
                    op = 0;
                    if(verifica[0] == 0) System.out.println("\nOpa! Voce precisa escolher uma arma antes de continuar.");
                    else if(verifica[1] == 0) System.out.println("\nOpa! Voce precisa escolher uma armadura antes de continuar.");
                    else op = 5;
                }
                default ->{
                    System.out.println("\nEsta não é uma opção válida. Escolha outra opcao");
                } 
            }
        }while(op != 5);
    }
}
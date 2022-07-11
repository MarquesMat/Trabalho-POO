package equipamentos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class BancoDeArmaduras {
    public static Map<Integer, Armaduras> mapArmaduras = new HashMap<>();
    
    public BancoDeArmaduras() {
        BancoDeArmaduras.mapArmaduras.put(1, this.getArmaduraLeve1());
        BancoDeArmaduras.mapArmaduras.put(2, this.getArmaduraLeve2());
        BancoDeArmaduras.mapArmaduras.put(3, this.getArmaduraPesada());
    }
    
    public Armaduras getArmaduraLeve1(){
        return new Armaduras(1,0,"Corselete de couro", false);
    }
    public Armaduras getArmaduraLeve2(){
        return new Armaduras(2,-1,"Couro batido", false);
    }
    public Armaduras getArmaduraPesada(){
        return new Armaduras(5,-3,"Gibao de peles", true);
    }
    
    public static void ImprimeArmadurasSimples(boolean pesada){
        System.out.println("\nARMADURAS:");
        System.out.println("1 - Corselete de couro");
        System.out.println("2 - Couro batido");
        System.out.println("3- Gibao de peles");
        if(!pesada) System.out.println("(Incompativel com sua classe)\n");        
    }
    
    public static boolean Confere(){
        Scanner teclado = new Scanner(System.in);
        int confere;
        System.out.println("Voce confirma?");
        System.out.println("1 - Sim");
        System.out.println("2 - Escolher outra armadura");
        confere = teclado.nextInt();

        while(true){
            switch(confere){
                case 1 -> { 
                    System.out.println("Sua armadura foi escolhida.\n");
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

    public static int EscolheArmaduras(boolean pesada){
        Scanner teclado = new Scanner(System.in);
        ImprimeArmadurasSimples(pesada);
        System.out.println("4 - Voltar para o menu\n");
        System.out.print("ESCOLHA SUA ARMADURA: ");
        int op = teclado.nextInt();
        if(op > 0 && op <5) {
            System.out.printf("Voce escolheu a opcao %d.", op);
            System.out.printf("\nSua armadura eh: %s.\n", mapArmaduras.get(op).getNome());
            if(Confere()) return op;
            return EscolheArmaduras(pesada);
        } else if(op == 5) {
            System.out.println("\nVoltando para o menu...");
            return 0;
        } else {
            System.out.println("Esta nao eh uma opcao valida. Escolha outra opcao.\n");
            return EscolheArmaduras(pesada);
        }
    }
}

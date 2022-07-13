package equipamentos;

import conferir.Conferir;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class BancoDeArmaduras implements Conferir {
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
    
    public static void ImprimeArmaduras(){
        System.out.println("\nARMADURAS:");
        System.out.println("1 - Corselete de couro");
        System.out.println("Status: +1 Defesa, 0 penalidade, armadura leve\n");
        System.out.println("2 - Couro batido");
        System.out.println("Status: +2 Defesa, -1 penalidade, armadura leve\n");
        System.out.println("3- Gibao de peles");
        System.out.println("Status: +5 Defesa, -3 penalidade, armadura pesada\n");
    }
    
    public static void ImprimeArmadurasSimples(boolean pesada){
        System.out.println("\nARMADURAS:");
        System.out.println("1 - Corselete de couro");
        System.out.println("2 - Couro batido");
        System.out.println("3- Gibao de peles");
        if(!pesada) System.out.println("(Incompativel com sua classe)\n");        
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
            if(Conferir.Confere()) return op;
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

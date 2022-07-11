package equipamentos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class BancoDeArmas {
    public static Map<Integer, Armas> mapArmas = new HashMap<>();
    
    public BancoDeArmas() {
        BancoDeArmas.mapArmas.put(1, this.getEspadaCurta());
        BancoDeArmas.mapArmas.put(2, this.getMachado());
        BancoDeArmas.mapArmas.put(3, this.getArcoCurto());
        BancoDeArmas.mapArmas.put(4, this.getArcoLongo());
    }
    
    public Armas getEspadaCurta(){
        return new Armas(6, 19, 2, 2, "Espada curta", "Simples");
    }
    public Armas getMachado(){
        return new Armas(8, 20, 3, 1, "Machado", "Marcial");
    }
    public Armas getArcoCurto(){
        return new Armas(6, 20, 3, 2, "Arco curto", "Simples");
    }
    public Armas getArcoLongo(){
        return new Armas(8, 20, 3, 2, "Arco longo", "Marcial");
    }
    
    public static void ImprimeArmadurasSimples(boolean marcial){
        System.out.println("\nCLASSES:");
        System.out.println("1 - Espada curta");
        System.out.println("2 - Machado");
        if(!marcial) System.out.println("(Incompativel com sua classe)");
        System.out.println("3 - Arco curto");
        System.out.println("4 - Arco longo");
        if(!marcial) System.out.println("(Incompativel com sua classe)");
    }
    
    public static boolean Confere(){
        Scanner teclado = new Scanner(System.in);
        int confere;
        System.out.println("Voce confirma?");
        System.out.println("1 - Sim");
        System.out.println("2 - Escolher outra arma");
        confere = teclado.nextInt();

        while(true){
            switch(confere){
                case 1 -> { 
                    System.out.println("Sua arma foi escolhida.\n");
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

    public static int EscolheArmas(boolean marcial){
        Scanner teclado = new Scanner(System.in);
        ImprimeArmadurasSimples(marcial);
        System.out.println("5 - Voltar para o menu\n");
        System.out.print("ESCOLHA SUA ARMA: ");
        int op = teclado.nextInt();
        if(op > 0 && op <5) {
            System.out.printf("Voce escolheu a opcao %d.", op);
            if(!marcial && mapArmas.get(op).getTipo().equals("Marcial")) System.out.println("Incompativel com sua classe");
            else {
                System.out.printf("\nSua armadura eh: %s.\n", mapArmas.get(op).getNome());
                if(Confere()) return op;
            }
            return EscolheArmas(marcial);
        } else if(op == 5) {
            System.out.println("\nVoltando para o menu...");
            return 0;
        } else {
            System.out.println("Esta nao eh uma opcao valida. Escolha outra opcao.\n");
            return EscolheArmas(marcial);
        }
    }
}
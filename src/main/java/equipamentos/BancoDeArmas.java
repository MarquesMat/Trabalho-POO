package equipamentos;

import conferir.Conferir;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public final class BancoDeArmas implements Conferir {
    public static Map<Integer, Armas> mapArmas = new HashMap<>();
    
    public BancoDeArmas() {
        BancoDeArmas.mapArmas.put(1, this.getEspadaCurta());
        BancoDeArmas.mapArmas.put(2, this.getMachado());
        BancoDeArmas.mapArmas.put(3, this.getArcoCurto());
        BancoDeArmas.mapArmas.put(4, this.getArcoLongo());
    }
    
    public Armas getEspadaCurta(){
        return new Armas(6, 19, 2, 1, "Espada curta", "Simples");
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
    
    public static void ImprimeArmas() {
        System.out.println("\nARMAS:");
        System.out.println("1 - Espada curta");
        System.out.println("Status: dano D6, critico 19-20 (x2), corpo a corpo\n");
        System.out.println("2 - Machado");
        System.out.println("Status: dano D8, critico 20 (x3), corpo a corpo\n");
        System.out.println("3 - Arco curto");
        System.out.println("Status: dano D6, critico 20 (x3), alcance\n");
        System.out.println("4 - Arco longo");
        System.out.println("Status: dano D8, critico 20 (x3), alcance\n");
    }
    
    public static void ImprimeArmasSimples(boolean marcial){
        System.out.println("\nARMAS:");
        System.out.println("1 - Espada curta");
        System.out.println("2 - Machado");
        if(!marcial) System.out.println("(Incompativel com sua classe)");
        System.out.println("3 - Arco curto");
        System.out.println("4 - Arco longo");
        if(!marcial) System.out.println("(Incompativel com sua classe)");
    }
    
    public static int EscolheArmas(boolean marcial){
        
        int op = 0;
        // tratamento de exceção InputMismatchException:
        try{
                Scanner teclado = new Scanner(System.in);
                ImprimeArmasSimples(marcial);
                System.out.println("5 - Voltar para o menu\n");
                System.out.print("ESCOLHA SUA ARMA: ");
                op = teclado.nextInt();
                
        }catch(InputMismatchException e){}
       
        if(op > 0 && op <5) {
            System.out.printf("Voce escolheu a opcao %d.", op);
            if(!marcial && mapArmas.get(op).getTipo().equals("Marcial")) System.out.println("Incompativel com sua classe");
            else {
                System.out.printf("\nSua arma eh: %s.\n", mapArmas.get(op).getNome());
                if(Conferir.Confere()) return op;
            }
            return EscolheArmas(marcial);
        } else if(op == 5) {
            System.out.println("\nVoltando para o menu...");
            return 0;
        } else {
            System.out.println("Opcao invalida. Por favor, digite uma opcao valida.");
            return EscolheArmas(marcial);
        }
    }
}

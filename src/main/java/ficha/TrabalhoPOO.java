package ficha;

import racasClasses.BancoDeClasses;
import racasClasses.BancoDeRacas;
import equipamentos.BancoDeArmaduras;
import equipamentos.BancoDeArmas;
import java.util.Scanner;

public class TrabalhoPOO {
    public static void imprimirFichaProvisoria() {
        System.out.println("Nome: "+Personagem.getNome());
        System.out.println("Raca: "+Personagem.getRaca().getNome());
        System.out.println("Classe: "+Personagem.getClasse().getNome());
        Personagem.atributos.imprimeAtributos();
    }
    
    public static void imprimirFicha() {
        System.out.println("\n\nNome: "+Personagem.getNome());
        System.out.println("\n\nPv: "+Personagem.getPv());
        System.out.println("\n\nMana: "+Personagem.getMana());
        System.out.println("Raca: "+Personagem.getRaca().getNome());
        System.out.println("Classe: "+Personagem.getClasse().getNome());
        System.out.println("Nivel: "+Personagem.getNivel());
        Personagem.atributos.imprimeAtributos();
        System.out.println("\nDefesa: "+Personagem.getDefesa());
        System.out.println("Deslocamento: "+Personagem.getDeslocamento());
        
    }
    public static int escolherOpcoes(){
        Scanner in = new Scanner(System.in);
        int op = 0;
        System.out.println("--Escolha uma opção--");
        System.out.println("1- Ataque");
        System.out.println("2 - Magia");
        
        op = in.nextInt();
        if (op == 1 || op == 2){
        return op;
        }
        else{
            System.out.println("Opcao invalida");
            escolherOpcoes();
        }
        return 0;
    }
    public static int escolherMagiaB(){
        Scanner in = new Scanner(System.in);
        int op = 0;
        System.out.println("--Escolha uma opção--");
        System.out.println("1- Lanca Chamas(Dois dados d6 de dano)");
        System.out.println("2 - Armadura Arcana (+5 def)");
        System.out.println("3 - Enfraquecer (-2 em forca)");
        op = in.nextInt();
        if (op == 1 || op == 2){
        return op;
        }
        else{
            System.out.println("Opcao invalida");
            escolherMagiaB();
        }
        return 0;
    }
    
    public static int escolherMagiaC(){
        Scanner in = new Scanner(System.in);
        int op = 0;
        System.out.println("--Escolha uma opção--");
        System.out.println("1- Ferir(Dois dados d8 de dano)");
        System.out.println("2 - Escudo (+2 def)");
        System.out.println("3 - Curar (Dois dados d8 de vida)");
        op = in.nextInt();
        if (op == 1 || op == 2){
        return op;
        }
        else{
            System.out.println("Opcao invalida");
            escolherMagiaC();
        }
        return 0;
    }
    
    public static int acertoGolpe(){
        if(Personagem.getArma().getAlcance()==1){
            int acer =  Dados.rola20()+ Personagem.atributos.getModificador(0);
            return acer;
        }
        else if(Personagem.getArma().getAlcance()==2){
            int acer = Dados.rola20() + Personagem.atributos.getModificador(1);
            return acer;
        }
        return 0;
    }
    public static void Combate(){
        int PvDemonio = 20;
        int forc = 1;
        int des = 1;
        int cont = 1;
        int intl = 1;
        int sab = 1;
        int car = 1;
        int desl = 10;
        int def = 10;
        while(Personagem.getPv()>0 || PvDemonio >0){
            int vel1 = Dados.rola20()+ Personagem.getDeslocamento();
            int vel2 = Dados.rola20()+ desl;
            if (vel1 >= vel2 ){
                System.out.println("Seu turno");
                System.out.println(" ");
                int op = escolherOpcoes();
                
                if(op == 1){
                   if(acertoGolpe()>def) {
                       PvDemonio -= Dano();
                       System.out.println("O demonio esta com " + PvDemonio + " de vida");
                }
                   else{
                       System.out.println("O demonio bloqueou");
                   }
            }
                if(op == 2){
                    
                    if(("guerreiro".equals(Personagem.getClasse().getNome())) || ("cacador".equals(Personagem.getClasse().getNome()))){
                        System.out.println("Nao é possivel usar magia");
                        escolherOpcoes();
                    }
                    else {
                        System.out.println("--Selecione a magia--");
                        if("bruxo".equals(Personagem.getClasse().getNome())){
                            int opMagia = escolherMagiaB();
                            if (opMagia == 1 ){
                                if (Personagem.getMana()>=3){
                                PvDemonio = PvDemonio - Dados.rolaDado(6)- Dados.rolaDado(6);
                                Personagem.reduzMana(3);
                                System.out.println("O demonio esta com " + PvDemonio + " de vida");
                                System.out.println("Mana = "+ Personagem.getMana());
                                }
                                else{
                                    System.out.println("Sem mana");
                                    escolherOpcoes();
                                }
                            }
                            if (opMagia == 2){
                                if (Personagem.getMana()>=3){
                                Personagem.adcDefesa(5);
                                Personagem.reduzMana(3);
                                System.out.println("Voce recebeu mais 5 de defesa");
                                System.out.println("Mana = "+ Personagem.getMana());
                                }
                                else{
                                    System.out.println("Sem mana");
                                    escolherOpcoes();
                                }
                            }
                            if (opMagia == 3){
                                if (Personagem.getMana()>=2){
                                forc -=1;
                                Personagem.reduzMana(2);
                                System.out.println("O inimigo esta com menos 1 de forca");
                                System.out.println("Mana = "+ Personagem.getMana());
                                
                                }
                                else{
                                    System.out.println("Sem mana");
                                    escolherOpcoes();
                                }
                            }
                        }
                        else if("clerigo".equals(Personagem.getClasse().getNome())){
                            int opMagia = escolherMagiaC();
                            if (opMagia == 1){
                                if (Personagem.getMana()>=4){
                                PvDemonio = PvDemonio - Dados.rolaDado(8)- Dados.rolaDado(8);
                                System.out.println("O demonio esta com " + PvDemonio + " de vida");
                                Personagem.reduzMana(4);
                                System.out.println("Mana = "+ Personagem.getMana());
                                }
                                else{
                                    System.out.println("Sem mana");
                                    escolherOpcoes();
                                }
                            }
                            if (opMagia == 2){
                                if (Personagem.getMana()>=1){
                                Personagem.adcDefesa(2);
                                System.out.println("Voce recebeu mais 2 de defesa");
                                Personagem.reduzMana(1);
                                System.out.println("Mana = "+ Personagem.getMana());
                                }
                                else{
                                    System.out.println("Sem mana");
                                    escolherOpcoes();
                                }
                            }
                            if (opMagia == 3){
                                if (Personagem.getMana()>=5){
                                int cura = Dados.rolaDado(8)+ Dados.rolaDado(8);
                                Personagem.curar(cura);
                                System.out.println("Voce foi curado em " + cura + " pontos de vida");
                                Personagem.reduzMana(5);
                                System.out.println("Mana = "+ Personagem.getMana());
                                }
                                else{
                                    System.out.println("Sem mana");
                                    escolherOpcoes();
                                }
                                
                            }
                        }
                    }
                }
                
            
        }
            else{
                int crit = 1;
                System.out.println("Turno do demonio");
                int acerto = Dados.rola20() + forc;
                if(acerto > Personagem.getDefesa()){
                    int dado = Dados.rola20();
                    if (dado == 20){
                       crit = 2; 
                    }
                    int dano =  Dados.rolaDado(6) + forc * crit;
                    Personagem.dano(dano);
                    System.out.println("Voce esta com " + Personagem.getPv() + " de vida");
                }
                else{
                    System.out.println("Voce bloqueou o ataque");
                }
            }
            if (Personagem.getPv()<=0){
                System.out.println("Voce morreu");
                break;
               
            }
            if (PvDemonio<=0){
                System.out.println("Voce ganhou, parabens");
                break;
            }
    }
}

    public static int Dano(){
        int crit = 1;
        if(Dados.rola20()>=Personagem.getArma().getMargem()){
            crit = Personagem.getArma().getCritico();
        }
        if(Personagem.getArma().getAlcance()==1){
            int dano = Dados.rolaDado(Personagem.getArma().getDano())+Personagem.atributos.getModificador(0)*crit;
            return dano;
        }
        if(Personagem.getArma().getAlcance()==2){
            int dano = Dados.rolaDado(Personagem.getArma().getDano())*crit;
            return dano;
        }
        return 0;
    }
                
    
    public static void main(String[] args) {
        
        BancoDeRacas bancoDeRacas = new BancoDeRacas();
        BancoDeClasses bancoDeClasses = new BancoDeClasses();
        BancoDeArmaduras bancoDeArmaduras = new BancoDeArmaduras();
        BancoDeArmas bancoDeArmas = new BancoDeArmas();
        //os construtores preparam os dicionarios
        Personagem personagem = new Personagem();
        
        //Combate combate = new Combate(20,20);
        //caso queira fazer um teste, retire a chamada acima do comentário 
        
        Menu.exec();
        Personagem.atributos.setAtributosRaca(Personagem.getRaca().getAtributos());
        Personagem.atributos.setModificadores();
        imprimirFichaProvisoria();
        Menu.exec2();
        Personagem.equipar();
        personagem.setHp();
        personagem.setMana();
        imprimirFicha();
        System.out.println(Personagem.getClasse().getNome());
        Combate();                                           
    }
}

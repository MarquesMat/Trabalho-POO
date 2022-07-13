/*
package ficha;

import static ficha.TrabalhoPOO.Dano;
import static ficha.TrabalhoPOO.acertoGolpe;
import static ficha.TrabalhoPOO.escolherMagiaB;
import static ficha.TrabalhoPOO.escolherMagiaC;
import static ficha.TrabalhoPOO.escolherOpcoes;
        

public class Combate {
    private int PvDemonio = 20;
    private int forc = 1;
    private int des = 1;
    private int cont = 1;
    private int intl = 1;
    private int sab = 1;
    private    int car = 1;
    private int desl = 10;
        private int def = 10;
        
    public  void getCombate(){
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
                       System.out.println("O demonio esta com" + PvDemonio + "de vida");
                }
                   else{
                       System.out.println("O demonio bloqueou");
                   }
            }
                if(op == 2){
                    if(!"bruxo".equals(Personagem.getClasse().getNome()) || !"clerigo".equals(Personagem.getClasse().getNome())){
                        System.out.println("Nao é possivel usar magia");
                    }
                    else {
                        System.out.println("--Selecione a magia--");
                        if("bruxo".equals(Personagem.getClasse().getNome())){
                            int opMagia = escolherMagiaB();
                            if (opMagia == 1){
                                PvDemonio = PvDemonio - Dados.rolaDado(6)- Dados.rolaDado(6);
                                System.out.println("O demonio esta com" + PvDemonio + "de vida");
                            }
                            if (opMagia == 2){
                                Personagem.adcDefesa(5);
                                System.out.println("Voce recebeu mais 5 de defesa");
                            }
                            if (opMagia == 3){
                                forc -=1;
                                System.out.println("O inimigo esta com menos um de forca");
                            }
                        }
                        else if("clerigo".equals(Personagem.getClasse().getNome())){
                            int opMagia = escolherMagiaC();
                            if (opMagia == 1){
                                PvDemonio = PvDemonio - Dados.rolaDado(8)- Dados.rolaDado(8);
                                System.out.println("O demonio esta com" + PvDemonio + "de vida");
                            }
                            if (opMagia == 2){
                                Personagem.adcDefesa(2);
                                System.out.println("Voce recebeu mais 2 de defesa");
                            }
                            if (opMagia == 3){
                                int cura = Dados.rolaDado(8)+ Dados.rolaDado(8);
                                Personagem.curar(cura);
                                System.out.println("Voce foi curado em " + cura + " pontos de vida");
                                
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
}
*/

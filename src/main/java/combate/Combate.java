package combate;

import ficha.Personagem;
import ficha.Dados;
import java.util.Scanner;
import poderes.Poderes;

public class Combate {
    public static int dist;
    
    public static void distancia() {
        switch(dist) {
            case 1 -> System.out.println("\n---Voce esta de frente para o seu inimigo---");
            case 2 -> System.out.println("\n---Voce esta proximo do seu inimigo---");
            default -> System.out.println("\n---Voce esta distante do seu inimigo---");
        }
    }
    
    public static boolean turnoInimigo() {
        int padrao = 1, mov = 1;
        boolean atacar = false;
        while(padrao+mov > 0) {
            if(dist == 1 && padrao > 0) {
                atacar = true;
                padrao = 0;
                mov = 0;
                System.out.println("\n---O inimigo atacou!---");
            } else if(dist > 1 && mov > 0) {
                mov = 0;
                dist--;
                System.out.println("\n---O inimigo esta se aproximando---");
            } else if(dist > 1 && padrao > 0) {
                padrao = 0;
                dist--;
                System.out.println("\n---O inimigo esta se aproximando---");
            }
        }
        return atacar;
    }
    
    public static int ataque(int atq, int def, int pv, int dado, int margem, int critico) {
        int x = 1, dano;
        int golpe = Dados.dado(1, 20);
        System.out.println("\nROLANDO O ATAQUE...");
        System.out.println("\nO RESULTADO DO ATAQUE FOI "+(golpe+atq));
        if(golpe >= margem) {
            System.out.println("\n---Acerto critico!---");
            x = critico;
            dano = Dados.dado(x, dado);
            return (pv-dano);
        }
        if(golpe+atq >= def) {
            System.out.println("\n---Ataque certeiro!---");
            dano = Dados.dado(x, dado);
            return (pv-dano);
        }
        System.out.println("\n---Ataque bloqueado!---");
        return pv;
    }
    
    public static int ataqueEspecial(int pvV, int atqH, int defV) {
        pvV = ataque(atqH+4, defV, pvV, Personagem.getArma().getDano(), Personagem.getArma().getMargem(), Personagem.getArma().getCritico());
        return pvV;
    }
    
    public static int marcaCacador(int pvV, int atqH, int defV) {
        pvV = ataque(atqH+4, defV, pvV, Personagem.getArma().getDano(), Personagem.getArma().getMargem()-2, Personagem.getArma().getCritico());
        return pvV;
    }
    
    public static int curarFerimentos(int pvH) {
        int cura = Dados.dado(2, 8);
        System.out.println("\nROLANDO OS DADOS...");
        System.out.println("\nPV RESTAURADOS: "+cura);
        return (pvH+cura);
    }
    
    public static int bolaFogo(int pvV) {
        int dano = Dados.dado(3, 6);
        System.out.println("\nROLANDO OS DADOS...");
        System.out.println("\nDANO CAUSADO: "+dano);
        return (pvV-dano);
    }
    
    public static void opcoes(int padrao) {
        System.out.println("\nESCOLHA UMA OPCAO:");
        System.out.println("1 -> AVANCAR");
        if(dist == 1) System.out.println("---Voce esta de frente para o seu inimigo---");
        System.out.println("2 -> RECUAR");
        if(dist == 3) System.out.println("---Voce esta no limite da distancia---");
        System.out.println("3 -> ATACAR");
        if(padrao == 0) System.out.println("---Voce nao possui mais acao padrao---");
        System.out.println("4 -> USAR PODER: "+Poderes.mapPoderes.get(Personagem.getClasse().getPoder()));
        if(padrao == 0) System.out.println("---Voce nao possui mais acao padrao---");
        System.out.println("5 -> ENCERRAR TURNO");
    }
    
    public static void resumoTurno(int pvH, int manaH, int pvV) {
        System.out.println("\nHEROI:");
        System.out.printf("PV: %d/%d       Mana: %d/%d", pvH, Personagem.getPv(), manaH, Personagem.getMana());
        System.out.println("\nINIMIGO:");
        System.out.printf("PV: %d", pvV);
    }
    
    public static boolean confereMana(int manaH) {
        return (manaH >= Personagem.getClasse().getPm());
    }
    
    public static boolean luta(Inimigo inimigo) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("---Pressione qualquer tecla para iniciar o combate---");
        String comecar = teclado.next();
        int pvH = Personagem.getPv(), manaH = Personagem.getMana(), defH = Personagem.getDefesa(), deslocamentoH = Personagem.getDeslocamento(), atqH = Personagem.getAtq();
        int pvV = inimigo.getPv(), defV = inimigo.getDefesa(), deslocamentoV = inimigo.getDeslocamento(), atqV = inimigo.getAtq();
        System.out.println("\n---Um "+inimigo.getNome()+" apareceu!---");
        System.out.println("---Role Iniciativa para tentar agir primeiro---");
        int iniH = Dados.dado(1, 20) + deslocamentoH;
        int iniV = Dados.dado(1, 20) + deslocamentoV;
        System.out.println("\nROLANDO OS DADOS...\n");
        System.out.println("\nSEU RESULTADO FOI "+iniH);
        System.out.println("O RESULTADO DO "+inimigo.getNome()+" FOI "+iniV);
        System.out.println("\n---O combate comecou!---");
        if(iniH >= iniV) System.out.println("\n---Voce ira agir primeiro---");
        else System.out.println("\n---"+inimigo.getNome()+" ira agir primeiro---");
        dist = Dados.dado(1, 3);
        int op, mov, padrao;
        do {
            resumoTurno(pvH, manaH, pvV);
            distancia();
            if(iniH < iniV) {
                if (turnoInimigo()) {
                    dist = 1;
                    pvH = ataque(atqV, defH, pvH, inimigo.getArma().getDano(), inimigo.getArma().getMargem(), inimigo.getArma().getCritico());
                }
            }
            if(pvH <= 0) break;
            distancia();
            
            
            mov = 1;
            padrao = 1;
            do {
                opcoes(padrao);
                op = teclado.nextInt();
                switch(op) {
                    case 1 -> {
                        if(dist>1 && mov+padrao>0) {
                            dist--;
                            if(mov==1) mov = 0;
                            else padrao = 0;
                            System.out.println("\n---Se aproximando do inimigo---");
                        } else System.out.println("\nOPCAO INVALIDA!");
                    }
                    case 2 -> {
                        if(dist<3 && mov+padrao>0) {
                            dist++;
                            if(mov==1) mov = 0;
                            else padrao = 0;
                            System.out.println("\n---Se afastando do inimigo---");
                        } else System.out.println("\nOPCAO INVALIDA!");
                    }
                    case 3 -> {
                        if(padrao>0 && Personagem.getArma().getAlcance()>=dist) {
                            pvV = ataque(atqH, defV, pvV, inimigo.getArma().getDano(), inimigo.getArma().getMargem(), inimigo.getArma().getCritico());
                            padrao = 0;
                        } else System.out.println("\nOPCAO INVALIDA!");
                    }
                    case 4 -> {
                        if(padrao == 0) {
                            System.out.println("\nOPCAO INVALIDA!");
                            break;
                        }
                        
                        switch(Personagem.getClasse().getPoder()) {
                            case 5 -> {
                                if(Personagem.getArma().getAlcance() > dist) System.out.println("\nINIMIGO MUITO DISTANTE!");
                                else {
                                    if(confereMana(manaH)) {
                                        pvV = ataqueEspecial(pvV, atqH, defV);
                                        manaH -= Personagem.getClasse().getPm();
                                        padrao = 0;
                                    } else System.out.println("\nMANA INSUFICIENTE!");
                                }
                            }
                            case 6 -> {
                                if(confereMana(manaH)) {
                                    pvV = bolaFogo(pvV);
                                    manaH -= Personagem.getClasse().getPm();
                                    padrao = 0;
                                } else System.out.println("\nMANA INSUFICIENTE!");
                            }
                            case 7 -> {
                                if(confereMana(manaH)) {
                                    pvH = curarFerimentos(pvH);
                                    manaH -= Personagem.getClasse().getPm();
                                    padrao = 0;
                                } else System.out.println("\nMANA INSUFICIENTE!");
                            }
                            case 8 -> {
                                if(Personagem.getArma().getAlcance() > dist) System.out.println("\nINIMIGO MUITO DISTANTE!");
                                else {
                                    if(confereMana(manaH)) {
                                        pvV = marcaCacador(pvV, atqH, defV);
                                        manaH -= Personagem.getClasse().getPm();
                                        padrao = 0;
                                    } else System.out.println("\nMANA INSUFICIENTE!");
                                }
                            }
                        }
                    }
                    default -> {
                        mov = 0;
                        padrao = 0;
                    }
                }
            } while(mov+padrao>0);
            if(pvV <= 0) break;
            distancia();
            
        
            if(iniH >= iniV) {
                if (turnoInimigo()) {
                    dist = 1;
                    pvH = ataque(atqV, defH, pvH, inimigo.getArma().getDano(), inimigo.getArma().getMargem(), inimigo.getArma().getCritico());
                }
            }
        } while(pvH > 0 || pvV > 0);
        System.out.println("\n---FIM DO COMBATE---");
        return (pvH > 0);
    }
}

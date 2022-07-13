package ficha;

import racasClasses.*;
import equipamentos.*;
import atributos.Atributos;

public class Personagem {
    private static String nome;
    private static int pv, mana, deslocamento;
    private static int atq, def, nivel;
    private static Raca raca;
    private static Classe classe;
    private static Armaduras armadura;
    private static Armas arma;
    private static Atributos atributos;
    
    public Personagem() {
        Personagem.atributos = new Atributos(0,0,0,0,0,0);
        Personagem.nivel = 1;
    }
    
    public Personagem(Raca raca, Classe classe, String simbolo) {
        Personagem.raca = raca;
        Personagem.classe = classe;
    }
    
    public static void setRaca(Raca raca) {
        Personagem.raca = raca;
    }
    public static Raca getRaca() {
        return Personagem.raca;
    }
    
    public static void setClasse(Classe classe) {
        Personagem.classe = classe;
    }
    public static Classe getClasse() {
        return Personagem.classe;
    }
    
    public static void setArma(Armas arma) {
        Personagem.arma = arma;
    }
    public static Armas getArma() {
        return Personagem.arma;
    }
    public static void setArmadura(Armaduras armadura) {
        Personagem.armadura = armadura;
    }
    public static Armaduras getArmadura() {
        return Personagem.armadura;
    }
            
    public static void setNome(String nome) {
        Personagem.nome = nome;
    }
    public static String getNome() {
        return Personagem.nome;
    }
    
    public static void iniciar() {
        Personagem.atributos.setAtributosRaca(Personagem.getRaca().getAtributos());
        Personagem.atributos.setModificadores();
        Personagem.setPv();
        Personagem.setMana();
    }
    public static void setAtributos(int i, int num) {
        Personagem.atributos.setAtributo(i, num);
    }
    public static void setPv() {
        Personagem.pv = Personagem.classe.getPv() + Personagem.atributos.getModificador(2) + ((Personagem.classe.getPvNivel() + Personagem.atributos.getModificador(2)) * (Personagem.nivel - 1));
    }
    public static int getPv() {
        return Personagem.pv;
    }
    public static void setMana() {
        Personagem.mana = (Personagem.classe.getMana()*Personagem.getNivel());
        switch(Personagem.classe.getNome()) {
            case "bruxo" -> Personagem.mana += Personagem.atributos.getModificador(3); //Somar modificador de INT
            case "clerigo" -> Personagem.mana += Personagem.atributos.getModificador(4); //Somar modificador de SAB
        }
    }
    public static int getMana() {
        return Personagem.mana;
    }
    public static void setAtq() {
        Personagem.atq = (Personagem.nivel/2);
        if(Personagem.getArma().getAlcance() == 1) Personagem.atq += Personagem.atributos.getModificador(0);
        else Personagem.atq += Personagem.atributos.getModificador(1);
    }
    public static int getAtq() {
        return Personagem.atq;
    }
    
    public static void equipar() {
        Personagem.setDefesa();
        Personagem.setDeslocamento();
        Personagem.setAtq();
    }    
    public static void setDefesa() {
        Personagem.def = 10  + (Personagem.nivel / 2);
        if(Personagem.getArmadura() == null) {
            Personagem.def += Personagem.atributos.getModificador(1);
            return;
        }
        Personagem.def += Personagem.getArmadura().getDefesa();
        if(!Personagem.getArmadura().getPesada()) Personagem.def += Personagem.atributos.getModificador(1);
    }
    public static int getDefesa() {
        return Personagem.def;
    }
    public static void setDeslocamento() {
        Personagem.deslocamento = 6;
        if (Personagem.getRaca().getDeslocamentoMaior()) Personagem.deslocamento += 2;
        else if (Personagem.getRaca().getDeslocamentoMenor()) Personagem.deslocamento -= 2;
        if(!(Personagem.getArmadura() == null)) Personagem.deslocamento += Personagem.getArmadura().getPenalidade();
    }
    public static int getDeslocamento() {
        return Personagem.deslocamento;
    }
    
    public static void poderRaca() {
        switch(Personagem.getRaca().getPoder()) {
            case 1 -> { //elfo
                Personagem.deslocamento += 2;
                Personagem.mana += 1;
            }
            case 2 -> { //anão
                Personagem.deslocamento = 6;
                Personagem.pv += 3;
            }
            case 3 -> Personagem.def += 1; //minotauro
            default -> Personagem.atq += 1; //goblin
        }
    }
    
    public static int getNivel() {
        return Personagem.nivel;
    }
    
    public static void imprimeAtributos() {
        Personagem.atributos.imprimeAtributos();
    }
    
    public static void subirNivel() {
        Personagem.nivel++;
        Personagem.setPv();
        Personagem.setMana();
        Personagem.setDefesa();
        Personagem.setAtq();
        Personagem.poderRaca();
    }
}

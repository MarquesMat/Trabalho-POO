package ficha;

import equipamentos.Armaduras;
import racasClasses.*;
import equipamentos.*;
import atributos.Atributos;

public class Personagem {
    private static String nome;
    private static int pv, mana, deslocamento;
    private static int atq, def, nivel;
    private static Raca raca;
    private static Classe classe;
    private static Armas arma;

    public static void setArma(Armas arma) {
        Personagem.arma = arma;
    }

    public static Armas getArma() {
        return arma;
    }
    private static Armaduras armadura;
    protected static Atributos atributos;
    private String simbolo;
    
    
    public Personagem() {
        Personagem.atributos = new Atributos(0,0,0,0,0,0);
        Personagem.nivel = 1;
    }
    
    public Personagem(Raca raca, Classe classe, String simbolo) {
        Personagem.raca = raca;
        Personagem.classe = classe;
        this.simbolo = simbolo;//adicionado simbolo usado no mapa de combate
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
    
    public static void setArmadura(Armaduras armadura) {
        Personagem.armadura = armadura;
    }
    public static Armaduras getArmadura() {
        return Personagem.armadura;
    }
        
    public String getSimbolo(){
        return simbolo;
    }
    
    public static void setNome(String nome) {
        Personagem.nome = nome;
    }
    public static String getNome() {
        return Personagem.nome;
    }
    
    public static void setAtributos(int i, int num) {
        Personagem.atributos.setAtributo(i, num);
    }
    
    public void setHp() {
        Personagem.pv = Personagem.classe.getPv() + Personagem.atributos.getModificador(2) + ((Personagem.classe.getPvNivel() + Personagem.atributos.getModificador(2)) * (Personagem.nivel - 1));
    }
    
    public void setMana() {
        Personagem.mana = Personagem.classe.getMana();
        switch(Personagem.classe.getNome()) {
            case "bruxo" -> Personagem.mana += Personagem.atributos.getModificador(3); //Somar modificador de INT
            case "clerigo" -> Personagem.mana += Personagem.atributos.getModificador(4); //Somar modificador de SAB
        }
    }
    public static int getPv(){
        return Personagem.pv;
    }
    public static int getMana(){
        return Personagem.mana;
    }
    public static void reduzMana(int i){
        Personagem.mana -= 1;
    }
    public static void equipar() {
        Personagem.setDefesa();
        Personagem.setDeslocamento();
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
    public static void adcDefesa(int i){
        Personagem.def += i;
    }
    public static void curar(int i){
        Personagem.pv += i;
    }
    public static void dano(int i){
        Personagem.pv -= i;
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
    
    public static int getNivel() {
        return Personagem.nivel;
    }
}

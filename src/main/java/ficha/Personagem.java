package ficha;

import racasClasses.*;
import atributos.Atributos;

public class Personagem {
    private static String nome;
    protected int pv, mana, deslocamento;
    protected static int def, nivel;
    //adicionar a classe de Equipamentos no mesmo package de Personagem para alterar a defesa
    protected static Raca raca;
    protected static Classe classe;
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
    
    public String getSimbolo(){
        return simbolo;
    }
    
    public static void setNome(String nome) {
        Personagem.nome = nome;
    }
    
    public static void setAtributos(int i, int num) {
        Personagem.atributos.setAtributo(i, num);
    }
    
    public void setHp() {
        this.pv = Personagem.classe.getPv() + Personagem.atributos.getModificador(2) + ((Personagem.classe.getPvNivel() + Personagem.atributos.getModificador(2)) * (Personagem.nivel - 1));
    }
    
    public void setMana() {
        this.mana = Personagem.classe.getMana();
        switch(Personagem.classe.getNome()) {
            case "bruxo" -> this.mana += Personagem.atributos.getModificador(3); //Somar modificador de INT
            case "clerigo" -> this.mana += Personagem.atributos.getModificador(4); //Somar modificador de SAB
        }
    }
    
    public void setDefesa() {
        Personagem.def = 10  + (Personagem.nivel / 2);
        if (true) Personagem.def += Personagem.atributos.getModificador(1);
    }
    
    public void setDeslocamento() {
        this.deslocamento = 6;
        if (raca.getDeslocamentoMaior()) this.deslocamento += 2;
        else if (raca.getDeslocamentoMenor()) this.deslocamento -= 2;
    }
    
    public static String getNome() {
        return Personagem.nome;
    }
}

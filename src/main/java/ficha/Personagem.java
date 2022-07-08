package ficha;

import racasClasses.*;
import atributos.Atributos;

public class Personagem {
    private String nome;
    private int pv, mana, deslocamento;
    protected static int def, nivel;
    //adicionar a classe de Equipamentos no mesmo package de Personagem para alterar a defesa
    private Raca raca;
    private Classe classe;
    private Atributos atributos;
    private String simbolo;
    
    public Personagem(Raca raca, Classe classe, String simbolo) {
        this.raca = raca;
        this.classe = classe;
        this.simbolo = simbolo;//adicionado simbolo usado no mapa de combate
    }
    
    public String getSimbolo(){
        return simbolo;
    }
    public Raca getRaca() {
        return raca;
    }

    public Classe getClasse() {
        return classe;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setAtributos(int i, int num) {
        this.atributos.setAtributo(i, num);
    }
    
    public void setHp() {
        this.pv = this.classe.getPv() + this.atributos.getModificador(2) + ((this.classe.getPvNivel() + this.atributos.getModificador(2)) * (this.nivel - 1));
    }
    
    public void setMana() {
        this.mana = this.classe.getMana();
        switch(this.classe.getNome()) {
            case "bruxo" -> this.mana += this.atributos.getModificador(3); //Somar modificador de INT
            case "clerigo" -> this.mana += this.atributos.getModificador(4); //Somar modificador de SAB
        }
    }
    
    public void setDefesa() {
        Personagem.def = 10  + (Personagem.nivel / 2);
        if (true) Personagem.def += this.atributos.getModificador(1);
    }
    
    public void setDeslocamento() {
        this.deslocamento = 6;
        if (raca.getDeslocamentoMaior()) this.deslocamento += 2;
        else if (raca.getDeslocamentoMenor()) this.deslocamento -= 2;
    }
}

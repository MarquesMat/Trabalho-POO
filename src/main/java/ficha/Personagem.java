package ficha;

import java.util.ArrayList;
import racasClasses.*;
import atributos.Atributos;

public class Personagem {
    String nome;
    int hp, mana, def, deslocamento, nivel;
    Raca raca;
    Classe classe;
    Atributos atributos;
    ArrayList<Atributos> listaAtributos;
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setAtributos(int i, int num) {
        this.atributos.setAtributo(i, num);
    }
    
    public void setHp(int hp) {
        this.hp = this.classe.getPv() + (this.classe.getPvNivel() * (this.nivel - 1));
    }
    
    public void setMana(int mana) {
        this.mana = this.classe.getMana();
        switch(this.classe.getNome()) {
            case "bruxo" -> this.mana += this.atributos.getModificador(3); //Somar modificador de INT
            case "clerigo" -> this.mana += this.atributos.getModificador(4); //Somar modificador de SAB
        }
    }
    
    public void setDefesa() {
        this.def = 10  + (this.nivel / 2);
        if (true) this.def += this.atributos.getModificador(1);
    }
}

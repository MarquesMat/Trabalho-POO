package ficha;

import java.util.ArrayList;
import racasClasses.*;
import atributos.Atributos;

public class Personagem {
    String nome;
    int pv, mana, def, deslocamento, nivel;
    Raca raca;
    Classe classe;
    Atributos atributos;
    
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
        switch(this.classe.getNome()) { //usar ENUM
            case "bruxo" -> this.mana += this.atributos.getModificador(3); //Somar modificador de INT
            case "clerigo" -> this.mana += this.atributos.getModificador(4); //Somar modificador de SAB
        }
    }
    
    public void setDefesa() {
        this.def = 10  + (this.nivel / 2);
        if (true) this.def += this.atributos.getModificador(1);
    }
}

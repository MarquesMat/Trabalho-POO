package atributos;

import java.util.ArrayList;
import java.util.List;

public class Atributos {   
    private List<Integer> atributos = new ArrayList<>();
    private List<Integer> modificadores = new ArrayList<>();
    //FOR, DES, CON, INT, SAB, CAR
    
    public Atributos(int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma) {
        this.atributos.add(forca);
        this.atributos.add(destreza);
        this.atributos.add(constituicao);
        this.atributos.add(inteligencia);
        this.atributos.add(sabedoria);
        this.atributos.add(carisma);
    }
    
    public List<Integer> getAtributos() {
        return this.atributos;
    }
    
    public int getModificador(int i) {
        return this.modificadores.get(i);
    }
    
    public void setAtributo(int i, int atributo) {
        this.atributos.set(i, atributo);
    }
     
    public void setAtributosRaca(List<Integer> atributosRaca) {
        //soma os atributos do jogador com os da raça
        for(int i=0; i<this.atributos.size(); i++) {
            this.atributos.set(i, this.atributos.get(i)+atributosRaca.get(i));      
        }
    }
    
    
    public void setModificadores() {
        for (Integer atributo: this.atributos) {
            if (atributo == 9) this.modificadores.add(-1);
            else this.modificadores.add((atributo-10)/2);
        }
    }
}

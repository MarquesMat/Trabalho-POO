package atributos;

import java.util.ArrayList;
import java.util.List;

public class Atributos {   
    private List<Integer> atributos = new ArrayList<>(6);
    private List<Integer> modificadores = new ArrayList<>(6);
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
    
    public void imprimeAtributos() {
        System.out.println("FOR     DES     CON     INT     SAB     CAR");
        System.out.printf(" %d      %d      %d      %d      %d      %d", this.atributos.get(0), this.atributos.get(1), this.atributos.get(2), this.atributos.get(3), this.atributos.get(4), this.atributos.get(5));
        System.out.printf("\n %d       %d       %d       %d       %d       %d", this.modificadores.get(0), this.modificadores.get(1), this.modificadores.get(2), this.modificadores.get(3), this.modificadores.get(4), this.modificadores.get(5));
    }
}

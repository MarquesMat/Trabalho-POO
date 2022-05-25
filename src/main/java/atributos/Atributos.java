package atributos;

import java.util.ArrayList;

public class Atributos {
    private ArrayList<Integer> atributos, modificadores; 
    //FOR, DES, CON, INT, SAB, CAR
    
    public int getModificador(int i) {
        return this.modificadores.get(i);
    }
    
    public void setAtributo(int i, int atributo) {
        this.atributos.set(i, atributo);
    }
    
    public void altAtributo(int i, int alt) { //modificar o atributo de acordo com a raça
        int novoAtributo = this.atributos.get(i) + alt;
        this.atributos.set(i, novoAtributo);
    }
    
    public void setAtributosRaca(String raca) {
        switch(raca) {
            case "elfo" -> {
                this.altAtributo(2, -2); //-2 em CON
                this.altAtributo(3, 4); //+4 em INT
                this.altAtributo(1, 2); //+2 em DES
            }
            case "minotauro" -> {
                this.altAtributo(0, 4); //+4 em FOR
                this.altAtributo(2, 2); //+2 em CON
                this.altAtributo(4, -2); //-2 em SAB
            }
            case "anao" -> {
                this.altAtributo(2, 4); //+4 em CON
                this.altAtributo(4, 2); //+2 em SAB
                this.altAtributo(1, -2); //-2 em DES
            }
            case "goblin" -> {
                this.altAtributo(1, 4); //+4 em DES
                this.altAtributo(3, 2); //+2 em INT
                this.altAtributo(5, -2); //-2 em CAR
            }
            default -> {
                //implementar um método pra humano
            }
        }
    }
    
    public void setModificadores() {
        for (Integer atributo: this.atributos) {
            if (atributo == 9) this.modificadores.add(-1);
            else this.modificadores.add((atributo-10)/2);
        }
    }
}

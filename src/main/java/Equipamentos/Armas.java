
package Equipamentos;

public class Armas {
       
       private int dano;
       private int margem;
       private int critico;
       private int alcance; //0 para sem alcance, 1 para "curto" e 2 para medio
       private float peso;
       private int tipo; //1 para perfuracao, 2 para corte

    public Armas(int dano, int margem, int critico, int alcance, float peso, int tipo) {
        
        this.dano = dano;
        this.margem = margem;
        this.critico = critico;
        this.alcance = alcance;
        this.peso = peso;
        this.tipo = tipo;
    }

    

    public int getDano() {
        return dano;
    }

    public int getCritico() {
        return critico;
    }

    public int getAlcance() {
        return alcance;
    }

    public float getPeso() {
        return peso;
    }

    public int getTipo() {
        return tipo;
    }
    
}


package Equipamentos;

public abstract class Armas {
       protected String nome;
       protected int dano;
       protected int critico;
       protected String alcance;
       protected float peso;
       protected String tipo;

    public Armas(String nome, int dano, int critico, String alcance, float peso, String tipo) {
        this.nome = nome;
        this.dano = dano;
        this.critico = critico;
        this.alcance = alcance;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getCritico() {
        return critico;
    }

    public String getAlcance() {
        return alcance;
    }

    public float getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }
    
}

package equipamentos;

public class Armas {
       private int dano, margem, critico;
       private int alcance; //1 para sem alcance, 2 para "curto" e 3 para medio
       private String tipo, nome;

    public Armas(int dano, int margem, int critico, int alcance, String nome, String tipo) {
        this.dano = dano;
        this.margem = margem;
        this.critico = critico;
        this.alcance = alcance;
        this.nome = nome;
        this.tipo = tipo;
    }
    
    public int getDano() {
        return this.dano;
    }
    
    public int getMargem() {
        return this.margem;
    }

    public int getCritico() {
        return this.critico;
    }

    public int getAlcance() {
        return this.alcance;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTipo() {
        return this.tipo;
    }
}

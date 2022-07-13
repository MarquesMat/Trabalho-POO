package combate;

import equipamentos.Armas;

public class Inimigo {
    private int pv, def, deslocamento, atq;
    private String nome;
    private Armas arma;
    
    public Inimigo(String nome, int pv, int defesa, int deslocamento, int atq, Armas arma) {
        this.nome = nome;
        this.pv = pv;
        this.def = defesa;
        this.deslocamento = deslocamento;
        this.atq = atq;
        this.arma = arma;
    }
    
    public int getPv() {
        return this.pv;
    }
    
    public int getDefesa() {
        return this.def;
    }
    
    public int getDeslocamento() {
        return this.deslocamento;
    }
    
    public int getAtq() {
        return this.atq;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Armas getArma() {
        return this.arma;
    }
}

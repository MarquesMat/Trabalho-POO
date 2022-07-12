package equipamentos;





public class Armaduras {
    private int defesa;
    private int penalidade;
    private String nome;
    private boolean pesada;

    public Armaduras (int defesa, int penalidade, String nome, boolean pesada) {
        this.defesa = defesa;
        this.penalidade = penalidade;
        this.nome = nome;
        this.pesada = pesada;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getPenalidade() {
        return penalidade;
    }
    public String getNome(){
        return nome;
    }
    public boolean getPesada() {
        return pesada;
    }
    
}

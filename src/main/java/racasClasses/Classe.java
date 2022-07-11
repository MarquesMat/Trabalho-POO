package racasClasses;

public class Classe extends RacasClasses {
    int pv, pvNivel, mana;
    boolean armPesada, armLeve, armasMarciais;
    /*
    PV -> Quantidade inicial de pontos de vida
    PV por Nivel -> Quantidade de pontos de vida ganhos em cada nível a partir do 2
    Mana -> Quantidade de pontos de mana ganhos em cada nível a partir do 1
    */
    public Classe(String nome, int pv, int pvNivel, int mana, boolean armPesada, boolean armLeve, boolean armasMarciais) {
        super(nome);
        this.pv = pv;
        this.pvNivel = pvNivel;
        this.mana = mana;
        this.armPesada = armPesada;
        this.armLeve = armLeve;
        this.armasMarciais = armasMarciais;
    }
    
    public int getPv() {
        return this.pv;
    }
    
    public int getPvNivel() {
        return this.pvNivel;
    }
    
    public int getMana() {
        return this.mana;
    }
}

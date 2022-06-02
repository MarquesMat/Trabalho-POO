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
    
    public static void ImprimeClasses(){
        System.out.println("CLASSES:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Bruxo");
        System.out.println("3 - Clerigo");
        System.out.println("4 - Cacador");
    }
    public static void implementaClasse(int opcao) {
    	switch(opcao){
        case 1 ->{
        	Classe guerreiro = new Classe("guerreiro", 20, 5, 3, true, true, true);
            
        }
        case 2 ->{
        	Classe bruxo = new Classe("bruxo", 8, 2, 6, false, false, false);
            
        }
        case 3 ->{
        	Classe clerigo = new Classe("clerigo", 16, 4, 5, true, true, false);
            ;
        }
        case 4 ->{
        	Classe cacador = new Classe("cacador", 16, 4, 4, false, true, true);
            
        }
    }
    }
}

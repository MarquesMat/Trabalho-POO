package racasClasses;

import atributos.Atributos;
import java.util.List;

public class Raca extends RacasClasses {
    private boolean deslocamentoMaior, deslocamentoMenor;
    private Atributos atributos;
    /*
    deslocamentoMaior -> 9 quadrados
    deslocamentoMenor -> 4 quadrados
    atributos -> serve para alterar os atributos de acordo com a raça
    */

    public Raca(String nome, int poder, boolean deslocamentoMaior, boolean deslocamentoMenor, int f, int d, int con, int i, int s, int car) {
        super(nome, poder);
        this.deslocamentoMaior = deslocamentoMaior;
        this.deslocamentoMenor = deslocamentoMenor;
        this.atributos = new Atributos(f, d, con, i, s, car);
    }

    public boolean getDeslocamentoMaior() {
        return this.deslocamentoMaior;
    }
    
    public boolean getDeslocamentoMenor() {
        return this.deslocamentoMenor;
    }
    
    public List<Integer> getAtributos() {
        return this.atributos.getAtributos();
    }
}

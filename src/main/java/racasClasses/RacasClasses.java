package racasClasses;

import java.util.ArrayList;
import poderes.Poderes;

public abstract class RacasClasses {
    protected String nome;
    protected ArrayList<Poderes> poderes;
    
    public RacasClasses(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
}

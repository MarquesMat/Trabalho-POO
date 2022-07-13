package racasClasses;


public abstract class RacasClasses {
    protected String nome;
    protected int poder;
    
    public RacasClasses(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getPoder() {
        return this.poder;
    }
}

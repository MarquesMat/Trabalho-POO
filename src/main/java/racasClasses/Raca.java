package racasClasses;





public class Raca extends RacasClasses {
    private boolean deslocamentoMaior, deslocamentoMenor; //atrib1, atrib2, atrib3, 4, 2, -2
    private String atributos;
    
    
            
    public Raca(String nome, boolean deslocamentoMaior, boolean deslocamentoMenor) {
        super(nome);
        this.deslocamentoMaior = deslocamentoMaior;
        this.deslocamentoMenor = deslocamentoMenor;
        //this.atributos = atributos;
    }
    
    public boolean getDeslocamentoMaior() {
        return this.deslocamentoMaior;
    }
    
    public boolean getDeslocamentoMenor() {
        return this.deslocamentoMenor;
    }
    
    public String getAtributos() {
        return this.atributos;
    }
    
    
   

	
   
}

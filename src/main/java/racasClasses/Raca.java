package racasClasses;
import atributos.Atributos;




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
    
    public static void ImprimeRacas(){
        System.out.println("RACAS:");
        /*
        Nome
        deslocamento: 6 q
        Atributos: +4 FOR, +2 CON, -2 SAB
        Lista de Poderes
        */
        System.out.println("1 - Elfo");
        System.out.println("2 - Anao");
        System.out.println("3 - Minotauro");
        System.out.println("4 - Goblin");
    }
    public static void implementaRaca(int opcao){
        switch(opcao){
            case 1 ->{
               Raca elfo = new Raca("ELFO", true, false);
              
               

            }
            case 2 ->{
               Raca anao = new Raca("ANAO", false, true);
               
            }
            case 3 ->{
               Raca minotauro = new Raca("MINOTAURO", false, false);
               
            }
            case 4 ->{
                Raca goblin = new Raca("GOBLIN", false, false);
                
            }
        }
}

	
   
}

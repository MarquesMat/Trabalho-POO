package ficha;

import racasClasses.BancoDeClasses;
import racasClasses.BancoDeRacas;
import racasClasses.Raca;



public class TrabalhoPOO {
    public static void main(String[] args) {
    	new BancoDeRacas();
        new BancoDeClasses();
        //Combate combate = new Combate(20,20);
        //caso queira fazer um teste, retire a chamada acima do comentário 
        
        Menu.exec();
        
        //os construtores preparam os dicionarios
       
    }
}

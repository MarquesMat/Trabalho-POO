package ficha;

import racasClasses.BancoDeClasses;
import racasClasses.BancoDeRacas;

public class TrabalhoPOO {
    public static void imprimirFicha() {
        System.out.println("Nome: "+Personagem.getNome());
        System.out.println("Raca: "+Personagem.raca.getNome());
        System.out.println("Classe: "+Personagem.classe.getNome());
        Personagem.atributos.imprimeAtributos();
    }
    
    public static void main(String[] args) {
        BancoDeRacas bancoDeRacas = new BancoDeRacas();
        BancoDeClasses bancoDeClasses = new BancoDeClasses();
        Personagem personagem = new Personagem();
        //Combate combate = new Combate(20,20);
        //caso queira fazer um teste, retire a chamada acima do comentário 
        
        Menu.exec();
        Personagem.atributos.setAtributosRaca(Personagem.raca.getAtributos());
        Personagem.atributos.setModificadores();
        imprimirFicha();
        //os construtores preparam os dicionarios
       
    }
}

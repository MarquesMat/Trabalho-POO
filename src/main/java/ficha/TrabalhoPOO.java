package ficha;

import racasClasses.BancoDeClasses;
import racasClasses.BancoDeRacas;
import equipamentos.BancoDeArmaduras;
import equipamentos.BancoDeArmas;

public class TrabalhoPOO {
    public static void imprimirFichaProvisoria() {
        System.out.println("Nome: "+Personagem.getNome());
        System.out.println("Raca: "+Personagem.getRaca().getNome());
        System.out.println("Classe: "+Personagem.getClasse().getNome());
        Personagem.atributos.imprimeAtributos();
    }
    
    public static void imprimirFicha() {
        System.out.println("\n\nNome: "+Personagem.getNome());
        System.out.println("Raca: "+Personagem.getRaca().getNome());
        System.out.println("Classe: "+Personagem.getClasse().getNome());
        System.out.println("Nivel: "+Personagem.getNivel());
        Personagem.atributos.imprimeAtributos();
        System.out.println("\nDefesa: "+Personagem.getDefesa());
        System.out.println("Deslocamento: "+Personagem.getDeslocamento());
        
    }
    
    public static void main(String[] args) {
        BancoDeRacas bancoDeRacas = new BancoDeRacas();
        BancoDeClasses bancoDeClasses = new BancoDeClasses();
        BancoDeArmaduras bancoDeArmaduras = new BancoDeArmaduras();
        BancoDeArmas bancoDeArmas = new BancoDeArmas();
        //os construtores preparam os dicionarios
        Personagem personagem = new Personagem();
        //Combate combate = new Combate(20,20);
        //caso queira fazer um teste, retire a chamada acima do comentário 
        
        Menu.exec();
        Personagem.atributos.setAtributosRaca(Personagem.getRaca().getAtributos());
        Personagem.atributos.setModificadores();
        imprimirFichaProvisoria();
        Menu.exec2();
        Personagem.equipar();
        imprimirFicha();
    }
}

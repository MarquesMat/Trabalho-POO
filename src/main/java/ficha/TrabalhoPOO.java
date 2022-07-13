package ficha;

import racasClasses.BancoDeClasses;
import racasClasses.BancoDeRacas;
import equipamentos.BancoDeArmaduras;
import equipamentos.BancoDeArmas;
import poderes.Poderes;
import combate.BancoDeInimigos;
import combate.Combate;

public class TrabalhoPOO {
    public static void imprimirFichaProvisoria() {
        System.out.print("\nNome: "+Personagem.getNome());
        System.out.print("      Raca: "+Personagem.getRaca().getNome());
        System.out.print("      Classe: "+Personagem.getClasse().getNome());
        System.out.println("      Nivel: "+Personagem.getNivel());
        Personagem.imprimeAtributos();
    }
    
    public static void imprimirFicha() {
        System.out.print("\n\nNome: "+Personagem.getNome());
        System.out.print("      Raca: "+Personagem.getRaca().getNome());
        System.out.print("      Classe: "+Personagem.getClasse().getNome());
        System.out.println("      Nivel: "+Personagem.getNivel());
        Personagem.imprimeAtributos();
        System.out.print("\nPV: "+Personagem.getPv());
        System.out.println("        Mana: "+Personagem.getMana());
        System.out.print("\nAtaque: "+Personagem.getAtq()+"     Defesa: "+Personagem.getDefesa());
        System.out.println("        Deslocamento: "+Personagem.getDeslocamento());
        System.out.println("Poderes: ");
        System.out.println(Poderes.mapPoderes.get(Personagem.getRaca().getPoder()));
        System.out.println(Poderes.mapPoderes.get(Personagem.getClasse().getPoder()));
        
    }
    
    public static void main(String[] args) {
        BancoDeRacas bancoDeRacas = new BancoDeRacas();
        BancoDeClasses bancoDeClasses = new BancoDeClasses();
        BancoDeArmaduras bancoDeArmaduras = new BancoDeArmaduras();
        BancoDeArmas bancoDeArmas = new BancoDeArmas();
        Poderes poderes = new Poderes();
        BancoDeInimigos bancoDeInimigos = new BancoDeInimigos();
        //os construtores preparam os dicionarios
        Personagem personagem = new Personagem();
        //Combate combate = new Combate(20,20);
        //caso queira fazer um teste, retire a chamada acima do comentário 
        
        Menu.exec();
        Personagem.iniciar();
        imprimirFichaProvisoria();
        Menu.exec2();
        Personagem.equipar();
        Personagem.poderRaca();
        imprimirFicha();
        boolean vencer;
        if(Menu.encerrar()) return;
        do {
            vencer = Combate.luta(BancoDeInimigos.mapClasses.get(1));
            if(vencer) {
                Personagem.subirNivel();
                System.out.println("---Parabens pela vitoria!---");
            }
            else System.out.println("---Tente de novo!---");
        } while(!vencer);        
        imprimirFicha();
        if(Menu.encerrar()) return;
        do {
            vencer = Combate.luta(BancoDeInimigos.mapClasses.get(2));
            if(vencer) {
                Personagem.subirNivel();
                System.out.println("---Parabens pela vitoria!---");
            }
            else System.out.println("---Tente de novo!---");
        } while(!vencer);        
        imprimirFicha();
        if(Menu.encerrar()) return;
        do {
            vencer = Combate.luta(BancoDeInimigos.mapClasses.get(3));
            if(vencer) {
                Personagem.subirNivel();
                System.out.println("---Parabens pela vitoria!---");
            }
            else System.out.println("---Tente de novo!---");
        } while(!vencer);        
        imprimirFicha();
    }
}

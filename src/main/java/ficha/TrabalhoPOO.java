package ficha;

import java.util.Scanner;
import racasClasses.Raca;
import racasClasses.Classe;

public class TrabalhoPOO {

    public static void main(String[] args) {
        Raca elfo = new Raca("elfo", true, false); //nome, desl +2, deslc -2
        Raca anao = new Raca("anao", false, true); //nome, desl +2, deslc -2
        Raca minotauro = new Raca("minotauro", false, false); //nome, desl +2, deslc -2
        Raca goblin = new Raca("goblin", false, false); //nome, desl +2, deslc -2

        Classe guerreiro = new Classe("guerreiro", 20, 5, 3, true, true, true);
        Classe bruxo = new Classe("bruxo", 8, 2, 6, false, false, false);
        Classe clerigo = new Classe("clerigo", 16, 4, 5, true, true, false);
        Classe cacador = new Classe("cacador", 16, 4, 4, false, true, true);
        Menu.exec();
    }
}

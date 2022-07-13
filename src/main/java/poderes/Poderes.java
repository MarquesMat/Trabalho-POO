package poderes;

import java.util.HashMap;
import java.util.Map;

public final class Poderes {
    public static Map<Integer, String> mapPoderes = new HashMap<>();
    
    public Poderes() {
        Poderes.mapPoderes.put(1, "Rapido como o vento: ganhe mais 2 quadrados de deslocamento e mais um ponto de mana.");
        Poderes.mapPoderes.put(2, "Devagar e sempre: perca 2 quadrados de deslocamento, mas ganhe mais 3 pontos de vida e ignore penalidades de armaduras.");
        Poderes.mapPoderes.put(3, "Couro duro: ganhe um bonus de +1 na Defesa.");
        Poderes.mapPoderes.put(4, "Peste esguia: ganhe um bonus de +1 no Ataque.");
        Poderes.mapPoderes.put(5, "Ataque especial: Ganhe +4 no proximo ataque. (1 PM)");
        Poderes.mapPoderes.put(6, "Bola de fogo: Cause 3d6 pontos de dano. (5 PM)");
        Poderes.mapPoderes.put(7, "Curar ferimentos: Ganhe 2d8 PV. (3 PM)");
        Poderes.mapPoderes.put(8, "Marca do cacador: Aumente a margem de critico em 2. (3 PM)");
    }
}

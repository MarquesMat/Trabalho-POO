package combate;

import java.util.HashMap;
import java.util.Map;
import equipamentos.BancoDeArmas;

public final class BancoDeInimigos {
    public static Map<Integer, Inimigo> mapClasses = new HashMap<>();
    
    public BancoDeInimigos() {
        BancoDeInimigos.mapClasses.put(1, this.getHobgoblin());
        BancoDeInimigos.mapClasses.put(2, this.getEsqueleto());
        BancoDeInimigos.mapClasses.put(3, this.getOgro());
    }
    
    public Inimigo getHobgoblin() {
        return new Inimigo("Hobgoblin", 14, 12, 6, 0, BancoDeArmas.mapArmas.get(1));
    }
    
    public Inimigo getEsqueleto() {
        return new Inimigo("Esqueleto", 16, 15, 4, 1, BancoDeArmas.mapArmas.get(2));
    }
    
    public Inimigo getOgro() {
        return new Inimigo("Ogro", 25, 20, 6, 3, BancoDeArmas.mapArmas.get(2));
    }
}

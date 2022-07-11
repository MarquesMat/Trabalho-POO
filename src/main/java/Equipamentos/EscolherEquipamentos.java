
package Equipamentos;


public class EscolherEquipamentos {
    public Armas getLança(){
        return new Armas(6, 20, 2, 2, (float)1.5, 1);
    }
    public Armas getMachado(){
        return new Armas(8, 20, 3, 1, (float)3, 2);
    }
    public Armas getArco(){
        return new Armas(6, 20, 3, 2, (float)1, 1);
    }
    public Armaduras getArmaduraLeve(){
        return new Armaduras(1,0,5);
    }
    public Armaduras getArmaduraPesada(){
        return new Armaduras(5,-2,15);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipamentos;


public class Armaduras {
    private int defesa;
    private int penalidade;
    private String nome;
    private boolean pesada;

    public Armaduras (int defesa, int penalidade, String nome, boolean pesada) {
        this.defesa = defesa;
        this.penalidade = penalidade;
        this.nome = nome;
        this.pesada = pesada;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getPenalidade() {
        return this.penalidade;
    }

    public String getNome() {
        return this.nome;
    }
    
    public boolean getPesada() {
        return this.pesada;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Equipamentos;


public class Armaduras {
    private int defesa;
    private int penalidade;
    private int peso;

    public Armaduras (int defesa, int penalidade, int peso) {
        this.defesa = defesa;
        this.penalidade = penalidade;
        this.peso = peso;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getPenalidade() {
        return penalidade;
    }

    public int getPeso() {
        return peso;
    }
    
}

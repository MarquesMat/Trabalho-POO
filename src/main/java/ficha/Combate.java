
package ficha;

import racasClasses.BancoDeClasses;
import racasClasses.BancoDeRacas;
import racasClasses.Classe;
import racasClasses.Raca;

public class Combate {
    private int linhas;
    private int colunas;
    String mapa[][];
    private int loop = 1;//loop provisorio do combate

    public Combate(int linhas, int colunas) { //gera o mapa do combate
        this.linhas = linhas;
        this.colunas = colunas;
        this.mapa= new String[linhas][colunas];
        for(int i = 0; i < linhas; i++)  {
                for(int k = 0; k < colunas; k++)  {
                    mapa[i][k] = "0" ; 
                }
            }
    
    gerarCombate(); 
    
    }   
    public void gerarCombate(){
       Personagem personagem = new Personagem(BancoDeRacas.mapRacas.get(1),BancoDeClasses.mapClasses.get(1),"H");
       mapa[1][1] = personagem.getSimbolo(); //adiciona a coordenada do personagem por um simbolo
       Personagem personagem2 = new Personagem(BancoDeRacas.mapRacas.get(2),BancoDeClasses.mapClasses.get(2),"V");
       mapa[19][19] = personagem2.getSimbolo(); //adiciona a coordenada do inimigo por um simbolo
       print();//chama função que printa o mapa
       while(loop != 0){//loop provisorio para teste
           
       }
      
    }
    public void print()  {
            
            for(int i =0; i < linhas; i++)  {
                for(int j = 0; j < colunas; j++)  {
                    System.out.print(mapa[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }

        }

    
    }
      
    
    
    


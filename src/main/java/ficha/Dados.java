/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Dados {
    //int[] d = new int[4];
    
    public static int[] rolaDados(){
        int[] d = new int[4];
        for (int i = 0; i < 4; i++){    //adiciona elementos na lista
            Random dado = new Random();  
            d[i] = dado.nextInt(6)+1;
        }
        System.out.println("Seus 4 dados foram rolados");
        
        return d;   
    }
     
    
    public static List descartaMenor(int[] dados ){
        
        int menor = Integer.MAX_VALUE;  //identifica menor
        int posicao = 0;
        for (int i = 0; i < 4; i++){
            if (dados[i] < menor){
                menor = dados[i];
                posicao = i;               
            } 
        }
        
        List lista = new ArrayList();    
        for(int i = 0; i < 4; i++){
            lista.add(i, dados[i]);     
        }
        
        lista.remove(posicao);
        System.out.println("O menor dado foi descartado: " +menor);
        System.out.print("Seus numeros sao: ");
        System.out.println(lista);
        
        return lista;
    }
    
    
    public static int soma(List<Integer> dados){
        int soma = 0;
       
        for(int i = 0 ; i < 3; i++) {
            soma += dados.get(i);
        }
        
        if (soma < 6){
            System.out.println("a soma dos seus numeros e: "+soma);
            System.out.println("Como esse numero e menor que 6, seus dados serao rolados novamente...");
        }
       
        return soma;
    }
    
    public static void execut(){
        int soma = 0;
        
        do{
            int[] dados  = rolaDados();
            List lista = descartaMenor(dados);
            soma = soma(lista);
        }while (soma < 6);

    }
}
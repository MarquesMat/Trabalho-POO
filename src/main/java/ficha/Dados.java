package ficha;

import java.util.Random;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dados {

    public static int dado(int qtd, int lado) {
        int d = 0;
        for (int i=0; i<qtd; i++) {
            Random dado = new Random();  
            d += dado.nextInt(lado)+1;
        }
        return d;
    }
    
    public static int[] rolaDados(){
        int[] d = new int[4];
        for (int i = 0; i < 4; i++){    //adiciona elementos na lista
            Random dado = new Random();  
            d[i] = dado.nextInt(6)+1;
        }
        //System.out.println("Seus 4 dados foram rolados");
        
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
        
        lista.remove(posicao);  //remove menor valor
   
        return lista;
    }
    
    
    public static int soma(List<Integer> dados){
        int soma = 0;
       
        for(int i = 0 ; i < 3; i++) {   //soma os 3 valores do vetor
            soma += dados.get(i);
        }
        System.out.println(soma);
        if (soma < 6){
            System.out.println("a soma dos seus numeros e: "+soma);
            System.out.println("Como esse numero e menor que 6, seus dados serao rolados novamente...");
        }
       
        return soma;
    }
    
    public static boolean confere(List numeros, int a) {
        if(numeros.contains(a)) return true;
        System.out.println("\n---Opcao invalida ou ja escolhida---\n");
        return false;
    }
    
    public static List Auxiliar(List numeros, int i, String atributo) {
        
        int a = 0;
        do {
            try{
                Scanner teclado = new Scanner(System.in);
                System.out.printf("Defina o valor de %s: ", atributo);
                a = teclado.nextInt();}
            catch(InputMismatchException e){}
            
        }while(!confere(numeros, a));
        
        numeros.set(numeros.indexOf(a), -a);
        Personagem.setAtributos(i, a);
        return numeros;
    }
        
    public static void definirAtributos(List numeros) {
        System.out.println("\nSEUS NUMEROS SAO: "+numeros);
        numeros = Auxiliar(numeros, 0, "FORCA");  
        numeros = Auxiliar(numeros, 1, "DESTREZA");
        numeros = Auxiliar(numeros, 2, "CONSTITUICAO");
        numeros = Auxiliar(numeros, 3, "INTELIGENCIA");
        numeros = Auxiliar(numeros, 4, "SABEDORIA");
        numeros = Auxiliar(numeros, 5, "CARISMA");
        for(int i=0; i<6; i++) numeros.set(i, -(int) numeros.get(i));
    }
    
    public static List execut(){
        List numeros = new ArrayList<Integer>();
        System.out.println("Seus 4 dados serao rolados 6 vezes.");
        System.out.println("O menor valor de cada rodada sera descartado.");
        System.out.println("Os 3 valores restantes de cada rodada serao somados, resultando, ao final, 6 numeros.\n");
        int soma;
        for (int i = 1; i<7; i++){
            System.out.print("Rodada "+i);
            System.out.print(": ");
            do{
                int[] dados  = rolaDados();
                List lista = descartaMenor(dados);
                soma = soma(lista);
                if (soma>=6){
                    numeros.add(soma);
                }
            }while (soma < 6);
        }
        definirAtributos(numeros);
        return numeros;
    }
}

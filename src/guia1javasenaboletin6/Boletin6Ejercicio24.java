/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

import java.util.Arrays;

/**
 *
 * @author JOHN FORERO
 */
public class Boletin6Ejercicio24 {
    
    
    
    public static void solucion(){
    
        System.out.println("24. DUF a la que se le pasa como parámetro una tabla que debe rellenar. Se leerá por teclado una\n" +
                            "serie de números: guardaremos solo los pares e ignoraremos los impares. También hay que devolver la\n" +
                            "cantidad de impares ignorados.");
       
        
        System.out.println("\nEscribe una serie de numeros PARES");
        System.out.println("Pero primero digame cuantos quiere escribir");
        int cantidadNumerosPares = Entrada.entero(false, false, true);
        
        int[] numerosPares = new int[cantidadNumerosPares];
        
        int numerosImparesIgnorados =  capturarNumerosPares(numerosPares);
       
        mostrarListaPares(numerosPares);
        
        System.out.printf("\n La cantidad de impares ignorados es : %d %n", numerosImparesIgnorados);
        
        
    }
    
    public static int capturarNumerosPares (int[] numerosPares){
        
        System.out.printf("\n Acontinuacion escriba %d numeros enteros positivos PARES\n", numerosPares.length);
        int numerosImparesIgnorados = 0;
        
        for(int indice = 0; indice<numerosPares.length ; indice++){
            int numeroIngresado;
            do{
                System.out.printf("Escribe el #%d : ", indice + 1);
                numeroIngresado = Entrada.entero(true, false, true);
                if(numeroIngresado%2 == 0) break;
                else{
                    numerosImparesIgnorados++;
                    System.out.println("El numero que ingreso es impar, por favor intentelo de nuevo.");
                }
            }while(true);
            
                  
            numerosPares [indice] = numeroIngresado;
            
        }
        return numerosImparesIgnorados;
        
    }
    
    
    public static void mostrarListaPares( int[] lista){
        
        System.out.println("\n--------------------------------------------");
        System.out.println("\n La lista de pares que digito son :");
        System.out.println(armarlistaStringDe(lista));
        System.out.println("--------------------------------------------\n");
        
    }
            
    public static String armarlistaStringDe (int[] lista){
        
        StringBuilder armarLista = new StringBuilder();
        
        armarLista.append(" | ");
        for(int i=1; i<=lista.length ; i++){
            armarLista.append(lista[i-1]).append(" | ");
            if(i%10 == 0) armarLista.append("\n").append(" | ");
        }
    
        return armarLista.toString();
    }
    
    
}

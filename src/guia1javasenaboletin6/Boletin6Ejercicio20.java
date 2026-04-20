/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

/**
 *
 * @author johna
 */
public class Boletin6Ejercicio20 {
    
    public static void solucion(){
    
        System.out.println("20.DUF que muestre en binario un número entre 0 y 255");
        
        int numero;
        while(true){
            System.out.println("Escribe un numero entre 0 y 255");
            numero = Entrada.entero(true, false, true);
            
            if(numero <= 255){
                break;
            }
            
            System.out.println("El numero deber ser menor o igual a 255"
                    + "\nIntentelo de nuevo porfavor.\n");    
        }
        
        mostrarNumeroEnteroABinario(numero);
     
    }
    
    public static void mostrarNumeroEnteroABinario(int numero){
    
        StringBuilder numeroBinarioString = new StringBuilder();
        
        int[] binario = decimalABinario(numero);
        
        for(int i=binario.length-1 ; i>=0 ; i--){
            numeroBinarioString.append(binario[i]);
        }
        
        System.out.printf("El numero %d en binario es : %s ", numero , numeroBinarioString );
    
    }
    
    public static int[] decimalABinario(int numero) {
        
        int[] binario =  new int[tamañoListaBinario(numero)]; //2^8 = 256, este tamaño alcanza desde 0 hasta 255 para binarios
        /*
        binario = | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
        Para comodidad vamos a guardar el numero al reves, ejemplo 
        136 en binario es 10000100 en la lista binario lo vamos a guardar como 00100001
        esto nos permitira no depender del tamaño del vector y en un futuro si deseamos
        cambiar a numeros mas grandes no tenemos que cambiar la logica.
        Y para mostrar el binario se mostrara desde la ultima posicion a la primera.
        */
        int descomponiendoNumero = numero;
        int indice=0;
        
        while(true){
            binario[indice++] = descomponiendoNumero % 2;
            if( descomponiendoNumero <= 1 ) return binario;
            descomponiendoNumero /= 2;
            
        }

    }
    
    public static int tamañoListaBinario (int numero){
    
        int tamaño = 0;
        int numeroEnteroMax = 1;
        while(true){
            tamaño++;
            numeroEnteroMax *= 2;
            if(numeroEnteroMax > numero) return tamaño;
        }
    }
    
}

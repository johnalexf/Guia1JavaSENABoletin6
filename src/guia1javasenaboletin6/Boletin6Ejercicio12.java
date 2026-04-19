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
public class Boletin6Ejercicio12 {
    
    public static void solucion (){
        
        System.out.println("12.Ídem con tres números."
                            + "13.Ídem con una tabla.");
        
        int cantidadNumeros = 3;
        int[] numeros = new int[cantidadNumeros];
        
        System.out.printf("Acontinuacion digita %d numeros y calculare el maximo comun divisor\n", cantidadNumeros);
        
        for(int i=0; i<cantidadNumeros ; i++){
            System.out.printf("Escrbia el %d numero :  \n", i+1);
            numeros[i] = Entrada.entero();
        }
        
        int mcd = obtenerMaximoComunDivisor(numeros);
         
        mostrarMaximoComunDivisor(numeros, mcd);
    }
    
    
    public static int obtenerNumeroMenor (int[] listaNumeros){
    
        int numeroMenor = listaNumeros[0];
        
        for(int i=1; i< listaNumeros.length ; i++){
            if(listaNumeros[i] < numeroMenor) 
                numeroMenor = listaNumeros[i];
        }
    
        return numeroMenor;
    }
    
    
    public static int obtenerMaximoComunDivisor( int[] listaNumeros){
        
        boolean verificacionMCD;
        
        for(int i=obtenerNumeroMenor(listaNumeros) ; i>0 ; i++){
            verificacionMCD = true;
            for(int j=0; j<listaNumeros.length ; j++){
                if(listaNumeros[j]%i != 0){
                    verificacionMCD = false;
                    break;
                }                
            }
            if(verificacionMCD) return i;       
        }
        
        return 1;
    }
    
    public static void mostrarMaximoComunDivisor (int[] numeros, int mcd){
        
        
        System.out.println("\n--------------------------------------------");
        System.out.printf("Los numeros ingresados son : \n");
        System.out.println(armarlistaStringDe(numeros));
        System.out.printf("y el maximo comun divisor es : %d \n", mcd);
        System.out.println("--------------------------------------------\n");
    
    }
    
    
    public static String armarlistaStringDe (int[] lista){
        
        StringBuilder armarLista = new StringBuilder();
        
        armarLista.append(" | ");
        for(int i=1; i<=lista.length ; i++){
            if(i%10 == 0) armarLista.append("\n");
            armarLista.append(lista[i-1]).append(" | ");
        }
    
        return armarLista.toString();
    }
    
}

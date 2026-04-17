/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

/**
 *
 * @author JOHN FORERO
 */
public class Boletin6Ejercicio2 {
    
    private static int[] numeros;
    
    public static void solucion(){
            
        System.out.println("2.Diseñar una función que tenga como parámetros "
                        + "\n   dos números, y que calcule el máximo."
                        + "\n3.Ídem una versión que calcule el máximo de 3 números."
                        + "\n4.Ídem una versión que calcule el máximo de una tabla "
                        + "\n   de n elementos.");
        
        int cantNumeros = 2;
        numeros = new int[cantNumeros];
        
        System.out.printf("Escrbe %d numeros ENTEROS y te dire cual es el mayor %n",cantNumeros);
        guardarNumeros();
        
        System.out.printf("El numero mayor es %d %n", buscarNumeroMayor(numeros));
    
    }
    
    private static void guardarNumeros(){
        
        for(int i=0; i<numeros.length ; i++){
            System.out.printf("Numero %d = ",i+1);
            numeros[i] = Entrada.entero();
        }
    
    }
    
    private static int buscarNumeroMayor (int[] listaNumeros){
        
        if(listaNumeros.length !=0){
            int numMayor = listaNumeros[0];

            for(int i=0; i<listaNumeros.length; i++)
                if(listaNumeros[i]>numMayor) numMayor = listaNumeros[i];

            return numMayor;
        }
        System.err.println("La lista no tiene numeros");
        return 0;
    }
    
}

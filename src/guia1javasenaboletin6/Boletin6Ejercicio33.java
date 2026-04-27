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
public class Boletin6Ejercicio33 {
    
    
    public static void solucion(){
    
        System.out.println("33. DUF que calcule el n-ésimo término de la serie de Fibonacci. En esta serie el n-ésimo valor se\n" +
                           "calcula sumando los dos valores anteriores. Es decir \n"
                          + "fibonacci(n) = fibonacci(n1)+fibonacci(n-2), siendo fibonacci(0)=0 y fibonacci(1)=1.\n");
        
        System.out.println("Esciba el numero entero para calcular su Fibonacci");
        int numero = Entrada.entero(true, false, true);
        
        System.out.printf("La serie fibonacci del numero %d es : %d %n%n",
                            numero,
                            serieFibonacci(numero)
                        );
    
    }
    
    public static int serieFibonacci(int numero){
    
        if(numero == 0 || numero == 1) return numero;
        return serieFibonacci(numero-2) + serieFibonacci(numero-1);
        
    }
    
}

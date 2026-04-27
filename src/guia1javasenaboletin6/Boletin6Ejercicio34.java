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
public class Boletin6Ejercicio34 {
    
    public static void solucion(){
    
        System.out.println("34. Igual que el ejercicio anterior, pero pudiendo configurar los valores de los dos primeros término\n" +
                            "de la serie.");
        
        System.out.println("Esciba el numero entero para calcular su Fibonacci");
        int numero = Entrada.entero(true, false, true);
        
        System.out.println("Esta vez te dejare modificar los primeros valores de la serie");
        
        System.out.println("Digita el valor que deseas para Fibonacci(0)");
        int fibonacci0 = Entrada.entero();
        
        System.out.println("Digita el valor que deseas para Fibonacci(1)");
        int fibonacci1 = Entrada.entero();
        
        System.out.printf("La serie fibonacci del numero %d es : %d %n%n",
                            numero,
                            serieFibonacci(numero,fibonacci0,fibonacci1)
                        );
    
    }
    
    public static int serieFibonacci(int numero){
    
        if(numero == 0 || numero == 1) return numero;
        return serieFibonacci(numero-2) + serieFibonacci(numero-1);
        
    }
    
    public static int serieFibonacci(int numero, int fibo0, int fibo1){
    
        if(numero == 0 || numero == 1) return (numero==0)? fibo0 : fibo1 ;
        return serieFibonacci(numero-2,fibo0,fibo1) + serieFibonacci(numero-1,fibo0,fibo1);
        
    }
    
    
}

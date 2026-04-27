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
public class Boletin6Ejercicio31 {
    
    public static void solucion(){
    
        System.out.println("31. Calcular el factorial de n recursivamente.\n");
        
        System.out.println("Escriba un numero entero positivo para calcular su factorial");
        int numero = Entrada.entero(true, false, true);
        
        System.out.printf("\n El factorial del numero %d es : %d \n\n", numero, calcularFactorial(numero));
        
    }
    
    public static int calcularFactorial (int numero){
        
        if(numero == 0)
            return 1;
        else
            return numero * calcularFactorial(numero - 1);
    }
    
}

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
public class Boletin6Ejercicio30 {
    
    public static void solucion(){
    
        System.out.println("30. DUF recursiva que calcule a elevado a la n");
        
        System.out.println("Escriba el valor de a ");
        int a = Entrada.entero();
        
        System.out.println("Escriba el valor de n ");
        int n = Entrada.entero();
        
        System.out.println("Resultado");
        System.out.printf(" %f ", calcularNumElevado(a, n));
        
        
    
    }
    
    public static double calcularNumElevado(int numero, int exponente){
    
        if(exponente >= 0)
            return multiplicarNumHasta(numero, exponente);
        else
            return (1.0 / multiplicarNumHasta(numero, Math.abs(exponente)));
    
    }
    
    public static int multiplicarNumHasta(int numero, int exponente){
    
        if(exponente == 0){
            return 1;
        }else{
            return numero * multiplicarNumHasta(numero, exponente - 1);
        }
       
    }
    
}

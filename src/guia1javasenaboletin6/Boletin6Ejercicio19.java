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
public class Boletin6Ejercicio19 {
    
    public static void solucion(){
    
        System.out.println("19.DUF que calcule a elevado a la n.");
        
        System.out.println("Escriba el valor de a : ");
        int a = Entrada.entero();
        
        System.out.println("Escriba el valor de n :");
        int n = Entrada.entero();
        
        double resultado = elevarNumero(a, n);
        System.out.printf("El resultado es %.5f %s %n", 
                resultado,
                (resultado < 1) ? obtenerStringElevarNumero( a, n) : ""
        );
                
    
    }
    
    
    public static String obtenerStringElevarNumero( int base, int exponente){
    
        int resultado = 1;
        int valorAbsolutoExponente = Math.abs(exponente);
        for(int i=1; i <= valorAbsolutoExponente ; i++ ){
            resultado *= base;
        }
       
        if(exponente < 0) return String.format(" 1 / (%d)", resultado);
        
        return String.format( "%d", resultado);
 
    }
    
     public static double elevarNumero( int base, int exponente){
    
        double resultado = 1;
        int valorAbsolutoExponente = Math.abs(exponente);
        for(int i=1; i <= valorAbsolutoExponente ; i++ ){
            resultado *= base;
        }
       
        if(exponente < 0) return 1/resultado;
        
        return resultado;
 
    }
    
    
    
}

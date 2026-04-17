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
public class Boletin6Ejercicio6 {
    
    public static void solucion(){
        
        System.out.println("6.Función que muestra en pantalla el doble del valor que se le pasa como parámetro.\n\n");
        
        System.out.println("Escribe un valor y te mostrare su doble");
        int numero = Entrada.entero();
        
        mostrarDobleNumero(numero);
        
    }
    
    public static void mostrarDobleNumero( int num ){
    
        System.out.printf("\n El doble del numero %d es %d \n\n", num, num*2);
    
    }
   
}

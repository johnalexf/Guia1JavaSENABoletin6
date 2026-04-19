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
public class Boletin6Ejercicio18 {
     
    public static void solucion(){
    
        System.out.println("18.Diseña una función (en adelante DUF) que decida si un número es primo.");
        
        System.out.println("Escriba un numero y te dire si es primo");
        int numero = Entrada.entero(false, false, true);
        
        System.out.printf("El numero %d, %s es primo \n\n",numero,esPrimo(numero)? "SI" : "NO");
        
    }
    
    public static boolean esPrimo(int numero) {

        int raizNumero = (int) Math.sqrt(numero);
        
        if(numero>1){
            for(int i=2 ; i <= raizNumero ; i++){   
                if(numero%i == 0) return false;    
            }
            /*Si sale del bucle es por que no se pudo dividir por ningun numero entre
                dos y raizNumero, entonces se dice que es primo.
            */
            return true;
        }
        
        /*Segun la logica de arriba si entra en el if(numero>1) si o si se responde, 
            aprovechamos esto para decir que no es primo si es 1 o 0.
        */
        return false;
    }
    
}

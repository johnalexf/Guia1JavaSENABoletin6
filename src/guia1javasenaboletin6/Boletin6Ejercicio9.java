/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

import java.util.ArrayList;

/**
 *
 * @author JOHN FORERO
 */
public class Boletin6Ejercicio9 {
    
    private static ArrayList<Integer> numerosPrimos = new ArrayList<>();
    
    
    
    public static void solucion(){
    
        System.out.println("9.Módulo al que se le pasa un número entero y devuelve el número de divisores primos que tiene.");
        
        System.out.println("Escribe un numero entero y te dire cuantos numeros divisores primos tiene");
        int numeroUsuario = Entrada.entero();
        
        llenarNumerosPrimosHasta(numeroUsuario);
               
        int cantidadDivisoresPrimos = cantidadDivisoresPrimosDe(numeroUsuario);
        
        /*Si el numero de divisores es cero y el numero del usuario es mayor que uno
            significa que el numero es primo, por tanto tiene un divisor primo, que es el mismo"
        */
        if(numeroUsuario>1 && cantidadDivisoresPrimos == 0) cantidadDivisoresPrimos++;
        
            
        mostrarDivisoresDe(numeroUsuario, cantidadDivisoresPrimos);
        
    
    }
    
       
    public static void llenarNumerosPrimosHasta (int numero){
        
        /*Teniendo en cuenta que para formar una lista de numeros primos de 2 hasta N
        si el numero que se esta verificando no es divisible hasta num/2 comparandolo
        con primo de una lista de primos, se determina que el numero es primo;
        asi mismo podemos crear esta lista hasta numero/2 ya que estamos formando 
        la lista de primos para averiguar cuantos divisores primos tiene N.
        */
        int mitadNumero = numero/2;
        
        for(int i=0; i < mitadNumero ; i++){
            if(esPrimo(i)) numerosPrimos.add(i);
        }

    }
    
    
    public static boolean esPrimo(int numero) {

        if(numero>1){
            for(int primo : numerosPrimos){
                if(primo > numero/2)   return true;
                if(numero%primo == 0) return false;    
            }
            /* El primer numero primo es el dos, asi que al crear la lista de primos
                con este return nos aseguramos que se agregue el dos, tambien pudimos
                agregarlo desde otra parte del programa pero aqui manejamos la independencia
            */
            return true;
        }
        
        /*Segun la logica de arriba si entra en el if(numero>1) si o si se responde, 
            aprovechamos esto para decir que no es primo si es 1 o 0.
        */
        return false;
    }
    
    
    public static int cantidadDivisoresPrimosDe (int numero) {
        
        int cantidadDivisores = 0;
        
        
        for(int primo: numerosPrimos){
            if(primo > numero/2)   return cantidadDivisores;
            if(numero%primo == 0) cantidadDivisores++;    
        }
        
        /* En dado caso que numerosPrimos este vacio, significa que se ingreso 
            como numero 1 ó 0, entonces de igual manera se dice que estos 
            numeros no tienen divisoresprimos.
        */
        
        return cantidadDivisores;
       
    }
    
    public static void mostrarDivisoresDe (int numero, int divisores){
        
        System.out.println("\n--------------------------------------------");
        System.out.printf("El numero %d tiene %d divisores primos \n", numero, divisores);
        System.out.println("--------------------------------------------\n");
    
    }
}

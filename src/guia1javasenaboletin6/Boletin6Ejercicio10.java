/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

import java.util.ArrayList;

/**
 *
 * @author johna
 */
public class Boletin6Ejercicio10 {
    
    private static ArrayList<Integer> numerosPrimos = new ArrayList<>();
    private static ArrayList<Integer> divisoresPrimos = new ArrayList<>();
    
    public static void solucion(){
    
        System.out.println("10.Ídem diseñar una función que devuelve una tabla con los divisores.");
        
        System.out.println("Escribe un numero entero y te dire cuantos numeros divisores primos tiene y cuales son");
        int numeroUsuario = Entrada.entero();
        
        llenarNumerosPrimosHasta(numeroUsuario);
               
        int cantidadDivisoresPrimos = cantidadDivisoresPrimosDe(numeroUsuario);
        
        /*Si el numero de divisores es cero y el numero del usuario es mayor que uno
            significa que el numero es primo, por tanto tiene un divisor primo, que es el mismo"
        */
        int[] listaDivisoresPrimos;
        
        if(numeroUsuario>1 && cantidadDivisoresPrimos == 0) {
            cantidadDivisoresPrimos++;
            listaDivisoresPrimos = new int[]{numeroUsuario};
        }else{
            listaDivisoresPrimos = obtenerListaNumerosPrimos();
        }
          
        mostrarDivisoresDe(numeroUsuario, cantidadDivisoresPrimos, listaDivisoresPrimos);
        
    }
    
       
    public static void llenarNumerosPrimosHasta (int numero){
        
        /*Teniendo en cuenta que para formar una lista de numeros primos de 2 hasta N
        si el numero que se esta verificando no es divisible hasta num/2 comparandolo
        con primo de una lista de primos, se determina que el numero es primo;
        asi mismo podemos crear esta lista hasta numero/2 ya que estamos formando 
        la lista de primos para averiguar cuantos divisores primos tiene N.
        */
        int mitadNumero = numero/2;
        
        for(int i=0; i <= mitadNumero ; i++){
            if(esPrimo(i)) numerosPrimos.add(i);
        }

    }
    
    
    public static boolean esPrimo(int numero) {

        if(numero>1){
            for(int primo : numerosPrimos){
                if(primo > Math.sqrt(numero))   return true;
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
            if(numero%primo == 0) {
                divisoresPrimos.add(primo);
                cantidadDivisores++;  
            }  
        }
        
        /* En dado caso que numerosPrimos este vacio, significa que se ingreso 
            como numero 1 ó 0, entonces de igual manera se dice que estos 
            numeros no tienen divisoresprimos.
        */
        
        return cantidadDivisores;
       
    }
    
    public static void mostrarDivisoresDe (int numero, int cantDivisores, int[] divisores){
        
        System.out.println("\n--------------------------------------------");
        System.out.printf("El numero %d tiene %d divisores primos \n", numero, cantDivisores);
        System.out.println("Y la lista de divisores es: \n");
        System.out.println(armarlistaStringDe(divisores));
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
    
    public static int[] obtenerListaNumerosPrimos(){
        
        int[] divisoresPrimosLista = new int[divisoresPrimos.size()];
        
        for(int i=0; i<divisoresPrimos.size(); i++){
            divisoresPrimosLista[i] = divisoresPrimos.get(i);
        }
    
        return divisoresPrimosLista;
    }
     
}

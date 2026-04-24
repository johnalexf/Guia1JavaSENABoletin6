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
public class Boletin6Ejercicio25 {
    
    public static void solucion(){
    
        System.out.println("25. DUF a la que se le pasa una tabla de enteros y un número. Debemos buscar el número en la tabla e\n" +
                            "indicar si se encuentra o no.");
        
        int limite = 1000;
        int cantidadNumeros = 10;
        int[] lista = new int[cantidadNumeros];
        
        rellenarListaAutomaticamente(lista, limite);
        
        System.out.printf("\n Tengo una lista de %d numeros, del 0 al %d \n", cantidadNumeros, limite);
        
        
        
        int numeroUsuario;
        do{   
            System.out.printf("Escribe un numero entre 0 - %d y te dire si esta en mi lista  :   ", limite );    
            numeroUsuario = Entrada.entero(true, false, true);
            if(numeroUsuario <= limite ) break;
            else mostrarError("Señor usuario el numero no esta dentro del rango, intentelo de nuevo");
        }while(true);
        
        
        System.out.printf("El numero %d %s esta dentro de mi lista", 
                numeroUsuario, 
                (estaNumeroEnLista(lista, numeroUsuario)) ? "SI" : "NO" 
        );
        
        mostrarLista(lista);
    
    }
    
    public static boolean estaNumeroEnLista (int[] tabla, int numero){
        
        for(int numeroTabla : tabla){
            if(numeroTabla == numero) return true;
        }
        return false;
    }
    
    public static void rellenarListaAutomaticamente (int[] lista, int limite){
        
        for( int i=0; i<lista.length; i++){
            lista[i] = (int) (Math.random()*limite);
        }
    
    }
    
    public static void mostrarError(String error){
    
        System.out.println("-----------------------------------------------------\n");
        System.out.println(error);
        System.out.println("-----------------------------------------------------\n");
    
    }
    
     public static void mostrarLista (int[] lista){
        
        System.out.println("\n--------------------------------------------");
        System.out.println("\n La lista de numeros es :");
        System.out.println(armarlistaStringDe(lista));
        System.out.println("--------------------------------------------\n");
        
    }
            
    public static String armarlistaStringDe (int[] lista){
        
        StringBuilder armarLista = new StringBuilder();
        
        armarLista.append(" | ");
        for(int i=1; i<=lista.length ; i++){
            armarLista.append(lista[i-1]).append(" | ");
            if(i%10 == 0) armarLista.append("\n").append(" | ");
        }
    
        return armarLista.toString();
    }
    
}

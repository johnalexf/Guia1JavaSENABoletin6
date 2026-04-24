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
public class Boletin6Ejercicio26 {
    
    public static void solucion(){
    
        System.out.println("26. Igual que el ejercicio anterior, pero suponiendo que la tabla no está siempre llena, y el número\n" +
                            "de elementos se pasa también como parámetro.");
        
        int limite = 1000;
        int cantidadNumeros = 10;
        int[] lista = new int[cantidadNumeros];
        
        int numeroElementos = rellenarListaAutomaticamente(lista, limite);
        
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
                (estaNumeroEnLista(lista, numeroElementos, numeroUsuario)) ? "SI" : "NO" 
        );
        
        mostrarListaHasta(lista, numeroElementos);
    
    }
    
    public static boolean estaNumeroEnLista (int[] tabla, int numeroElementos , int numero){
        
        for(int i=0; i<numeroElementos ; i++){
            if(tabla[i] == numero) return true;
        }
        return false;
    }
    
    public static int rellenarListaAutomaticamente (int[] lista, int limite){
        
        /*
         Agregamos que tambien el tamaño de la lista sea un numero al azar diferente de cero
            Es decir entre 1 y el la longitud de la lista
        */
        
        int numeroElementos = (int) (Math.random()*(lista.length - 1) + 1 );
        
        for( int i=0; i<numeroElementos; i++){
            lista[i] = (int) (Math.random()*limite);
        }
    
        return numeroElementos;
        
    }
    
    public static void mostrarError(String error){
    
        System.out.println("-----------------------------------------------------\n");
        System.out.println(error);
        System.out.println("-----------------------------------------------------\n");
    
    }
    
     public static void mostrarListaHasta (int[] lista, int numeroElementos){
        
        System.out.println("\n--------------------------------------------");
        System.out.println("\n La lista de numeros es :");
        System.out.println(armarlistaStringDe(lista, numeroElementos));
        System.out.println("--------------------------------------------\n");
        
    }
            
    public static String armarlistaStringDe (int[] lista, int numeroElementos){
        
        StringBuilder armarLista = new StringBuilder();
        
        armarLista.append(" | ");
        for(int i=1; i<=numeroElementos ; i++){
            armarLista.append(lista[i-1]).append(" | ");
            if(i%10 == 0) armarLista.append("\n").append(" | ");
        }
    
        return armarLista.toString();
    }
    
}

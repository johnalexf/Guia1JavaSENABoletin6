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
public class Boletin6Ejercicio35 {
    
    public static void solucion(){
    
        System.out.println("35. DUF que realice la búsqueda dicotómica en una tabla, de forma recursiva.");
        
        int[] tabla = new int[]{ 2, 4, 6, 8, 12, 43, 76, 123, 234, 235, 345, 456};
        
        
        System.out.println("Digite un numero para buscarlo en la lista");
        int numero = Entrada.entero(true, false, true);
        
        System.out.printf("El numero %d \n", numero);
        int posicion = busquedaNumeroEnTabla(tabla, numero);
        
        if(posicion == -1)
            System.out.println("No esta en la lista");
        else
            System.out.println("Esta en la posicion : " + posicion);
        
    }
    
    public static int busquedaNumeroEnTabla (int[] tabla, int numeroABuscar){
    
        if(tabla.length == 0)
            return -1;
        
        return busquedadDicotomatica(tabla, numeroABuscar, 0, tabla.length-1);
    }
    
    public static int busquedadDicotomatica (int[] tabla, int numeroABuscar, int limInferior, int limSuperior ){
    
        //System.out.printf("limite inferior: %d | limite superior: %d \n", limInferior, limSuperior);
        if(limInferior > limSuperior)
            return -1;
        
        int mitadEntreLimites = (limSuperior - limInferior)/2 + limInferior;
        //System.out.println(mitadEntreLimites);
        
        if(tabla[mitadEntreLimites] == numeroABuscar)
            return mitadEntreLimites; 
        
        if(numeroABuscar > tabla[mitadEntreLimites] )
            return busquedadDicotomatica(tabla, numeroABuscar, mitadEntreLimites+1, limSuperior);

        return busquedadDicotomatica(tabla, numeroABuscar, limInferior, mitadEntreLimites-1);
                
    }
    
}

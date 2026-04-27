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
public class Boletin6Ejercicio32 {
    
    public static void solucion(){
    
        System.out.println("32. DUF que calcule el valor máximo de una tabla de forma recursiva.");
        
        int[] tablaNumeros = new int[]{ 2, 53, 12, 54, 21, 132, 12};
        
        System.out.println("El numero mayor de la lista es: ");
        System.out.println(numeroMayor(tablaNumeros));
                
    }
    
    public static int numeroMayor(int[] tabla){
        if(tabla.length == 0)
            return 0;
        else
            return numeroMayor(tabla, 0);
    }
    
    public static int numeroMayor(int[] tabla, int indice){
        //Nota: para usar la funcion, el indice debe iniciar en 0
        if(indice == tabla.length - 1)
            return tabla[indice];
        int numero = numeroMayor(tabla, indice + 1);
        return (numero > tabla[indice]) ? numero : tabla[indice];
            
    }
}

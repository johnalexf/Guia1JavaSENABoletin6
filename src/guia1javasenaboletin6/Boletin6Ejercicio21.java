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
public class Boletin6Ejercicio21 {
    
    public static void solucion(){
    
        System.out.println("21. Escriba una función que sume los n primeros números impares.");
        
        System.out.println("Digite el numero hasta donde quieres que sume los primeros numeros impares");
        int limite = Entrada.entero(false, false, true);
        
        mostrarNumeroSumaImpares(limite, sumaNumerosImparesHasta(limite));
        
    }
    
    public static int sumaNumerosImparesHasta(int limite){
        
        int sumaImpares = 0;
        
        /*como no nos estan pidiendo los numeros impares, no tenemos que guardarlos
            entonces usamos la formula de un numero impar hasta el limite determinado
        */
        for(int i = 0; i<limite ; i++){
           sumaImpares += 2*i + 1; 
        }
        
        return sumaImpares;
        
    }
    
    public static void mostrarNumeroSumaImpares (int limite, int suma){
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf("La suma de los numeros impares hasta %d es igual a : %d \n", limite, suma);
        System.out.println("------------------------------------------------------------------\n");
    }
    
    
}

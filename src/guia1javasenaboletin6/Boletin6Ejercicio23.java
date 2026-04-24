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
public class Boletin6Ejercicio23 {
    
    public static void solucion(){
    
        System.out.println("23. Diseñar una función que calcule la distancia euclídea de dos puntos.");
        
        System.out.println("\nVamos a calcular la distancia euclidea de dos puntos");
        
        
        double[][] coordenadasDePuntos = new double[2][2];
        /*
        coordenadasDePuntos en la primera posicion se va manejar cada punto, en la segunda las coordenadas
        para x coordenadasDePuntos[punto][0] y para y coordenadasDePuntos[punto][1]
        */
        for( int punto=0 ; punto < coordenadasDePuntos.length ; punto++){
            System.out.printf("Escriba las coordenadas del punto %d  \n", punto + 1);
            System.out.printf("Coordenada X  :  ");
            coordenadasDePuntos[punto][0] = Entrada.real();
            System.out.printf("Coordenada Y  :  ");
            coordenadasDePuntos[punto][1] = Entrada.real();
        }
        
        mostrarResultado(calcularDistanciaEuclideaDeDosPuntos(coordenadasDePuntos[0], coordenadasDePuntos[1]));
        
    }
    
    public static double calcularDistanciaEuclideaDeDosPuntos(double[] punto1, double[] punto2){
    
        return Math.sqrt(
                Math.pow((punto1[0]-punto2[0]),2) + 
                Math.pow((punto1[1]-punto2[1]),2)  
        );    
    }
    
    public static void mostrarResultado (double resultado){
        
        System.out.println("\n---------------------------------------------\n");
        System.out.printf("El resultado es %.2f" , resultado);
        System.out.println("\n---------------------------------------------\n");
    
    }
}

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
public class Boletin6Ejercicio22 {
    
    
    public static void solucion(){
    
        System.out.println("22. Dado el valor de un ángulo, sería interesante saber su seno, coseno y tangente. Escribir una\n" +
                            "función que muestre en pantalla los datos anteriores. ");
        
        
        System.out.println("\nEscriba un angulo en grados:");
        double anguloGrados = Entrada.real(true, true, true);
        double anguloRadianes = Math.toRadians(anguloGrados);
        
        double seno = calcularSeno(anguloRadianes);
        double coseno = calcularCoseno(anguloRadianes);
        
        System.out.println("\n-------------------------------------------------\n");
        mostrarResultado("Seno", anguloGrados, seno);
        mostrarResultado("Coseno", anguloGrados, coseno);
        mostrarResultado("Tangente", anguloGrados, calcularTangente(seno, coseno));
        System.out.println("\n-------------------------------------------------\n");
    }
    
    
    public static double calcularSeno(double anguloEnRadianes){
        return Math.sin(anguloEnRadianes);
    }
    
    public static double calcularCoseno(double anguloEnRadianes){
        return Math.cos(anguloEnRadianes);
    }
    
    public static double calcularTangente(double seno, double coseno){
        
        if( Math.abs(coseno) < 0.000001 ){
            if(seno < 0 ) return Double.NEGATIVE_INFINITY;
            else          return Double.POSITIVE_INFINITY;
        }
        
        return seno/coseno;
    }
    
    public static void mostrarResultado( String calculo, double anguloGrados, double resultado){
        System.out.printf("El(la) %s del angulo %.2f es igual a : %.2f \n", calculo, anguloGrados, resultado );
    }
    
}

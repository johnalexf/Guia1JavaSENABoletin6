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
public class Boletin6Ejercicio8 {
    
        public static void solucion(){
    
        System.out.println("Ídem que devuelva una tabla con el área y el volumen\n\n");
    
        int radio, altura;
        char opcion;
        
        System.out.println("Escriba el radio de un cilindro");
        radio = Entrada.entero(false, false, true);
        
        System.out.println("Escriba la altura del cilindro");
        altura = Entrada.entero(false, false, true);
        
         
        double[] resultados = calcularAreaOVolumenCilindro(radio, altura);
        
        System.out.printf("El area es %.2f \n", resultados[0]);
        System.out.printf("Elvolumen es %.2f \n", resultados[1]);
                  
    }
    
    public static double[] calcularAreaOVolumenCilindro(int r, int h){
   
        return new double[]{(2*Math.PI*r)*(h+r),(Math.PI*r*r*h)};
 
    }
    
}

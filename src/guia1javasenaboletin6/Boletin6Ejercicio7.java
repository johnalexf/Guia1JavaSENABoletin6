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
public class Boletin6Ejercicio7 {
    
    public static void solucion(){
    
        System.out.println("7.Realizar una función que calcule (muestre en pantalla) el área o el volumen de un cilindro, según \n" +
                            "se especifique. Para distinguir un caso de otro se le pasará el carácter 'a' (para área) o 'v' \n" +
                            "(para el volumen). Además hemos de pasarle a la función el radio y la altura.");
    
        int radio, altura;
        char opcion;
        
        System.out.println("Escriba el radio de un cilindro");
        radio = Entrada.entero(false, false, true);
        
        System.out.println("Escriba la altura del cilindro");
        altura = Entrada.entero(false, false, true);
        
        boolean ciclo = true;
        while(ciclo){
        
            System.out.println("--------------------------------------------");
            System.out.println("Menu");
            System.out.println("Para calcular el area escriba 'a'");
            System.out.println("Para calcular el volumen escriba 'v'");
            System.out.println("Para salir escriba 's'");
            opcion = Entrada.caracter();
            
            switch(opcion){
                case 'a': case 'v': 
                    calcularAreaOVolumenCilindro(radio, altura, opcion); 
                    break;
                case 's': 
                    ciclo = false; 
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            
        
        }
    }
    
    public static void calcularAreaOVolumenCilindro(int r, int h, char eleccion ){
    
        System.out.println("\"--------------------------------------------");
        
        switch(eleccion){
            case 'a':
                System.out.printf("El area de un cilindro es %.2f \n", (2*Math.PI*r)*(h+r) );
                break;
            case 'v':
                System.out.printf("El volumen de un cilindro es %.2f \n", (Math.PI*r*r*h) );
                break;
            default:
                System.err.println("Opcion no valida");
                break;
        
        }
    
    
    }
    
}

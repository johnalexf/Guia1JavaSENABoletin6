/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

/**
 *
 * @author johna
 */
public class Boletin6Ejercicio11 {

    public static void solucion(){
        
        System.out.println("11.Escribir una función que calcule el máximo común divisor de dos números.");
        
        int numero1, numero2;
        
        System.out.println("Escribe el primer numero");
        numero1 = Entrada.entero();
        
        System.out.println("Escribe el segundo numero");
        numero2 = Entrada.entero();
        
        mostrarMaximoComunDivisor(
                numero1, 
                numero2, 
                calcularMaximoComunDivisorDeDosNumeros(numero1, numero2)
        );
        
        
    }
    
    public static int calcularMaximoComunDivisorDeDosNumeros(int num1,int num2){
    
        // numerosOrdenados[0]: numero menor // numerosOrdenados[1]: numero mayor
        int[] numerosOrdenados = determinarNumeroMenorYMayor(num1, num2);
        int mcd = 1;
        for(int i=numerosOrdenados[0] ; i > 0 ; i--){
            if(numerosOrdenados[1] % i == 0 && numerosOrdenados[0] % i == 0){
                mcd = i;
                return mcd;
            }
        }
        
        return 1;

    }
    
    public static int[] determinarNumeroMenorYMayor(int num1, int num2 ) {
        
        if(num1<num2){
            return new int[]{num1, num2};
        }else{
            return new int[]{num2, num1};
        }
     
        //return new int[]{numero menor, numero mayor};
    }
    
        public static void mostrarMaximoComunDivisor (int num1, int num2, int mcd){
        
        System.out.println("\n--------------------------------------------");
        System.out.printf("El Maximo Comun Divisor de %d y %d es: %d \n", num1, num2,mcd);
        System.out.println("--------------------------------------------\n");
    
    }
}

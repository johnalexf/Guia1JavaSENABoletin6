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
public class Boletin6Ejercicio17 {
    
    public static void solucion(){
    
        System.out.println("17.Escriba una función que decida si dos números enteros positivos son amigos. Dos números son \n" +
                            "amigos, si la suma de sus divisores (distintos de ellos mismos) son iguales.\n\n");
        
        System.out.println("Escriba el primer numero");
        int numero1 = Entrada.entero(false, false, true);
        
        System.out.println("Escriba el segundo numero");
        int numero2 = Entrada.entero(false, false, true);
        
        if(sonNumerosAmigos(numero1,numero2))
            System.out.println("Los numeros son amigos");
        else
            System.out.println("Los numeros no son amigos");
        
    }
    
    public static boolean sonNumerosAmigos(int num1, int num2){
       
        return (sumarDivisoresDe(num1) == num2)&&(sumarDivisoresDe(num2) == num1);
    }
    
    public static int sumarDivisoresDe(int num){
    
        int mitadNumero = num/2;
        int sumaDivisores = 1;
        
        for(int i=2; i<= mitadNumero ; i++){
            if(num%i == 0) sumaDivisores += i;
        }
        
        return sumaDivisores;
    }
    
    
}

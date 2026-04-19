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
public class Boletin6Ejercicio14 {
    
    public static void solucion(){
    
        System.out.println("14.Escribir una función que calcule el mínimo común múltiplo de dos números."
                + "15.Ídem con tres números."
                + "16.Ídem con una tabla.");
        
        int cantNumeros = 5;
        
        System.out.printf("\n\nA continuacion escriba una lista de %d para calcular en minimo comun multiplo\n\n",cantNumeros);
        
        int[] listaNumeros = obtenerListaNumeros(cantNumeros);
        
        int mcm = calcularMinimoComunMultiplo(listaNumeros);
        
        mostrarMinimoComunMultiplo(listaNumeros, mcm);
        
    }
    
    public static int calcularMinimoComunMultiplo(int [] listaNumeros){
    
       /*
        Para calcular el minimo comun multiplo de dos numeros, vamos a descomponer cada uno
        al tiempo por los numeros primos, empezando con el 2, si uno no es divisible se mantiene igual
        pero el otro si cambia a la division por el numero primo, ejemplo
        
        8  6 | 2
        4  3 | 2
        2  3 | 2
        1  3 | 3
        1
        
        asi tenemos que el mcm de 8 y 6 es 2*2*2*3 = 24
        
        Ahora bien, no vamos a calcular los numeros primos, por que al calcualr los numeros primos practicamente tenemos que
        hacer un recorrido de 1 hasta el numero mayor, y tenemos que volver a hacer otro recorrido dentro de una lista de primos
        para hacer la descomposicion, entonces vamos a aplicar la logica para hacer un solo recorrido ya que si hacemos la descomposicion
        y usamos el 2 cuando pasemos al 4, ninguno va ser divisible por 4 por que el 2 hizo la division hasta donde ya no es divisible en 2
        asi que esto permite con un solo recorrido que hariamos con los primos, hacerlo con los numeros directamente.
      
        */
        
        int[] descomposicionNumeros = listaNumeros.clone();
        int mcm = 1;
        int divisor=2;
        int numeroMayor = obtenerNumeroMayor(listaNumeros);
        boolean continuar = true, aumentarDivisor;
        
        while(continuar && divisor <= numeroMayor ){
            aumentarDivisor = true;
            for(int i=0 ; i<descomposicionNumeros.length; i++){
                if(descomposicionNumeros[i]%divisor == 0){
                    descomposicionNumeros[i] = descomposicionNumeros[i]/divisor;
                    aumentarDivisor = false;
                }       
            }
            if(aumentarDivisor) divisor++;
            else mcm *= divisor;
            
            continuar = false;
            for(int i=0 ; i<descomposicionNumeros.length; i++){
                if(descomposicionNumeros[i] != 1){
                    continuar = true;
                    break;
                }
            }
        }
        
        return mcm;
        
    }
    
    public static int obtenerNumeroMayor (int[] listaNumeros){
    
        int numeroMayor = listaNumeros[0];
        
        for(int i=1; i< listaNumeros.length ; i++){
            if(listaNumeros[i] > numeroMayor) 
                numeroMayor = listaNumeros[i];
        }
    
        return numeroMayor;
    }
    
    
    public static int[] obtenerListaNumeros(int cantNumeros){
        int[] listaNumeros = new int[cantNumeros];
        
        for(int i=0; i < cantNumeros ; i++){
            System.out.printf("Escriba el numero #%d = \n",i+1);
            listaNumeros[i] = Entrada.entero( false, false, true);
        }
        
        return listaNumeros;
    }
    
    
    public static void mostrarMinimoComunMultiplo (int[] numeros, int mcm){
         
        System.out.println("\n--------------------------------------------");
        System.out.printf("Los numeros ingresados son : \n");
        System.out.println(armarlistaStringDe(numeros));
        System.out.printf("y el minimo comun multiplo es : %d \n", mcm);
        System.out.println("--------------------------------------------\n");
    
    }
    
    
    public static String armarlistaStringDe (int[] lista){
        
        StringBuilder armarLista = new StringBuilder();
        
        armarLista.append(" | ");
        for(int i=1; i<=lista.length ; i++){
            if(i%10 == 0) armarLista.append("\n");
            armarLista.append(lista[i-1]).append(" | ");
        }
    
        return armarLista.toString();
    }
    
}

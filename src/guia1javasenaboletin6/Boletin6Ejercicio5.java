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
public class Boletin6Ejercicio5 {
 
    
    public static void solucion(){
    
    
        System.out.println("5.Función a la que se le pasan dos enteros y muestra todos los números comprendidos entre ellos, \n" +
                            "inclusive.");
    
        int entero1, entero2;
        
        System.out.println("\nEscribe dos numeros y te mostrare todos los numeros que hay entre ellos");
        System.out.printf("Numero 1 : ");
        entero1 = Entrada.entero();
        System.out.printf("Numero 2 : ");
        entero2 = Entrada.entero();
        
        mostrarNumerosEntre(entero1, entero2);
        
    
    }
    
    public static void mostrarNumerosEntre (int num1, int num2){
    
        StringBuilder mensaje = new StringBuilder();
        
        if( num1 == num2 ){
            mensaje.append("\nJA JA JA Muy chistosito\n");
        }
        
        if( num1 > num2 )
            mensaje.append(armarMensajeNumerosEntre(num2, num1));
        else
            mensaje.append(armarMensajeNumerosEntre(num1, num2));
        
        System.out.println(mensaje);
        
    
    }
    
    public static String armarMensajeNumerosEntre (int menor, int mayor){
        
        StringBuilder mensaje = new StringBuilder();
        int contadorSaltoLinea = 1;
        
        String formateandoMensajeIncial = String.format("\n Los numeros entre %s y %s son: \n", menor, mayor);
        
        mensaje.append(formateandoMensajeIncial)
               .append(" | ");
        for( int i=menor ; i<=mayor; i++ ){
            if(contadorSaltoLinea++ % 10 == 0)
                mensaje.append("\n");
            mensaje.append(i).append(" | ");       
        }
        
        return mensaje.toString();
    }
    
    
}

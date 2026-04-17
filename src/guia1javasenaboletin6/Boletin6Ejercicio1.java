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
public class Boletin6Ejercicio1 {
    
    public static void solucion(){
    
        System.out.println("1.Realizar una función, a la que se le pase como parámetro un número N, y muestre por pantalla N \n" +
                        "veces, el mensaje: “Módulo ejecutándose”");
        
        
        String mensaje = "Módulo ejecutándose";
        
        System.out.printf("Escriba el numero de veces que quiere ver el mensaje (%s) %n",mensaje);
        int n = Entrada.entero(false, false, true);
        
        System.out.printf("El mensaje (%s) se repetira %d veces %n",mensaje,n);
        System.out.println("Escriba S y presione enter para comenzar");
        Entrada.texto();
        
        mostrarMensajeRepetido(n, mensaje);
    
    }
    
    public static void mostrarMensajeRepetido(int n, String mensaje){
        for(int i=1; i<=n ; i++){
            System.out.printf("Menssaje _ #%d : %s %n",i,mensaje);        
        }
    
    }
    
}

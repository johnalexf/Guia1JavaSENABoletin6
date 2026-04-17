/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author JOHN FORERO
 */
public class Entrada {
    
   private static final BufferedReader acumuladorMensaje = new BufferedReader(new InputStreamReader(System.in));
    
    public static String capturarTexto(){
    
        try {
            return acumuladorMensaje.readLine();
        } catch (Exception e) {
            System.err.println("Error al leer los datos");
            return "";
        }
 
    }
    
    public static int entero( boolean permiteCero, boolean permiteNegativos, boolean permitePositivos ){
        int entero;
        boolean numeroValido;
        String mensajeError;
        
        if( !permiteCero && !permiteNegativos && !permitePositivos){
            System.err.println("Señor programador al menos una de las opciones debe estar en true o se genera un bucle infinito");
            return 0;
        }
        
        while(true){
            try {
                mensajeError = "";
                numeroValido = true;
                entero = Integer.parseInt(capturarTexto());
                
                if(!permiteCero && entero == 0){
                    numeroValido = false;
                    mensajeError += "\n El numero no puede ser 0";
                }
                
                if(!permiteNegativos && entero < 0){
                    numeroValido = false;
                    mensajeError += "\n El numero no puede ser negativo";
                }
                
                if(!permitePositivos && entero > 0){
                    numeroValido = false;
                    mensajeError += "\n El numero no puede ser positivo";
                }
                
                if (numeroValido)
                    return entero;
                else
                    System.err.println(mensajeError);
                        
                
            } catch (NumberFormatException e) {
                System.err.println("El formato no es valido");
                System.out.println("Porfavor ingrese un numero ENTERO segun lo solicitado");
            }
        }
    
    }
    
    public static int entero(){
        return entero(true,true,true);
    }
    
    public static double real(boolean permiteCero, boolean permiteNegativos, boolean permitePositivos){
    
        double real;
        boolean numeroValido;
        String mensajeError;
        
        if( !permiteCero && !permiteNegativos && !permitePositivos){
            System.err.println("Señor programador al menos una de las opciones debe estar en true o se genera un bucle infinito");
            return 0;
        }
        
        while(true){
            try {
                mensajeError = "";
                numeroValido = true;
                real = Double.parseDouble(capturarTexto());
                
                if(!permiteCero && real == 0){
                    numeroValido = false;
                    mensajeError += "\n El numero no puede ser 0";
                }
                
                if(!permiteNegativos && real < 0){
                    numeroValido = false;
                    mensajeError += "\n El numero no puede ser negativo";
                }
                
                if(!permitePositivos && real > 0){
                    numeroValido = false;
                    mensajeError += "\n El numero no puede ser positivo";
                }
                
                if (numeroValido)
                    return real;
                else
                    System.err.println(mensajeError);
                        
                
            } catch (NumberFormatException e) {
                System.err.println("El formato no es valido");
                System.out.println("Porfavor ingrese un numero DOUBLE segun lo solicitado");
            }
        }
    
    }
    
    public static double real(){
        return real(true, true, true);
    }
    
    static String texto(){
        
        String texto = capturarTexto();
        while(texto.trim().isEmpty()){ // Opcional: valida que no sea solo espacios o vacío
            System.err.println("El texto no puede estar vacío.");
            System.out.printf("Por favor escriba un TEXTO segun lo solicitado = ");
            texto = capturarTexto();
        }
        return texto.trim();
 
    }
    
     static char caracter(){
        
        while(true){
            try {
                String entrada = capturarTexto().trim();
                if (entrada.length() == 1) {
                    return entrada.charAt(0);
                } else {
                    System.err.println("Error: debes escribir exactamente UN caracter.");
                    System.out.print("Intenta de nuevo :  ");
                }
            } catch (Exception e) { // Cambiamos a Exception para capturar si está vacío
                System.err.printf("%nError al capturar el caracter%n");
                System.out.printf("Por favor escriba un CARACTER segun lo solicitado = ");
            }
        }
        
     } 
}

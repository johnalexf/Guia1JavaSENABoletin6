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
public class Boletin6Ejercicio29 {
    
    
    public static void solucion(){
    
        System.out.println("29. DUF que toma como parámetros dos tablas. La primera con los 6 números de una apuesta de la\n" +
                            "primitiva, y la segunda con los 6 números ganadores. La función debe devolver el número de\n" +
                            "aciertos.\n");
        
        
        int cantNumeros = 6;
        int[] rangoNumerosPemitidos = new int[]{1, 49};
        int[] listaNumerosGanadores = new int[cantNumeros];
        int[] listaNumerosSeleccionados = new int[cantNumeros];
        
        llenarListaDeNumAleatoriosNoRepetidos(listaNumerosGanadores, rangoNumerosPemitidos[0], rangoNumerosPemitidos[1]);
        llenarListaDeNumAleatoriosNoRepetidos(listaNumerosSeleccionados, rangoNumerosPemitidos[0], rangoNumerosPemitidos[1]);
        
        System.out.println("Numeros Ganadores");
        mostrarListaNumeros(listaNumerosGanadores);
        
        System.out.println("Numeros Seleccionados por el apostador");
        mostrarListaNumeros(listaNumerosSeleccionados);
        
        System.out.printf("Numero de aciertos %d \n", cantidadNumIgualesEnDosListas(listaNumerosGanadores, listaNumerosSeleccionados));
        
    }
    
    public static int generarNumeroAleatorioEntre(int limiteInferior, int limiteSuperior){  
        return (int) (Math.random() * (limiteSuperior - limiteInferior + 1) + limiteInferior);
    }
    
    public static boolean estaNumRepetidoEnLista(int[] lista, int numerosAlmacenados, int numeroAComprobar){ 
        for(int i=0; i<numerosAlmacenados ; i++){
            if( lista[i] == numeroAComprobar ) return true;
        }     
        return false;
    }
    
    public static void llenarListaDeNumAleatoriosNoRepetidos(int[] lista, int limInferior, int limSuperior){
    
        int numerosAlmacenados = 0;
        for(int i=0 ; i<lista.length ; i++){
            do{
                lista[i] = generarNumeroAleatorioEntre(limInferior, limSuperior);
            }while(  estaNumRepetidoEnLista(lista, numerosAlmacenados, lista[i])  );
            numerosAlmacenados++;
        }
    }
    
    public static void mostrarListaNumeros(int [] lista){
    
        System.out.println("-------------------------------------------------");
        System.out.println(listaAString(lista));
        System.out.println("-------------------------------------------------\n");

    }
    
    public static String listaAString(int[] lista){
        
        StringBuilder listaAString = new StringBuilder();
        String separador = " | ";
        
        listaAString.append(separador);
        for(int numero: lista){
            listaAString.append( String.format("%02d", numero))
                        .append( separador );
        }
        
        return listaAString.toString();
        
    }
    
    public static int cantidadNumIgualesEnDosListas(int[] lista1, int[] lista2){
    
        int cantNumIguales = 0;
        for(int numeroLista1 : lista1){
            for(int numeroLista2 : lista2){
                if(numeroLista1 == numeroLista2){
                    cantNumIguales++;
                    break;
                }
            }
        }
        
        return cantNumIguales;
    }
    
}

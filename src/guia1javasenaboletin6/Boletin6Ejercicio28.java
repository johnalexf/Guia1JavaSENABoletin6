/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1javasenaboletin6;

import java.util.ArrayList;

/**
 *
 * @author JOHN FORERO
 */
public class Boletin6Ejercicio28 {
    
    public static void solucion(){
    
        System.out.println("28. DUF que ordene la tabla que se le pasa.");
        
        int[] listaNumeros;
        int tamañoLista = 1000000, limiteRangoNumeros = 10000;
        
        listaNumeros = new int[tamañoLista];
        
        rellenarListaNumEnterosPositivosAleatorios(listaNumeros, limiteRangoNumeros);
        
        mostrarlista(listaNumeros);
        
        ordenarListaDeFormaAscendente(listaNumeros);
        
        System.out.println("Lista ORDENADA");
        mostrarlista(listaNumeros);
    
    }
    
    
    // Funcion para calcular un numero entero aleatorio entre dos limites.
    public static int numeroAleatorioEntero(int limiteInferior, int limiteSuperior){
        return (int) (  (Math.random()*(limiteSuperior - limiteInferior)) +  limiteInferior  );
    }
    
    //Funcion para rellenar una lista con numeros enteros positivos aleatorios entre 0 hasta un limite.
    public static void rellenarListaNumEnterosPositivosAleatorios(int[] listaNumeros, int limiteRangoNumeros){
       
        for(int i=0 ; i< listaNumeros.length ; i++){
            listaNumeros[i] = numeroAleatorioEntero( 0 , limiteRangoNumeros);
        }
        
    }
    
    //Funcion para mostrar cualquier lista de tipo entero.
    public static void mostrarlista(int[] lista){
    
        System.out.println("-------------------------------------------------------------");
        System.out.println(listaToString(lista));
        System.out.println("\n-------------------------------------------------------------\n");
    
    }
    
    //Funcion para poder extraer los valores de una lista y pasarlos a un String con el fin de mejorar 
    // el rendimiento, evitando imprimir cada valor ahora se va imprimir todo con una sola instruccion.
    public static String listaToString (int[] lista){
        
        StringBuilder listaString = new StringBuilder();
        String separador = "  |  ";
        
        for(int i=0; i<lista.length ; i++){
            if(i%10 == 0) listaString.append("\n").append(separador);
            listaString.append(lista[i]).append(separador);
        }
        
        return listaString.toString();
    }
    
    
    
    //Funcion para ordentar una lista de numeros enteros de forma ascendente
    public static void ordenarListaDeFormaAscendente (int[] listaNumeros){
    
        ArrayList<int[]> rangosPendientes = new ArrayList<>();
        agregarRango(rangosPendientes, 0, (listaNumeros.length-1));
        
        while(rangosPendientes.size()>0){
        
            //Test rangos pendientes
            //verRangosPendientesParaTesteo(rangosPendientes);
            
           /* mostrarValoresParaTesteo("Verificacion de valores limites que van a ser evaluados :", 
                                        new String[]{"limite inicial", "limite final"}, 
                                        new int[] { rangosPendientes.get(0)[0], rangosPendientes.get(0)[1]});
            */
            ordenarSeccionDeLista(listaNumeros,
                                   rangosPendientes.get(0)[0], 
                                   rangosPendientes.get(0)[1], 
                                   rangosPendientes);
            
        }
        
    }
    
    public static void ordenarSeccionDeLista(int[] listaNumeros, int limiteInferior, int limiteSuperior, ArrayList<int[]> rangosPendientes){
    
        int indiceAleatorio = numeroAleatorioEntero(limiteInferior, limiteSuperior);
        int numeroPivote = listaNumeros[indiceAleatorio];
        int cantNumMayores = 0;
        int cantNumMenores = 0;
        int indiceAEvaluar = limiteInferior;
        

        while( indiceAEvaluar <= (limiteSuperior - cantNumMayores) ){
//            mostrarValoresParaTesteo("Verificacion depaso a paso de ordenamiento de numeros", 
//                                        new String[]{"indice a evaluar", "pivote", "numero a evaluar"}, 
//                                        new int[] { indiceAEvaluar, numeroPivote, listaNumeros[indiceAEvaluar] });
         /*   mostrarValoresParaTesteoMejorado("Verificacion de paso a paso de ordenamiento de numeros", 
                                                "indice a evaluar", indiceAEvaluar,
                                                "Pivote", numeroPivote,
                                                "numero a evaluar", listaNumeros[indiceAEvaluar]
                                                );
            */
            if( listaNumeros[indiceAEvaluar] > numeroPivote ){
                intercambiarDosValoresEnUnaLista(listaNumeros, indiceAEvaluar, limiteSuperior - cantNumMayores++ );
            }else{
                intercambiarDosValoresEnUnaLista(listaNumeros, indiceAEvaluar, limiteInferior + cantNumMenores);
                /* Como la idea es dejar los numeros iguales al pivote y hasta el mismo pivote en la posicion que divide a los num mayores
                   con los menores este no se va tener en cuenta en la suma de cantNumMenores, para que los numeros menores que se encuentren 
                   lo vayan desplazando.
                */
                //ERROR if( listaNumeros[indiceAEvaluar] != numeroPivote ) cantNumMenores++;
                //Al mover el numero este ya no esta en indiceAEvaluar, ahora esta es en limiteInferior + cantNumMenores
                if( listaNumeros[limiteInferior + cantNumMenores] != numeroPivote ) cantNumMenores++;
                
                indiceAEvaluar++;
            }
            //Evaluacion de cambios
//                mostrarValoresParaTesteo("Verificacion de aumento de variables de control", 
//                                        new String[]{ "num Mayores", "num Menores"}, 
//                                        new int[] { cantNumMayores, cantNumMenores});
        /*  mostrarValoresParaTesteoMejorado("Verificacion de aumento de variables de control", 
                                                "num Mayores", cantNumMayores,
                                                "num Menores", cantNumMenores
                                                );
                mostrarlista(listaNumeros);
           */ 
        }
        
        
        
        actualizarRangos(rangosPendientes, limiteInferior, cantNumMenores, limiteSuperior, cantNumMayores);
         
    }
    
    
    // funcion para agregar un nuevo rango a la lista de rangos.
    public static void agregarRango (ArrayList<int[]> listaRangos, int limiteInferior, int limiteSuperior ){
        listaRangos.add(new int[]{limiteInferior , limiteSuperior});
    }
    
    /*funcion para agregar cada rango nuevo que se va aislando segun el pivote, 
        pero que no tiene en cuenta la posicion del pivote para no volver a analizarlo ya que 
        el pivote esta ubicado en donde va quedar definitivamente.
    */
    public static void actualizarRangos(ArrayList<int[]> listaRangos, int limiteInferior , int numMenores , int limiteSuperior , int numMayores  ){
        listaRangos.remove(0);
        if(numMenores > 1 )
            agregarRango(listaRangos, limiteInferior , limiteInferior + (numMenores-1));
        if(numMayores > 1)
            agregarRango(listaRangos, limiteSuperior - (numMayores - 1) , limiteSuperior);
        // Se corrije error en el indice donde intervenia los numeros mayor y menor, agregandole un -1
        // Ya que al estar hablando de indices tenemos que restar 1 
    }
    
    
    //funcion para intercambiar dos valores de una lista segun sus indices.
    public static void intercambiarDosValoresEnUnaLista (int[] lista, int indice1, int indice2){
        
        int valorAIntercambiar = lista[indice1];
        lista[indice1] = lista[indice2];
        lista[indice2] = valorAIntercambiar;
    
    }
    
    
    
    
    public static void mostrarValoresParaTesteo (String situacion, String[] nombresValores, int[] valores){
    
        StringBuilder acumuladorMensaje = new StringBuilder();
        String separador = "  |  ";
        
        acumuladorMensaje.append(situacion).append("\n");
        for(int i=0; i<valores.length ; i++){
            acumuladorMensaje.append(separador)
                              .append(nombresValores[i])
                              .append(" = ")
                              .append(valores[i]);
        }
         acumuladorMensaje.append(separador);
        
        
        System.out.println(acumuladorMensaje);
    }
    
    
    
    public static void mostrarValoresParaTesteoMejorado (String situacion, Object... parejas){
    
         // Validación por si falta un valor en una pareja
        if (parejas.length % 2 != 0) {
            System.out.println("Error: El test de '" + situacion + "' tiene un número impar de argumentos.");
            return;
        }
        
        StringBuilder acumuladorMensaje = new StringBuilder();
        String separador = "  |  ";
        
        acumuladorMensaje.append(situacion).append("\n");
        for(int i=0; i<parejas.length ; i+= 2){
            acumuladorMensaje.append(separador)
                              .append(parejas[i])
                              .append(" = ")
                              .append(parejas[i+1]);
        }
         acumuladorMensaje.append(separador).append("\n");;
        
        
        System.out.println(acumuladorMensaje);
    }
    
    
    public static void verRangosPendientesParaTesteo (ArrayList<int[]> rangosPendientes){
    
        if(rangosPendientes.isEmpty()){
            System.out.println("El rango de particiones pendientes esta vacio");
            return;
        }
        
        StringBuilder acumuladorMensaje = new StringBuilder();
        String separador = "  |  ";
        
        acumuladorMensaje.append("Valores del array list rango de particiones pendientes por evaluar:").append("\n");
        rangosPendientes.forEach(rango -> {
            acumuladorMensaje.append(separador)
                    .append("limite inferior").append(" = ").append(rango[0]).append(separador)
                    .append("limite superior").append(" = ").append(rango[1]).append(separador)
                    .append("\n");
        });
        
        System.out.println(acumuladorMensaje);

    }
    
    
    
    
    
}

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
public class Boletin6Ejercicio27 {
    
    public static final String OPCIONES_STRING = 
                "Escoja una de las siguientes opciones para operar las tablas o terminar el programa" +
                "\n 's' - sumar" + 
                "\n 'r' - restar" + 
                "\n 'm' - multiplicar" + 
                "\n 'd' - dividir" +
                "\n 'T' - Terminar programa" +
                "Escriba la opcion que desea realizar"
                ;
    
    public static void solucion(){
    
        System.out.println("27.Diseñar la función opera_tabla, a la que se le pasa dos tablas, el número de elementos útiles y\n" +
                            "que operación se desea realizar: sumar, restar, multiplicar o dividir (mediante un carácter: 's',\n" +
                            "'r', 'm', 'd'). La función debe devolver una tabla con los resultados.");
        
        int limite=100;
        
        double[] lista1 = new double[13];
        double[] lista2 = new double[18];
        
        int numElemLista1 = rellenarListaAutomaticamente(lista1, limite);
        int numElemLista2 = rellenarListaAutomaticamente(lista2, limite);
        
        int numElemMenor = (numElemLista1 < numElemLista2) ? numElemLista1 : numElemLista2;
        
        System.out.println("Señor usuario tenemos estas dos tablas");
        System.out.println("Tabla 1 : ");
        mostrarListaHasta(lista1, numElemMenor);
        System.out.println("Tabla 2 : ");
        mostrarListaHasta(lista2, numElemMenor);
        
        
        double[] listaResultante;
        char opcion;
        boolean continuar = true;
        
        while(continuar){
            mostrarOpciones();
            opcion = Entrada.caracter();
            
            switch (opcion){
                case 's': case 'r' : case 'm' : case 'd' :
                    listaResultante = opera_tabla(lista1, lista2, numElemMenor, opcion);
                    System.out.println("La tabla resultante es : ");
                    mostrarListaHasta(listaResultante, listaResultante.length);
                    break;
                
                case 'T':
                    continuar = false;
                    break;
                
                default:
                    mostrarError("La opcion no es valida");
                    break;
                
        }
            
        System.out.println("Fin del programa");
            
        }

    }
    
    
    public static int rellenarListaAutomaticamente (double[] lista, int limite){
        /*
         Agregamos que tambien el tamaño de la lista sea un numero al azar diferente de cero
            Es decir entre 1 y el la longitud de la lista
        */
        int numeroElementos = (int) (Math.random()*(lista.length - 1) + 1 );
        for( int i=0; i<numeroElementos; i++){
            lista[i] = (Math.random()*limite);
        }
        
        return numeroElementos;    
    }
    
    
    
    public static void mostrarError(String error){
        System.out.println("-----------------------------------------------------\n");
        System.out.println(error);
        System.out.println("-----------------------------------------------------\n");
    }
    
     public static void mostrarListaHasta (double[] lista, int numeroElementos){
        System.out.println("\n--------------------------------------------");
        System.out.println("La lista de numeros es :");
        System.out.println(armarlistaStringDe(lista, numeroElementos));
        System.out.println("--------------------------------------------\n");
    }
            
    public static String armarlistaStringDe (double[] lista, int numeroElementos){
        
        StringBuilder armarLista = new StringBuilder();
        String numConDosDecimales;
        
        armarLista.append(" | ");
        for(int i=1; i<=numeroElementos ; i++){
            numConDosDecimales = String.format("%.2f", lista[i-1]);
            armarLista.append(numConDosDecimales).append(" | ");
            if(i%10 == 0) armarLista.append("\n").append(" | ");
        }
    
        return armarLista.toString();
    }
    
    
    public static void mostrarOpciones(){
        System.out.println(OPCIONES_STRING);
    }
    
    
    
    
    public static double[] opera_tabla(double[] tabla1, double[] tabla2, int numElemUtiles, char operacion){
        
    double[] tablaResultante = new double[numElemUtiles];
    
    switch(operacion){
        case 's':
            sumarDosTablasEn(tabla1, tabla2, tablaResultante);
            break;
        case 'r':
            restarDosTablasEn(tabla1, tabla2, tablaResultante);
            break;
        case 'm':
            multiplicarDosTablasEn(tabla1, tabla2, tablaResultante);
            break;
        case 'd':
            dividirDosTablasEn(tabla1, tabla2, tablaResultante);
            break;
        default:
            mostrarError("Opcion no valida");
            break;
    }
    
    return tablaResultante;
    }
    
    
    
    public static void sumarDosTablasEn (double[] tabla1, double[] tabla2, double[] tablaResultante ){
        for(int i = 0 ; i<tablaResultante.length ; i++){
            tablaResultante[i] = tabla1[i] + tabla2[i];
        }    
    }
    
    
    public static void restarDosTablasEn (double[] tabla1, double[] tabla2, double[] tablaResultante ){
        for(int i = 0 ; i<tablaResultante.length ; i++){
            tablaResultante[i] = tabla1[i] - tabla2[i];
        }    
    }
    
    
    public static void multiplicarDosTablasEn (double[] tabla1, double[] tabla2, double[] tablaResultante ){
        for(int i = 0 ; i<tablaResultante.length ; i++){
            tablaResultante[i] = tabla1[i] * tabla2[i];
        }    
    }
    
    
    public static void dividirDosTablasEn (double[] tabla1, double[] tabla2, double[] tablaResultante ){
        for(int i = 0 ; i<tablaResultante.length ; i++){
            /*
            Java maneja la division por cero en numeros flotantes, si se hubiera utilizado int, habria que hacer
            la logica para manejar la division por cero y evitar que el programa colapse.
            */
            tablaResultante[i] = tabla1[i] / tabla2[i];
        }    
    }
    
    
}

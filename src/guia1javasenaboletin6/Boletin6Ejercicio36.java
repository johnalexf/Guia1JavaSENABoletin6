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
public class Boletin6Ejercicio36 {
    
    public static final int RB = 1, DB = 2, TB = 3,  AB = 4, CB = 5, PB = 6 ;
    public static final int RN = 11, DN = 12, TN = 13,  AN = 14, CN = 15, PN = 16 ;
    public static final int SF = 0;
    
    public static final int[] FICHAS_NEGRAS = new int[] { DN, TN, AN, CN, PN };
    public static final int[] FICHAS_BLANCAS = new int[] { DB, TB, AB, CB, PB };
    /*
    NOMENCLATURA:
        B - ficha blanca
        N - ficha negra
        R - Rey, D - Dama, T - Torre, A - Alfil, C - Caballo, P - Peon
        S_F - Sin ficha
    */
    
    public static int[][] juego = new int[][]{
        { TN , CN , AN , DN , RN , AN , CN , TN }, // fila 0
        { PN , PN , PN , PN , PN , PN , PN , PN }, // fila 1
        { SF , SF , SF , SF , SF , SF , SF , SF },
        { SF , SF , SF , SF , SF , SF , SF , SF }, 
        { SF , SF , SF , SF , SF , SF , SF , SF },
        { SF , SF , SF , SF , SF , SF , SF , SF },
        { PB , PB , PB , PB , PB , PB , PB , PB },
        { TB , CB , AB , DB , RB , AB , CB , TB }
      // col1  col2 ...
    };
            
            
            
    public static void solucion(){
    
        System.out.println("36. DUF que toma una tabla bidimensional de enteros, representando un tablero de ajedrez. Disponemos\n" +
                "de las constantes PB (peón blanco), TN (torre negra), etc. (P, T, C, A, R, D). Dicho módulo debe\n" +
                "devolver un valor booleano, que indique si el rey negro está amenazado.");
    
        System.out.printf("%n%n El rey %s esta amenzado %n%n", estaReyNegroEnJaque(juego) ? "SI" : "NO");
        
        System.out.printf("%n%n El rey %s esta en jaque mate %n%n", estaReyNegroEnJaqueMate(juego) ? "SI" : "NO");
        
    }
    
    public static boolean estaReyNegroEnJaque (int[][] juego){
    
        int[] posicionReyNegro = buscarPosicionReyNegro(juego);
        int posFila_Rey = posicionReyNegro[0];
        int posCol_Rey = posicionReyNegro[1];
    
        return estaReyNegroAmenazado(juego, posFila_Rey, posCol_Rey);
    
    }
    
    public static boolean estaReyNegroEnJaqueMate (int[][] juego){
    
        if( estaReyNegroEnJaque(juego) ){
        
            int[] posicionReyNegro = buscarPosicionReyNegro(juego);
            int posFila_Rey = posicionReyNegro[0];
            int posCol_Rey = posicionReyNegro[1];
            
            //dejamos la posicion del rey sin ficha para al momento de evaluar las posibilidades de movimiento
            //se tenga en cuenta que el rey ya no esta en esta posicion.
            juego[posFila_Rey][posCol_Rey] = SF;
            
            for(int filaAEvaluar = posFila_Rey - 1 ; filaAEvaluar <= posFila_Rey + 1  ; filaAEvaluar++){
            if( filaOColumnaValida(filaAEvaluar) )
                for(int colAEvaluar = posCol_Rey - 1 ; colAEvaluar <= posCol_Rey + 1 ; colAEvaluar++){
                    
                    if( casillaDentroDeColumnasSinLaPosicionDelRey(posFila_Rey, posCol_Rey, filaAEvaluar, colAEvaluar)){
                        int casilla = juego[filaAEvaluar][colAEvaluar];
                        if(  estaCasillaSinFicha(casilla) || estaCasillaConFichaBlanca(casilla)  )
                            if(!estaReyNegroAmenazado(juego, filaAEvaluar, colAEvaluar)){
                                juego[posFila_Rey][posCol_Rey] = RN;
                               return false;
                            }
                    } 
                }
            }

            juego[posFila_Rey][posCol_Rey] = RN;
            return true;

            
        }
        
        return false;
    
    }
    
    public static boolean estaReyNegroAmenazado (int [][] juego, int posFila_Rey, int posCol_Rey){
    
        for(int filaAEvaluar = posFila_Rey - 1 ; filaAEvaluar <= posFila_Rey + 1  ; filaAEvaluar++){
            if( filaOColumnaValida(filaAEvaluar) )
                for(int colAEvaluar = posCol_Rey - 1 ; colAEvaluar <= posCol_Rey + 1 ; colAEvaluar++){
                    
                    if( casillaDentroDeColumnasSinLaPosicionDelRey(posFila_Rey, posCol_Rey, filaAEvaluar, colAEvaluar))
                       
                        if(verificarAmenazaEnDireccionA(juego, posFila_Rey, posCol_Rey, filaAEvaluar, colAEvaluar ))
                           return true;
                        
                }
        }
    
        return false;
    }
    
    public static boolean casillaDentroDeColumnasSinLaPosicionDelRey (int reyFila, int reyCol , int filaAEvaluar, int colAEvaluar){
        return ( (filaOColumnaValida(colAEvaluar))  &&  !(filaAEvaluar == reyFila && colAEvaluar == reyCol ) );
    }
    
    public static boolean filaOColumnaValida(int filaOCol){
        return  (filaOCol >= 0 && filaOCol <= 7);
    }
    
    
    public static int[] buscarPosicionReyNegro( int[][] juego){
    
        for(int fila=0; fila < 8 ; fila++){
            for(int col=0; col < 8 ; col++){
                if( juego [fila][col] == RN )
                     return new int[] {fila, col};
            }
        }
        
        return new int[] {-1, -1};
    }
    
    public static boolean verificarAmenazaEnDireccionA(int[][] juego, int reyFila, int reyCol , int filaAEValuar, int colAEvaluar){
        
        if(reyFila == filaAEValuar)            
            return verificarAmenazaEnCasillasRectasSegunEje(
                                juego,
                                filaAEValuar, 
                                colAEvaluar, 
                                definirSentido(reyCol, colAEvaluar),
                                false
            );
        
        
        if(reyCol == colAEvaluar)
            return verificarAmenazaEnCasillasRectasSegunEje(
                                juego,
                                colAEvaluar, 
                                filaAEValuar, 
                                definirSentido(reyFila, filaAEValuar),
                                true
            );
        
        return verificarAmenazasSegunCuadrante(
                                juego, 
                                filaAEValuar, 
                                colAEvaluar, 
                                definirSentido(reyFila, filaAEValuar), 
                                definirSentido(reyCol, colAEvaluar), 
                                verificarPeonBlanco(reyFila, filaAEValuar)
        );
    }
    
    
    public static int definirSentido(int posicionRey, int posicionSiguiente){
        return (posicionRey>posicionSiguiente)? -1 : 1;
    }
    
    
    public static boolean verificarAmenazaEnCasillasRectasSegunEje(int[][] juego, int posFija, int posVariable, int sentido, boolean esVariableFila){

        while( filaOColumnaValida(posVariable) ){
            
            int casillaAEvaluar = (esVariableFila)? juego[posVariable][posFija] : juego[posFija][posVariable] ;

            if( !estaCasillaSinFicha(casillaAEvaluar) )
                if( estaCasillaConFichaNegra( casillaAEvaluar ) ) return false;
                else return ( ( estaDamaBlanca(casillaAEvaluar) )||( estaTorreBlanca(casillaAEvaluar) ) ) ;
                 
            posVariable += sentido;
            
        }
        
        return false;
        
    }
    
    public static boolean verificarAmenazasSegunCuadrante (int[][] juego, int filaAVerificar, int colAVerificar, int sentidoFila, int sentidoColumna, boolean verificarPeon){
        
        if (verificarAmenazaEnCasillasDiagonales(
                                juego, 
                                filaAVerificar, 
                                colAVerificar, 
                                sentidoFila, 
                                sentidoColumna, 
                                verificarPeon )
            )
            return true;
        else
            return verificarAmenazaCaballosEnDireccionDiagonal(
                                juego, 
                                filaAVerificar, 
                                colAVerificar, 
                                sentidoFila, 
                                sentidoColumna );
        
    }
    
     
    public static boolean verificarAmenazaEnCasillasDiagonales(int[][] juego, int filaAVerificar, int colAVerificar, int sentidoFila, int sentidoColumna, boolean verificarPeon){
        
        while( filaOColumnaValida(filaAVerificar) && filaOColumnaValida(colAVerificar) ){
            
            int casillaAEvaluar = juego[filaAVerificar][colAVerificar];
            
            if( !estaCasillaSinFicha(casillaAEvaluar) )
                if( estaCasillaConFichaNegra( casillaAEvaluar ) ) return false;
                else{
                    if(verificarPeon){
                        if (estaPeonBlanco(casillaAEvaluar)) return true;
                    }
                    return ( estaAlfilBlanco(casillaAEvaluar) || estaDamaBlanca(casillaAEvaluar) );
                }
                 
            filaAVerificar += sentidoFila;
            colAVerificar += sentidoColumna;
            verificarPeon = false;
            
        }
        
        return false;
        
    }
    
    public static boolean verificarAmenazaCaballosEnDireccionDiagonal (int[][] juego, int filaAVerificar, int colAVerificar, int sentidoFila, int sentidoColumna){
        
        return verificarAmenazaCaballo(juego, filaAVerificar, colAVerificar + sentidoColumna) ||
                verificarAmenazaCaballo(juego, filaAVerificar + sentidoFila, colAVerificar) ;
        
    }
    
    public static boolean verificarAmenazaCaballo (int[][] juego, int filaAVerificar, int colAVerificar){
    
        if( filaOColumnaValida(filaAVerificar) && filaOColumnaValida(colAVerificar) ){
            int casillaAEvaluar = juego[filaAVerificar][colAVerificar];
            return estaCaballoBlanco(casillaAEvaluar);
        }
        return false;
    }
    
    
    
     
   
    public static boolean estaCasillaSinFicha(int casilla){
        return casilla == SF;
    }
    
    public static boolean estaCasillaConFichaNegra( int casilla ){
        for( int fichaNegra : FICHAS_NEGRAS){
            if(fichaNegra == casilla) return true;
        }
        return false;
    }
    
    public static boolean estaCasillaConFichaBlanca( int casilla ){
        for( int fichaBlanca : FICHAS_BLANCAS){
            if(fichaBlanca == casilla) return true;
        }
        return false;
    }
    
    public static boolean estaDamaBlanca (int casilla){
        return casilla == DB;
    }
    
    public static boolean estaTorreBlanca (int casilla){
        return casilla == TB;
    }
    
    public static boolean estaAlfilBlanco (int casilla){
        return casilla == AB;
    }
    
    public static boolean estaPeonBlanco (int casilla){
        return casilla == PB;
    }
    
    public static boolean verificarPeonBlanco ( int reyFila , int filaAEValuar){
        return filaAEValuar == reyFila + 1;
    }
    
    public static boolean estaCaballoBlanco (int casilla){
        return casilla == CB;
    }
    
    
}

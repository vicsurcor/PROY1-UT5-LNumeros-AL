/**
 * Un objeto de esta clase
 * guarda una lista de n?meros enteros
 * 
 * La clase incluye una serie de m?todos de instancia
 * para hacer operaciones sobre la lista
 * y dos  m?todos est?ticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author -
 */


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;



public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private int[] lista;

    private int pos;

    private static final Random generador = new Random();
    //TODO
    
    

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * param: n el tama�o m�ximo de la lista
     */
    public ListaNumeros(int n) {
        //TODO

        lista = new int[n];
        pos = 0;
    }

    /**
     * A�ade un valor al final de la lista
     * siempre que no est� completa
     *
     * @param numero el valor que se a�ade.
     * @return true si se ha podido a�adir, false en otro caso
     */
    public boolean addElemento(int numero) {
        //TODO

        if (!estaCompleta()){

            lista[pos] = numero;
            pos++;
            return true;
        }
        else {

            return false;
        }

    }

    /**
     * @return true si la lista est� completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        //TODO

       while (pos == lista.length){
           return true;
       }
        return false;
    }

    /**
     * @return true si la lista est� vac�a, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
       //TODO

        while (!estaCompleta()){
            return true;
        }
        return false;
    }

    /**
     * @return el n� de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        //TODO

        return pos;

    }

    /**
     * Vac�a la lista
     */
    public void vaciarLista() {
       //TODO
//        for (int i = pos;i > 0; i--){
//            lista[i] = 0;
//        }

        pos = 0;
    }

    /**
     * @return una cadena con representaci�n textual de la lista
     * (leer enunciado)
     * 
     * Si la lista est� vac�a devuelve ""
     */
    public String toString() {
       //TODO
        int e = 0;
        String res = "";
        String cab = String.valueOf(CAR_CABECERA) + String.valueOf(CAR_CABECERA) + String.valueOf(CAR_CABECERA) + String.valueOf(CAR_CABECERA) + String.valueOf(CAR_CABECERA) + String.valueOf(CAR_CABECERA);
        while (e < pos){
            res += cab;
            e++;
        }
        e = 0;
        res += "\n";
        if (pos == 0){

            return "";
        }
        else {
            for (int i = 0; i < pos; i++){
                res += Utilidades.centrarNumero(lista[i], ANCHO_FORMATO);
            }
            res += "\n";
            while (e < pos){
                res += cab;
                e++;
            }
        }
        return res;
    }

     

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor m�ximo en la lista
     * Cuando no haya un segundo m�ximo el m�todo
     * devolver� el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {
       //TODO
            int max = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < pos; i++){
            if (lista[i] > max){ //Es un nuevo primer m�ximo
                max2 = max; //El segundo m�ximo pasa a ser el antiguo primer m�ximo
                max = lista[i];//Actualizo el nuevo primer m�ximo
            }
            else if (lista[i]> max2 && lista[i]<max) {//Si el n�mero est� entre max2 y max
                max2 = lista[i];//S�lo actualizamos el segundo m�ximo
            }
        }
        return max2;
    }

    /**
     * El m�todo coloca los valores que son segundos m�ximos al principio de
     * la lista respetando el orden de aparici�n del resto de elementos
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos m�ximos
     *          false si no se han colocado los segundos m�ximos porque no hab�a ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        //TODO
        int ins = 0;
        int camb;
        if (segundoMaximo() != Integer.MIN_VALUE) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == segundoMaximo()) {
                    camb = lista[i];
                    lista[i] = 0; //Esto no aporta nada
                    for (int j = i; j > 0; j--) {
                        lista[j] = lista[j - 1];
                    }
                    lista[ins] = camb;
                    ins++;
                }
            }
          return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param numero b�squeda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posici�n en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente m�todos de la clase Arrays
     */
    public int buscarBinario(int numero) {
         //TODO

        int[] listacop = Arrays.copyOf(lista,pos);
        Arrays.sort(listacop);
        int index = Arrays.binarySearch(listacop,numero);
        //return index;
        if(index>=0){
            return index;
        }
        else return -1;
    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tama�o DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int[][] crearBrillos() {
       //TODO

        int[][] brillos = new int[DIMENSION][DIMENSION];
       for (int i = 0; i < brillos.length; i++){
           for (int j = 0; j < brillos[i].length; j++){
               //int num = generador.nextInt(10) + 1;
               int num = generador.nextInt(11);
               brillos[i][j] = num;
           }
       }
        return brillos;
    }

    /**
     * @param  array bidimensional brillos
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posici�n f,c del array brillos es una estrella
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public static boolean[][] detectarEstrellas(int[][] brillos) {
       //TODO

        boolean[][] est = new boolean[brillos.length][brillos[0].length];
       for (int i = 1; i < brillos.length - 1;i++){
           for (int j = 1; j < brillos[i].length - 1; j++){
               if ((brillos[i-1][j] + brillos[i+1][j] + brillos[i][j-1] + brillos[i][j+1]) > 30){
                   est[i][j] = true;
               }
               else {
                   est[i][j] = false;
               }
           }
       }
       return est;
    }

}

package metodos;
import impl.ColaPrioridadMinHeap;
import impl.NodoHuffman;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class Huffman {
    public static NodoHuffman crearHoja(String x, float prioridad){
        NodoHuffman elemento = new NodoHuffman();
        elemento.probabilidad = prioridad;
        elemento.info = x;
        return elemento;
    }

    public static NodoHuffman fusionNodoHuffman (NodoHuffman x, NodoHuffman y){
        NodoHuffman aux = new NodoHuffman();
        aux.hijoIzq = x;
        aux.hijoDer = y;
        aux.info = x.info + y.info;
        aux.probabilidad = x.probabilidad + y.probabilidad;
        return aux;
    }
    
    public static NodoHuffman crearArbol(DiccionarioSimpleTDA diccionarioVP){

        ColaPrioridadMinHeap colaP  = new ColaPrioridadMinHeap();
        colaP.InicializarCola();
        int i=0;
        ConjuntoTDA claves = diccionarioVP.Claves();
        while(!claves.ConjuntoVacio()){
            String eleccion = claves.Elegir();
            colaP.AcolarPrioridad(crearHoja(eleccion, diccionarioVP.Recuperar(eleccion)));
            claves.Sacar(eleccion);
            i++;
        }
        
        for (int j = 0; j < i-1; j++) {
            NodoHuffman x1 = colaP.Primero();
            colaP.Desacolar();
            NodoHuffman x2 = colaP.Primero();
            colaP.Desacolar();

            colaP.AcolarPrioridad(fusionNodoHuffman(x1, x2));
        }
            
        return colaP.Primero();
    }
}

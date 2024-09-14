package metodos;

import impl.MinHeap;
import impl.NodoHuffman;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import api.HeapTDA;

public class Huffman {
    public static NodoHuffman crearHoja(String x, float prioridad){
        NodoHuffman elemento = new NodoHuffman();
        elemento.probabilidad = prioridad;
        elemento.info = x;
        elemento.hijoIzq = new NodoHuffman();
        elemento.hijoDer = new NodoHuffman();
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
        HeapTDA heap = new MinHeap();
        heap.InicializarHeap();

        int i=0;
        ConjuntoTDA claves = diccionarioVP.Claves();
        while(!claves.ConjuntoVacio()){
            String eleccion = claves.Elegir();
            heap.Agregar(crearHoja(eleccion, diccionarioVP.Recuperar(eleccion)));
            claves.Sacar(eleccion);
            i++;
        }
        
        for (int j = 0; j < i-1; j++) {
            NodoHuffman x1 = heap.Primero();
            heap.Sacar();
            NodoHuffman x2 = heap.Primero();
            heap.Sacar();

            heap.Agregar(fusionNodoHuffman(x1, x2));
        }
            
        return heap.Primero();
    }
}

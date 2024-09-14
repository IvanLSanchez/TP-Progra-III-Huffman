package metodos;

import impl.MinHeap;
import impl.NodoHuffman;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import api.HeapTDA;

public class Huffman {
    public static NodoHuffman crearHojaArbolHuffman(String info, float prioridad){
        NodoHuffman elemento = new NodoHuffman();
        elemento.probabilidad = prioridad;
        elemento.info = info;
        elemento.hijoIzq = new NodoHuffman();
        elemento.hijoDer = new NodoHuffman();
        return elemento;
    }

    public static NodoHuffman fusionNodosHuffman (NodoHuffman x, NodoHuffman y){
        NodoHuffman aux = new NodoHuffman();
        aux.hijoIzq = x;
        aux.hijoDer = y;
        aux.info = x.info + y.info;
        aux.probabilidad = x.probabilidad + y.probabilidad;
        return aux;
    }
    
    public static NodoHuffman crearArbol(DiccionarioSimpleTDA diccionarioVP){
        HeapTDA colaPrioridadProbabilidadMin = new MinHeap();
        colaPrioridadProbabilidadMin.InicializarHeap();

        int i=0;
        ConjuntoTDA claves = diccionarioVP.Claves();
        while(!claves.ConjuntoVacio()){
            String eleccion = claves.Elegir();
            colaPrioridadProbabilidadMin.Agregar(crearHojaArbolHuffman(eleccion, diccionarioVP.Recuperar(eleccion)));
            claves.Sacar(eleccion);
            i++;
        }
        
        for (int j = 0; j < i-1; j++) {
            NodoHuffman x1 = colaPrioridadProbabilidadMin.Primero();
            colaPrioridadProbabilidadMin.Sacar();
            NodoHuffman x2 = colaPrioridadProbabilidadMin.Primero();
            colaPrioridadProbabilidadMin.Sacar();

            colaPrioridadProbabilidadMin.Agregar(fusionNodosHuffman(x1, x2));
        }
            
        return colaPrioridadProbabilidadMin.Primero();
    }
}

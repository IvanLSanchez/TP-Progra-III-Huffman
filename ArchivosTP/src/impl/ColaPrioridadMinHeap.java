package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadMinHeap implements ColaPrioridadTDA{
    MinHeap heap;
    int cont;
    
    public void InicializarCola() {
        heap = new MinHeap();
        heap.InicializarHeap();
    }
    
    public boolean ColaVacia() {
        return heap.HeapVacio();
    }

    
    public void AcolarPrioridad(NodoHuffman arbol) {
       heap.Agregar(arbol);
    }

    
    public void Desacolar() {
        heap.Sacar();
    }

  
    public NodoHuffman Primero() {
        return heap.Primero();
    }

    
    public float Prioridad() {
        return heap.Primero().probabilidad;
    }

}

package api;

import impl.NodoHuffman;

public interface ColaPrioridadTDA {
    void InicializarCola();
    void AcolarPrioridad(NodoHuffman arbol);
    void Desacolar();
    NodoHuffman Primero();
    boolean ColaVacia();
    float Prioridad();
}

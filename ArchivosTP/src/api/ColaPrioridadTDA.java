package api;

import impl.NodoHuffman;

public interface ColaPrioridadTDA {
    void InicializarCola();
    void AcolarPrioridad(String x, int prioridad);
    void Desacolar();
    NodoHuffman Primero();
    boolean ColaVacia();
    float Prioridad();
}
